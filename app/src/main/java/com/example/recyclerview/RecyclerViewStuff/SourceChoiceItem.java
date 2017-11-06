package com.example.recyclerview.RecyclerViewStuff;

/**
 * Created by TOMAS on 6.11.2017.
 */

public class SourceChoiceItem {

    public SourceChoiceItem(String name, boolean allowed) {
        Name = name;
        this.allowed = allowed;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    boolean getAllowed() {
        return allowed;
    }

    private String Name;
    private boolean allowed;

}
