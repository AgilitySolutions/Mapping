package com.agilitysolutions.mapping.geocoding.library;

public class Bounds {
    private Location southwest;
    private Location northeast;

    public Bounds(Location northeast, Location southwest) {
        this.northeast = northeast;
        this.southwest = southwest;
    }

    public Location getSouthwest() {
        return southwest;
    }

    public Location getNortheast() {
        return northeast;
    }
}
