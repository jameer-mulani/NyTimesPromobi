package com.assigment.nytimespromobi.network.model;

import com.google.gson.annotations.SerializedName;

public class StoryMultimedia {

    @SerializedName("url")
    private String url;

    @SerializedName("format")
    private String format;

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
