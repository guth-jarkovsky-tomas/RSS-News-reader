package com.example.recyclerview;

/**
 * Created by TOMAS on 13.10.2017.
 */

public class FeedItem {

    private String title;
    private String description;
    private String imgURL;
    private String URL;

    public FeedItem(String title, String description, String imgURL, String URL) {
        this.title = title;
        this.description = description;
        this.imgURL = imgURL;
        this.URL = URL;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImgURL() {
        return imgURL;
    }  // not in use yet, but definately will

    public String getURL() {
        return URL;
    }
}
