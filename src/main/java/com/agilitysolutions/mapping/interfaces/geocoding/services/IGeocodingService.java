package com.agilitysolutions.mapping.interfaces.geocoding.services;

import com.agilitysolutions.mapping.geocoding.library.Request;
import com.agilitysolutions.mapping.geocoding.library.Response;

public interface IGeocodingService {
    void initialize(String clientId, String clientKey);

    Response getGeocode(Request request);
}
