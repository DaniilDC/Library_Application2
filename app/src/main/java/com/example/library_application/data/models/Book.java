package com.example.library_application.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "book_table")
public class Book {
    @PrimaryKey(autoGenerate = true)
    private  int id;
    private String name;
    private int flagResource;
    private int priority;

    public Book(String name, int flagResource, int priority) {
        this.name = name;
        this.flagResource = flagResource;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFlagResource() {
        return flagResource;
    }

    public int getPriority() {
        return priority;
    }
}
