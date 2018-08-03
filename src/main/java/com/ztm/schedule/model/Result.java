package com.ztm.schedule.model;

import java.util.List;

public class Result {

    private List<Value> values;

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Result{" +
                "values=" + values +
                '}';
    }
}
