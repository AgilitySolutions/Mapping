package com.agilitysolutions.mapping.geocoding.library;

import com.agilitysolutions.mapping.geocoding.library.enums.StatusCode;

import java.util.List;

public class Response {
    private StatusCode _statusCode;
    private List<Result> _results;

    public StatusCode getStatusCode() {
        return _statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        _statusCode = statusCode;
    }

    public List<Result> getResults() {
        return _results;
    }

    public void setResults(List<Result> results) {
        _results = results;
    }
}
