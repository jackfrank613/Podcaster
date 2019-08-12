package com.tech_613.podcast.model;

public class SearchModel {

    private int top_image;
    private String top_topic;
    private String top_body;

    public SearchModel(int top_image,String top_topic,String top_body){
        this.top_image=top_image;
        this.top_topic=top_topic;
        this.top_body=top_body;


    }
    public int getTop_image() {
        return top_image;
    }

    public void setTop_image(int top_image) {
        this.top_image = top_image;
    }

    public String getTop_topic() {
        return top_topic;
    }

    public void setTop_topic(String top_topic) {
        this.top_topic = top_topic;
    }

    public String getTop_body() {
        return top_body;
    }

    public void setTop_body(String top_body) {
        this.top_body = top_body;
    }
}
