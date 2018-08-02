package com.assigment.nytimespromobi.network;

import com.assigment.nytimespromobi.network.model.StoryResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit api methods specification for Top Stories.
 */
public interface StoryApiService {

    @GET("home.json")
    Single<StoryResponse> fetchAllStories(@Query("api-key") String storyApiKey);

}
