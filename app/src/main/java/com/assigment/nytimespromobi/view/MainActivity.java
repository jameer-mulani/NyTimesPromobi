package com.assigment.nytimespromobi.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.assigment.nytimespromobi.R;
import com.assigment.nytimespromobi.db.model.StoryEntity;
import com.assigment.nytimespromobi.facade.StoryViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "StoryMainActivity";
    @BindView(R.id.story_recyclerview)
    RecyclerView mStoryList;
    private StoryViewModel mStoryViewModel;
    private StoryListAdapter mStoryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mStoryListAdapter = new StoryListAdapter(this);

        mStoryList.setLayoutManager(new LinearLayoutManager(this));
        mStoryList.setItemAnimator(new DefaultItemAnimator());
        mStoryList.setHasFixedSize(true);
        mStoryList.setAdapter(mStoryListAdapter);

        mStoryViewModel = ViewModelProviders.of(this).get(StoryViewModel.class);

        mStoryViewModel.getAllStories()

                .observe(this, new Observer<List<StoryEntity>>() {
                    @Override
                    public void onChanged(@Nullable List<StoryEntity> storyEntities) {

                        mStoryListAdapter.setAllStories(storyEntities);
                        Log.d(TAG, "stories:" + storyEntities.toString());

                    }
                });
    }
}
