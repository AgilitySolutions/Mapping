package com.agilitysolutions.mapping.geocoding.services;

import com.agilitysolutions.mapping.geocoding.library.Request;
import com.agilitysolutions.mapping.geocoding.library.Response;
import com.agilitysolutions.mapping.geocoding.request.handlers.GoogleGeocoderRequestHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.request.handlers.RequestHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.services.GeocodingService;

import java.security.InvalidKeyException;

public class GoogleGeocodingService implements GeocodingService {
    private RequestHandler requestHandler;

    public GoogleGeocodingService(GoogleGeocoderRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public Response getGeocode(Request request) {
        return requestHandler.handle(request);
    }

    public Response getGeocode(Request request, String clientId, String clientKey) throws InvalidKeyException {
        return requestHandler.handle(request, clientId, clientKey);
    }
}