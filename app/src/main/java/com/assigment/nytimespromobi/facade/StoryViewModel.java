package com.assigment.nytimespromobi.facade;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.assigment.nytimespromobi.db.model.StoryEntity;

import java.util.List;

public class StoryViewModel extends AndroidViewModel {

    private Application mContext;
    private Repository mRepository;
    private LiveData<List<StoryEntity>> mAllStories;

    public StoryViewModel(Application context) {
        super(context);
        this.mContext = context;
        mRepository = new Repository(mContext);
        mAllStories = mRepository.getAllStories();
    }


    public LiveData<List<StoryEntity>> getAllStories() {
        return mAllStories;
    }
}
