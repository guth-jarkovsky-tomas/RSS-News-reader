package com.example.recyclerview.RecyclerViewStuff;

/**
 * Created by TOMAS on 6.11.2017.
 */

public class SourceChoiceItem {

    private boolean allowed;
    private String Name;

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

    public boolean getAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }
}
