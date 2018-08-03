package com.assigment.nytimespromobi.facade;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

public class StoryViewModel extends AndroidViewModel {

    private Application mContext;
    private Repository mRepository;

    public StoryViewModel(Application context) {
        super(context);
        this.mContext = context;
        mRepository = new Repository(mContext);
    }

    public void getStories() {
        mRepository.getStories();
    }

}
