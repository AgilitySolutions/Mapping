package com.agilitysolutions.mapping.geocoding.library;

public class Request {
    private String address;
    private String language;
    private String region;
    private Bounds bounds;
    private Location location;

    public String getAddress() {
        return address;
    }

    public String getLanguage() {
        return language;
    }

    public String getRegion() {
        return region;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public Location getLocation() {
        return location;
    }

    public Request(String address) {
        initialize();
        this.address = address;
    }

    public Request(String address, Bounds bounds) {
        this(address);
        this.bounds = bounds;
    }

    public Request(String address, String region) {
        this(address);
        this.region = region;
    }

    public Request(Location location) {
        initialize();
        this.location = location;
    }

    protected void initialize() {
        this.address = null;
        this.language = "en";
        this.region = null;
        this.bounds = null;
        this.location = null;
    }
}
