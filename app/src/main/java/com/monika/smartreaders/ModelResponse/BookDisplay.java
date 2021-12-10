package com.monika.smartreaders.ModelResponse;


public class BookDisplay {
    private String author,cover,bUri,description,title,bookPath,bookID;
    int nop,nov;
    private int drawableResource;
    boolean Fav;


    public void setFav(boolean fav) {
        Fav = fav;
    }
/*
    @Exclude
    public String getBookID() {
        return bookID;
    }*/

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
/*
    @Exclude
    public String getbookPath() {
        return bookPath;
    }*/

    public void setbookPath(String bookPath) {
        this.bookPath = bookPath;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public BookDisplay(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public BookDisplay() {
    }

    public BookDisplay(String author, String cover, String bUri, String description, String title, int nop, int nov) {
        this.author = author;
        this.cover = cover;
        this.bUri = bUri;
        this.description = description;
        this.title = title;
        this.nop = nop;
        this.nov = nov;
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

    public String getbUri() {
        return bUri;
    }

    public void setbUri(String bUri) {
        this.bUri = bUri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNop() {
        return nop;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }

    public int getNov() {
        return nov;
    }

    public void setNov(int nov) {
        this.nov = nov;
    }

}
