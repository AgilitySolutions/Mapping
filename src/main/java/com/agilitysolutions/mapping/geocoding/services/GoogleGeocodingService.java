package com.agilitysolutions.mapping.geocoding.services;

import com.agilitysolutions.mapping.geocoding.library.Request;
import com.agilitysolutions.mapping.geocoding.library.Response;
import com.agilitysolutions.mapping.geocoding.request.handlers.GoogleGeocoderRequestHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.request.handlers.IRequestHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.services.IGeocodingService;

public class GoogleGeocodingService implements IGeocodingService {
    private IRequestHandler requestHandler;

    public GoogleGeocodingService(GoogleGeocoderRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void initialize(String clientId, String clientKey) {
        requestHandler.initialize(clientId, clientKey);
    }

    public Response getGeocode(Request request) {
        return requestHandler.handle(request);
    }

}