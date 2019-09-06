package com.tech_613.podcast.model;

public class EpisodeModel {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String title;
    private String author;
    private String time;
    public EpisodeModel(String title,String author,String time){

        this.title=title;
        this.author=author;
        this.time=time;
    }
}
