package com.assigment.nytimespromobi.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoryResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("last_updated")
    private String lastUpdated;

    @SerializedName("num_results")
    private int resultCount;

    @SerializedName("results")
    private List<Story> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Story> getResults() {
        return results;
    }

    public void setResults(List<Story> results) {
        this.results = results;
    }
}
