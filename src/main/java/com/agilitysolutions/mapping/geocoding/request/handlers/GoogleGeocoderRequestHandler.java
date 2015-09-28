package com.agilitysolutions.mapping.geocoding.request.handlers;

import com.agilitysolutions.mapping.geocoding.library.Request;
import com.agilitysolutions.mapping.geocoding.library.Response;
import com.agilitysolutions.mapping.geocoding.request.builders.GoogleGeocoderRequestBuilder;
import com.agilitysolutions.mapping.geocoding.response.handlers.GoogleGeocodeResponseHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.request.builders.IRequestBuilder;
import com.agilitysolutions.mapping.interfaces.geocoding.request.handlers.IRequestHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.response.handlers.IResponseHandler;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;

import java.security.InvalidKeyException;

public class GoogleGeocoderRequestHandler implements IRequestHandler {
    private Geocoder _geocoder;
    private IRequestBuilder _requestBuilder;
    private IResponseHandler _responseHandler;

    public GoogleGeocoderRequestHandler(Geocoder geocoder,
                                        GoogleGeocoderRequestBuilder requestBuilder,
                                        GoogleGeocodeResponseHandler responseHandler) {
        _geocoder = geocoder;
        _requestBuilder = requestBuilder;
        _responseHandler = responseHandler;
    }

    public void initialize(String clientId, String clientKey) {
        try {
            _geocoder = new Geocoder(clientId, clientKey);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public Response handle(Request request) {
        Object geocoderRequest = _requestBuilder.build(request);
        if (!(geocoderRequest instanceof GeocoderRequest)) {
            return null;
        }

        GeocodeResponse geocoderResponse = _geocoder.geocode((GeocoderRequest) geocoderRequest);
        return _responseHandler.build(geocoderResponse);
    }
}
