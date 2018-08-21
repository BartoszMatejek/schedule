package com.ztm.schedule.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {
    @JsonProperty("value")
    private String value;
    @JsonProperty("key")
    private String key;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Value{" +
                "value='" + value + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}