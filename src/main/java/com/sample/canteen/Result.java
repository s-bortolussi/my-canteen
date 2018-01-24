package com.sample.canteen;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private Map<String, Object> parameters;

    public Result() {
    }

    public Result(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return "Result{" +
                "parameters=" + parameters +
                '}';
    }
}
