package com.assigment.nytimespromobi.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.assigment.nytimespromobi.db.model.StoryEntity;
import com.assigment.nytimespromobi.db.model.StoryMultimediaEntity;

import java.util.List;

@Dao
public interface StoryDao {

    @Insert
    void insertStories(StoryEntity... stories);

    @Insert
    void insertStoryMultimedia(StoryMultimediaEntity... storyMultimedia);

    @Delete
    void deleteStories(StoryEntity... stories);

    @Query("SELECT * FROM story_table")
    LiveData<List<StoryEntity>> getAllStories();

    @Query("SELECT * FROM story_multimedia_table where story_id = :storyId")
    LiveData<List<StoryMultimediaEntity>> getStoryMultimedia(int storyId);
}
