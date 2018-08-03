package com.assigment.nytimespromobi.db.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Represent record in database and act as Entity for Room
 */
@Entity(tableName = "story_table")
public class StoryEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "_id")
    long mId;


    @ColumnInfo(name = "section")
    String mSection;

    @ColumnInfo(name = "title")
    String mTitle;

    @ColumnInfo(name = "abstract")
    String mStoryAbstract;

    @ColumnInfo(name = "url")
    String mUrl;

    @ColumnInfo(name = "by_line")
    String mByLine;

    @ColumnInfo(name = "item_type")
    String mItemType;

    @ColumnInfo(name = "updated_date")
    String mUpdatedType;

    @ColumnInfo(name = "created_date")
    String mCreatedDate;

    @ColumnInfo(name = "published_date")
    String publishedDate;

    @Ignore
    List<StoryMultimediaEntity> mStoryMultimediaEntities;

    @NonNull
    public long getId() {
        return mId;
    }

    public void setId(@NonNull long mId) {
        this.mId = mId;
    }

    public String getSection() {
        return mSection;
    }

    public void setSection(String mSection) {
        this.mSection = mSection;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getStoryAbstract() {
        return mStoryAbstract;
    }

    public void setStoryAbstract(String mStoryAbstract) {
        this.mStoryAbstract = mStoryAbstract;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getByLine() {
        return mByLine;
    }

    public void setByLine(String mByLine) {
        this.mByLine = mByLine;
    }

    public String getItemType() {
        return mItemType;
    }

    public void setItemType(String mItemType) {
        this.mItemType = mItemType;
    }

    public String getUpdatedType() {
        return mUpdatedType;
    }

    public void setUpdatedType(String mUpdatedType) {
        this.mUpdatedType = mUpdatedType;
    }

    public String getCreatedDate() {
        return mCreatedDate;
    }

    public void setCreatedDate(String mCreatedDate) {
        this.mCreatedDate = mCreatedDate;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<StoryMultimediaEntity> getStoryMultimediaEntities() {
        return mStoryMultimediaEntities;
    }

    public void setStoryMultimediaEntities(List<StoryMultimediaEntity> mStoryMultimediaEntities) {
        this.mStoryMultimediaEntities = mStoryMultimediaEntities;
    }
}
