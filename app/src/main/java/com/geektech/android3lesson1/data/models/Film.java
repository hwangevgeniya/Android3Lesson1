package com.geektech.android3lesson1.data.models;

import com.google.gson.annotations.SerializedName;

public class Film {

    private String id;
    private String title;
    private String description;
    @SerializedName("original_title")
    private String originalTitle;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }
}
