package com.tech_613.podcast.model;

import com.tech_613.podcast.adpter.EditListAdapter;

public class EditCategoryModel {
    private String c_title;
    private String c_description;
    private boolean check;

    public EditCategoryModel(String c_title,String c_description){
        this.c_title=c_title;
        this.c_description=c_description;

    }
    public String getC_title() {
        return c_title;
    }

    public void setC_title(String c_title) {
        this.c_title = c_title;
    }

    public String getC_description() {
        return c_description;
    }

    public void setC_description(String c_description) {
        this.c_description = c_description;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
