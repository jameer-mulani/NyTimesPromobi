package com.assigment.nytimespromobi.util;

import android.support.annotation.NonNull;

import com.assigment.nytimespromobi.db.model.StoryEntity;
import com.assigment.nytimespromobi.db.model.StoryMultimediaEntity;
import com.assigment.nytimespromobi.network.model.Story;
import com.assigment.nytimespromobi.network.model.StoryMultimedia;

public class EntityBinder {

    private EntityBinder() {

    }

    public static StoryEntity bind(@NonNull Story nwStoryModel) {

        StoryEntity storyEntity = new StoryEntity();
        storyEntity.setByLine(nwStoryModel.getByline());
        storyEntity.setCreatedDate(nwStoryModel.getCreatedDate());
        storyEntity.setItemType(nwStoryModel.getItemType());
        storyEntity.setPublishedDate(nwStoryModel.getPublishedDate());
        storyEntity.setSection(nwStoryModel.getSection());
        storyEntity.setStoryAbstract(nwStoryModel.getAbstractStory());
        storyEntity.setTitle(nwStoryModel.getTitle());
        storyEntity.setUpdatedType(nwStoryModel.getUpdatedDate());
        storyEntity.setUrl(nwStoryModel.getUrl());
        return storyEntity;
    }

    public static StoryMultimediaEntity bind(@NonNull StoryMultimedia storyMultimedia) {

        StoryMultimediaEntity entity = new StoryMultimediaEntity();
        entity.setCopyright(storyMultimedia.getCopyright());
        entity.setFormat(storyMultimedia.getFormat());
        entity.setHeight(storyMultimedia.getHeight());
        entity.setWidth(storyMultimedia.getWidth());
        entity.setType(storyMultimedia.getType());
        entity.setUrl(storyMultimedia.getUrl());
        return entity;
    }

}
