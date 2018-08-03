package com.assigment.nytimespromobi.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "story_multimedia_table", foreignKeys =
@ForeignKey(entity = StoryEntity.class, parentColumns = "_id", childColumns = "story_id", onDelete = ForeignKey.CASCADE))
public class StoryMultimediaEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "story_mm_id")
    int mStoryMultimediaId;

    @ColumnInfo(name = "format")
    String mFormat;

    @ColumnInfo(name = "height")
    int mHeight;

    @ColumnInfo(name = "width")
    int mWidth;

    @ColumnInfo(name = "type")
    String mType;

    @ColumnInfo(name = "copyright")
    String mCopyright;

    @ColumnInfo(name = "story_id")
    String mStoryId;

    public String getStoryId() {
        return mStoryId;
    }

    public void setStoryId(String mStoryId) {
        this.mStoryId = mStoryId;
    }

    @NonNull
    public int getStoryMultimediaId() {
        return mStoryMultimediaId;
    }

    public void setStoryMultimediaId(@NonNull int mStoryMultimediaId) {
        this.mStoryMultimediaId = mStoryMultimediaId;
    }

    public String getFormat() {
        return mFormat;
    }

    public void setFormat(String mFormat) {
        this.mFormat = mFormat;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int mHeight) {
        this.mHeight = mHeight;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        this.mWidth = width;
    }

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public String getCopyright() {
        return mCopyright;
    }

    public void setCopyright(String mCopyright) {
        this.mCopyright = mCopyright;
    }
}
