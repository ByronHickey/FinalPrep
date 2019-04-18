/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import controllers.AuthorController;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import models.Author;

/**
 *
 * @author byron
 */

@Path("/authors")
@Stateless
public class AuthorREST {
    
    @Inject
    AuthorController authors;
    
    @GET
    @Produces("application/json")
    public Response getAll() {
        return Response.ok(authors.getAll()).build();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") int id){
        Author result = authors.getById(id);
        if(result != null){
            return Response.ok(result.toJson()).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    @Consumes("application/json")
    public void add(JsonObject author){
        authors.add(author);
        
    }
    
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") int id, JsonObject json){
        authors.edit(id, json);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    public void delete(@PathParam("id") int id){
        authors.delete(id);
    }
}
