package com.agilitysolutions.mapping.geocoding.services;

import com.agilitysolutions.mapping.interfaces.geocoding.services.IGeocoderProviderService;
import com.google.code.geocoder.Geocoder;

import java.security.InvalidKeyException;

public class GeocoderProviderService implements IGeocoderProviderService {
    public Geocoder getGeocoder() {
        return new Geocoder();
    }

    public Geocoder getGeocoder(String clientId, String clientKey) throws InvalidKeyException {
        return new Geocoder(clientId, clientKey);
    }
}
