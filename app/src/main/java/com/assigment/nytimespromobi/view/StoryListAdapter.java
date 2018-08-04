package com.assigment.nytimespromobi.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assigment.nytimespromobi.R;
import com.assigment.nytimespromobi.db.model.StoryEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.StoryViewHolder> {

    private static final String TAG = "StoryListAdapter";
    private LayoutInflater mInflater;
    private List<StoryEntity> allStories;

    public StoryListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void setAllStories(List<StoryEntity> allStories) {
        this.allStories = allStories;
        notifyDataSetChanged();
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.story_list_item, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StoryViewHolder holder, int position) {


        StoryEntity story = allStories.get(position);
        holder.sectionTextview.setText(story.getSection());
        holder.storyTitleTextview.setText(story.getTitle());
        holder.publishedDateTextView.setText(formatDate(story.getPublishedDate()));
        holder.storyByLineTextview.setText(story.getByLine());
        holder.storyAbstract.setText(story.getStoryAbstract());


    }

    private String formatDate(String rawDate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try {
            date = dateFormat.parse(rawDate);
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm");
            return dateFormat1.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d(TAG, "date format exception:" + e.toString());
        }
        return "";
    }

    @Override
    public int getItemCount() {
        return allStories == null ? 0 : allStories.size();
    }

    public static class StoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.section_textview)
        TextView sectionTextview;

        @BindView(R.id.story_thumbnail)
        ImageView storyThumbnail;

        @BindView(R.id.story_title_tv)
        TextView storyTitleTextview;

        @BindView(R.id.story_abstact_tv)
        TextView storyAbstract;

        @BindView(R.id.by_line_tv)
        TextView storyByLineTextview;

        @BindView(R.id.published_date_tv)
        TextView publishedDateTextView;

        public StoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
