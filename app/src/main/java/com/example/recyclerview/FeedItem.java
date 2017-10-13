package com.example.recyclerview;

/**
 * Created by TOMAS on 13.10.2017.
 */

class FeedItem {

    private String title;
    private String description;
    private String imgURL;
    private String URL;

    FeedItem(String title, String description, String imgURL, String URL) {
        this.title = title;
        this.description = description;
        this.imgURL = imgURL;
        this.URL = URL;
    }

    String getTitle() {
        return title;
    }

    String getDescription() {
        return description;
    }

    String getImgURL() {
        return imgURL;
    }

    String getURL() {
        return URL;
    }
}
