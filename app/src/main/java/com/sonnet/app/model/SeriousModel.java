package com.tech_613.podcast.model;

public class SeriousModel {



    private int serious_image;
    private String s_title;
    private String s_body;

    public SeriousModel(int serious_image,String s_title,String s_body)
    {
        this.serious_image=serious_image;
        this.s_title=s_title;
        this.s_body=s_body;
    }

    public int getSerious_image() {
        return serious_image;
    }

    public void setSerious_image(int serious_image) {
        this.serious_image = serious_image;
    }

    public String getS_title() {
        return s_title;
    }

    public void setS_title(String s_title) {
        this.s_title = s_title;
    }

    public String getS_body() {
        return s_body;
    }

    public void setS_body(String s_body) {
        this.s_body = s_body;
    }
}
