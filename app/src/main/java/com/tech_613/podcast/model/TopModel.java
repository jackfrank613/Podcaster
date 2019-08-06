package com.tech_613.podcast.model;

public class TopModel {


    private int top_image;
    private String title;
    private String body;
    public TopModel(int top_image,String title,String body){
        this.top_image=top_image;
        this.title=title;
        this.body=body;
    }
    public int getTop_image() {
        return top_image;
    }

    public void setTop_image(int top_image) {
        this.top_image = top_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
