package com.tech_613.podcast.model;

public class LocationModel {
    private int flag;
    private String country;
    private String word;

    public LocationModel(int flag,String country,String word){
        this.flag=flag;
        this.country=country;
        this.word=word;

    }
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
