package com.agilitysolutions.mapping.geocoding.library.enums;


public enum StatusCode {
    Ok("OK"),                           // indicates that no errors occurred; the address was successfully parsed and at least one geocode was returned
    ZeroResults("ZERO_RESULTS"),        // indicates that the geocode was successful but returned no results. This may occur if the geocode was passed a non-existent address or a latlng in a remote location
    OverQueryLimit("OVER_QUERY_LIMIT"), // indicates that you are over your quota
    RequestDenied("REQUEST_DENIED"),    // indicates that your request was denied, generally because of lack of a sensor parameter
    InvalidRequest("INVALID_REQUEST");  // generally indicates that the query (address or latlng) is missing

    private final String code;

    StatusCode(String code) {
        this.code = code;
    }

    public static StatusCode getValue(String code) {
        for (StatusCode statusCode : StatusCode.values()) {
            if (statusCode.code.equals(code)) {
                return statusCode;
            }
        }

        return null;
    }
}
