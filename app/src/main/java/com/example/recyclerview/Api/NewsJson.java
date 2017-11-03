package com.example.recyclerview.Api;

import com.example.recyclerview.RecyclerViewStuff.Article;

import java.util.ArrayList;

/**
 * Created by TOMAS on 17.10.2017.
 */

public class NewsJson {

    String status;
    String source;
    String sortby;
    ArrayList<Article> articles;

    public NewsJson(String status, String source, String sortby, ArrayList<Article> articles) {
        this.status = status;
        this.source = source;
        this.sortby = sortby;
        this.articles = articles;
    }

    public NewsJson(NewsJson other) {
        this.status = other.getStatus();
        this.source = other.getSource();
        this.sortby = other.getSortby();
        this.articles = other.getArticles();
    }

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortby() {
        return sortby;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }
}
