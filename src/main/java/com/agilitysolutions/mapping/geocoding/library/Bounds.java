package com.agilitysolutions.mapping.geocoding.library;

public class Bounds {
    private Location _southwest;
    private Location _northeast;

    public void setSouthwest(Location southwest) {
        _southwest = southwest;
    }

    public Location getSouthwest() {
        return _southwest;
    }

    public void setNortheast(Location northeast) {
        _northeast = northeast;
    }

    public Location getNortheast() {
        return _northeast;
    }
}
