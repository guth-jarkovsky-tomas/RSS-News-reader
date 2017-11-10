package com.example.recyclerview.Api;

import java.util.ArrayList;

/**
 * Created by TOMAS on 3.11.2017.
 */

public class SourcesJson {

    private ArrayList<Source> sources;

    public ArrayList<Source> getSources() {
        return sources;
    }

    public void setSources(ArrayList<Source> sources) {
        this.sources = sources;
    }

    public SourcesJson(SourcesJson other) {
        this.sources = other.getSources();
    }
}
