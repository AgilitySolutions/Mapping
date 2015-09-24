package com.agilitysolutions.mapping.geocoding.library;


import com.agilitysolutions.mapping.geocoding.library.enums.LocationType;

public class Geometry {
    private Location location;
    private LocationType locationType;
    private Viewport viewport;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }
}
