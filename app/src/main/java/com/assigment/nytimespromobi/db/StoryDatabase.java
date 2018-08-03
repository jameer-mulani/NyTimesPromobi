package com.assigment.nytimespromobi.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.assigment.nytimespromobi.db.model.StoryEntity;
import com.assigment.nytimespromobi.db.model.StoryMultimediaEntity;

@Database(entities = {StoryEntity.class, StoryMultimediaEntity.class}, version = 1)
public abstract class StoryDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "story_db";

    private static StoryDatabase mInstance;

    public synchronized static StoryDatabase getInstance(Context context) {

        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(), StoryDatabase.class, DATABASE_NAME)
                    .build();
        }
        return mInstance;

    }

    abstract StoryDao getStoryDao();


}
