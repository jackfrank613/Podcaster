package com.tech_613.podcast.model;

public class DownloadModel {

    private int top_image;
    private String top_time;
    private String top_topic;
    private String top_body;
    private boolean check;

    public DownloadModel(int top_image,String top_topic,String top_body,String top_number,boolean check){
        this.top_image=top_image;
        this.top_topic=top_topic;
        this.top_body=top_body;
        this.top_time=top_number;
        this.check=check;

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

    public void setTop_number(String top_number){
        this.top_time=top_number;
    }

    public String getTop_number(){
        return top_time;
    }

    public boolean getCheck(){
        return check;
    }

}
