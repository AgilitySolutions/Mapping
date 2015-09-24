package com.agilitysolutions.mapping.geocoding.library;

import java.math.BigDecimal;

public class Location {
    private BigDecimal _latitude;
    private BigDecimal _longitude;

    public void setLatitude(BigDecimal latitude) {
        _latitude = latitude;
    }

    public BigDecimal getLatitude() {
        return _latitude;
    }

    public void setLongitude(BigDecimal longitude) {
        _longitude = longitude;
    }

    public BigDecimal getLongitude() {
        return _longitude;
    }
}
