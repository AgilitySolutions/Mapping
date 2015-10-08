package com.agilitysolutions.mapping.interfaces.geocoding.services;

import com.agilitysolutions.mapping.geocoding.library.Request;
import com.agilitysolutions.mapping.geocoding.library.Response;

import java.security.InvalidKeyException;

public interface GeocodingService {
    Response getGeocode(Request request);
    Response getGeocode(Request request, String clientId, String clientKey) throws InvalidKeyException;
}
