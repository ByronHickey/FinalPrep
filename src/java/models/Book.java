/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author byron
 */
public class Book {

    private int id;
    private String synopsis;
    private String title;   
    private Author author;
    
    public Book() {
    }
    
    public Book(int id, String synopsis, String title, Author author) {
        this.id = id;
        this.synopsis = synopsis;
        this.title = title;
        this.author = author;
    }
    
      public Book(JsonObject json) {
        this.id = json.getInt("id", 0);
        this.title = json.getString("title", "");
        this.synopsis = json.getString("synopsis", "");
        this.author = new Author(json.getJsonObject("author"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    
     public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", id)
                .add("title", title)
                .add("synopsis", synopsis)
                .add("author", author.toJson()).
                build();
    }
}
