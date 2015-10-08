package com.agilitysolutions.mapping.interfaces.geocoding.services;

import com.google.code.geocoder.Geocoder;

import java.security.InvalidKeyException;

public interface GeocoderProvider {
    Geocoder getGeocoder();
    Geocoder getGeocoder(String clientId, String clientKey) throws InvalidKeyException;
}
