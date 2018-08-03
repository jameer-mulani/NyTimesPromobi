package com.assigment.nytimespromobi.db.model;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.content.Context;
import android.support.annotation.Nullable;

import com.assigment.nytimespromobi.db.StoryDao;
import com.assigment.nytimespromobi.db.StoryDatabase;

import java.util.List;

public class DatabaseHelper {

    private static StoryDao mStoryDao;

    public DatabaseHelper(Context context) {

        StoryDatabase database = StoryDatabase.getInstance(context);
        mStoryDao = database.getStoryDao();

    }

    public LiveData<List<StoryEntity>> getAllStories() {

        LiveData<List<StoryEntity>> stories = mStoryDao.getAllStories();
        stories = Transformations.switchMap(stories, new Function<List<StoryEntity>, LiveData<List<StoryEntity>>>() {
            @Override
            public LiveData<List<StoryEntity>> apply(final List<StoryEntity> input) {

                final MediatorLiveData<List<StoryEntity>> storyLiveData =
                        new MediatorLiveData<>();

                for (final StoryEntity storyEntity : input) {
                    storyLiveData.addSource(mStoryDao.getStoryMultimedia(storyEntity.getId()), new Observer<List<StoryMultimediaEntity>>() {
                        @Override
                        public void onChanged(@Nullable List<StoryMultimediaEntity> storyMultimediaEntities) {

                            storyEntity.setStoryMultimediaEntities(storyMultimediaEntities);
                            storyLiveData.postValue(input);

                        }
                    });
                }

                return storyLiveData;
            }
        });


        return stories;
    }
}
