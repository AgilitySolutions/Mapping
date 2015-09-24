package com.agilitysolutions.mapping.geocoding.library;


import com.agilitysolutions.mapping.geocoding.library.enums.LocationType;

public class Geometry {
    private Location _location;
    private LocationType _locationType;
    private Viewport _viewport;

    public Location getLocation() {
        return _location;
    }

    public void setLocation(Location location) {
        _location = location;
    }

    public LocationType getLocationType() {
        return _locationType;
    }

    public void setLocationType(LocationType locationType) {
        _locationType = locationType;
    }

    public Viewport getViewport() {
        return _viewport;
    }

    public void setViewport(Viewport viewport) {
        _viewport = viewport;
    }
}
