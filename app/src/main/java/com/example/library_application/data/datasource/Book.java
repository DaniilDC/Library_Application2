package com.example.library_application.data.datasource;

public class Book {
    private String name;
    private int flagResource;

    public Book(String name, int flag) {
        this.name = name;
        this.flagResource = flag;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }
}
