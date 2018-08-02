package com.assigment.nytimespromobi.network;

import com.assigment.nytimespromobi.app.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Network api retrofit client responsible to for performing network related operations.
 */
public class StoryApiClient {

    //Define timeout
    private static final int READ_TIMEOUT = 60 * 1000;//60 SECS
    private static final int CONNECT_TIMEOUT = 60 * 1000;//60 SECS
    private static final int WRITE_TIMEOUT = 60 * 1000;//60 SECS

    private static Retrofit mRetrofitClient;

    //private constructor
    private StoryApiClient() {
    }

    public static Retrofit getApiClient() {

        if (mRetrofitClient == null) {

            //build okHttp client
            OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .build();

            //build retrofit2 client
            mRetrofitClient = new Retrofit.Builder()
                    .baseUrl(Constants.TOP_STORY_BASE_URL)
                    .client(mOkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        }
        return mRetrofitClient;
    }
}
