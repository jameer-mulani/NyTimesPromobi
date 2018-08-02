package com.assigment.nytimespromobi.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Story {

    @SerializedName("section")
    private String section;

    @SerializedName("title")
    private String title;

    @SerializedName("abstract")
    private String abstractStory;

    @SerializedName("url")
    private String url;

    @SerializedName("byline")
    private String byline;

    @SerializedName("item_type")
    private String itemType;

    @SerializedName("updated_date")
    private String updatedDate;

    @SerializedName("created_date")
    private String createdDate;

    @SerializedName("published_date")
    private String publishedDate;

    @SerializedName("multimedia")
    private List<StoryMultimedia> multimedia;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractStory() {
        return abstractStory;
    }

    public void setAbstractStory(String abstractStory) {
        this.abstractStory = abstractStory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<StoryMultimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<StoryMultimedia> multimedia) {
        this.multimedia = multimedia;
    }
}
