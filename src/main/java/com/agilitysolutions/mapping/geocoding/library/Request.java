package com.agilitysolutions.mapping.geocoding.library;

public class Request {
    private String _address;
    private String _language;
    private String _region;
    private Bounds _bounds;
    private Location _location;

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public String getLanguage() {
        return _language;
    }

    public void setLanguage(String language) {
        _language = language;
    }

    public String getRegion() {
        return _region;
    }

    public void setRegion(String region) {
        _region = region;
    }

    public Bounds getBounds() {
        return _bounds;
    }

    public void setBounds(Bounds bounds) {
        _bounds = bounds;
    }

    public Location getLocation() {
        return _location;
    }

    public void setLocation(Location location) {
        _location = location;
    }
}
