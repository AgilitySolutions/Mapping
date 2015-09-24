package com.agilitysolutions.mapping.geocoding.library;

public class Viewport {
    private Location _southwest;
    private Location _northeast;

    public Location getSouthwest() {
        return _southwest;
    }

    public void setSouthwest(Location southwest) {
        _southwest = southwest;
    }

    public Location getNortheast() {
        return _northeast;
    }

    public void setNortheast(Location northeast) {
        _northeast = northeast;
    }
}
