package com.assigment.nytimespromobi.network.model;

import com.google.gson.annotations.SerializedName;

class StoryMultimedia {

    @SerializedName("url")
    private String url;

    @SerializedName("format")
    private String format;

    @SerializedName("height")
    private String height;

    @SerializedName("width")
    private String width;

    @SerializedName("copyright")
    private String copyright;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}