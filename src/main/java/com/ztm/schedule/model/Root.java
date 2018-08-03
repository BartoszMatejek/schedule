package com.ztm.schedule.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Root {
    @JsonProperty("result")
    private Iterable<Result> results;

    public Iterable<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Root{" +
                "results=" + results +
                '}';
    }
}
