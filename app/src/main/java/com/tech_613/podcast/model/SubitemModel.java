package com.tech_613.podcast.model;

import java.util.ArrayList;

public class SubitemModel {


    private String title;
    private ArrayList<SeriousModel> seriousModel;
    public SubitemModel(String title,ArrayList<SeriousModel> seriousModel)
    {
        this.title=title;
        this.seriousModel=seriousModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public ArrayList<SeriousModel> getSeriousModel() {
        return seriousModel;
    }

    public void setSeriousModel(ArrayList<SeriousModel> seriousModel) {
        this.seriousModel = seriousModel;
    }

}
