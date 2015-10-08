package com.agilitysolutions.mapping.geocoding.services;

import com.agilitysolutions.mapping.interfaces.geocoding.services.GeocoderProvider;
import com.google.code.geocoder.Geocoder;

import java.security.InvalidKeyException;

public class GeocoderProviderService implements GeocoderProvider {
    public Geocoder getGeocoder() {
        return new Geocoder();
    }

    public Geocoder getGeocoder(String clientId, String clientKey) throws InvalidKeyException {
        return new Geocoder(clientId, clientKey);
    }
}
