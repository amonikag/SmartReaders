package com.monika.smartreaders.ModelResponse;

public class latestRecords {
    String title,description,author,cover;

    public latestRecords(String title, String description, String author, String cover) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.cover = cover;
    }

    public latestRecords() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
