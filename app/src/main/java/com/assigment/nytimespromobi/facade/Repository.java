package com.assigment.nytimespromobi.facade;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;

import com.assigment.nytimespromobi.db.StoryDao;
import com.assigment.nytimespromobi.db.StoryDatabase;
import com.assigment.nytimespromobi.db.model.DatabaseHelper;
import com.assigment.nytimespromobi.db.model.StoryEntity;
import com.assigment.nytimespromobi.db.model.StoryMultimediaEntity;
import com.assigment.nytimespromobi.network.StoryApiClient;
import com.assigment.nytimespromobi.network.StoryApiService;
import com.assigment.nytimespromobi.network.model.Story;
import com.assigment.nytimespromobi.network.model.StoryMultimedia;
import com.assigment.nytimespromobi.network.model.StoryResponse;
import com.assigment.nytimespromobi.util.EntityBinder;
import com.assigment.nytimespromobi.util.PreferenceUtil;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Repository {

    private static final String TAG = "Repository";

    private Context mContext;
    private StoryApiService mStoryApiService;
    private StoryDao mStoryDao;
    private LiveData<List<StoryEntity>> mAllStories;


    public Repository(Context context) {
        this.mContext = context;
        Retrofit retrofit = StoryApiClient.getApiClient();
        mStoryApiService = retrofit.create(StoryApiService.class);
        StoryDatabase database = StoryDatabase.getInstance(context);
        mStoryDao = database.getStoryDao();
    }

    private void fetchStories() {
        mAllStories = new DatabaseHelper(mContext).getAllStories();
        if (isNetworkAvailable()) {
            fetchNetworkStories();
        }
    }

    public LiveData<List<StoryEntity>> getAllStories() {
        fetchStories();
        return mAllStories;
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void fetchNetworkStories() {

        String apiKey = PreferenceUtil.getStoryApiKey(mContext);
        if (!TextUtils.isEmpty(apiKey)) {

            mStoryApiService.fetchAllStories(apiKey)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .subscribeWith(new SingleObserver<StoryResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            //called when subscribe
                        }

                        @Override
                        public void onSuccess(StoryResponse storyResponse) {

                            List<Story> results = storyResponse.getResults();

                            if (results != null && !results.isEmpty()) {
                                mStoryDao.clearAllStories();

                                for (Story story : results) {

                                    //insert story
                                    long rowId = mStoryDao.insertStory(EntityBinder.bind(story));

                                    for (StoryMultimedia multimedia : story.getMultimedia()) {

                                        StoryMultimediaEntity entity = EntityBinder.bind(multimedia);
                                        entity.setStoryId(rowId);

                                        //insert multimedia
                                        mStoryDao.insertStoryMultimedia(entity);
                                    }
                                }
                            }


                            Log.d(TAG, "response recieved:" + storyResponse.getResultCount());
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "Error in receiving stories :" + e.toString());

                        }
                    });
        }
    }


}
