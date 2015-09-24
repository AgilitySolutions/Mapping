package com.agilitysolutions.mapping.geocoding.library;

public class Viewport {
    private Location southwest;
    private Location northeast;

    public Viewport(Location northeast, Location southwest) {
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
