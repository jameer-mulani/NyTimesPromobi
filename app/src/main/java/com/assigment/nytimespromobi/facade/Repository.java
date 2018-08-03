package com.assigment.nytimespromobi.facade;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.assigment.nytimespromobi.network.StoryApiClient;
import com.assigment.nytimespromobi.network.StoryApiService;
import com.assigment.nytimespromobi.network.model.StoryResponse;
import com.assigment.nytimespromobi.util.PreferenceUtil;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Repository {

    private static final String TAG = "Repository";

    private Context mContext;
    private StoryApiService mStoryApiService;


    public Repository(Context context) {
        this.mContext = context;
        Retrofit retrofit = StoryApiClient.getApiClient();
        mStoryApiService = retrofit.create(StoryApiService.class);
    }


    public void getStories() {

        String apiKey = PreferenceUtil.getStoryApiKey(mContext);
        if (!TextUtils.isEmpty(apiKey)) {

            mStoryApiService.fetchAllStories(apiKey)
                    .subscribeOn(Schedulers.io())
                    .subscribeWith(new SingleObserver<StoryResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            //called when subscribe
                        }

                        @Override
                        public void onSuccess(StoryResponse storyResponse) {

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
