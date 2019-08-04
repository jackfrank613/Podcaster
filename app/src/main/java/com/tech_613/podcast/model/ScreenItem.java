package com.tech_613.podcast.model;

public class ScreenItem {
    int title;
    int description;
    int screenimage;


    public ScreenItem(int title, int description, int screenimage)
    {
        this.title=title;
        this.description=description;
        this.screenimage=screenimage;

    }
    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getScreenimage() {
        return screenimage;
    }

    public void setScreenimage(int screenimage) {
        this.screenimage = screenimage;
    }


}
