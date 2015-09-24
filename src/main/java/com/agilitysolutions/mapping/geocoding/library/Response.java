package com.agilitysolutions.mapping.geocoding.library;

import com.agilitysolutions.mapping.geocoding.library.enums.StatusCode;

import java.util.List;

public class Response {
    private StatusCode statusCode;
    private List<Result> Results;

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public List<Result> getResults() {
        return Results;
    }

    public void setResults(List<Result> results) {
        Results = results;
    }
}
