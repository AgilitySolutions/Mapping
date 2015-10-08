package com.agilitysolutions.mapping.geocoding.request.handlers;

import com.agilitysolutions.mapping.geocoding.library.Request;
import com.agilitysolutions.mapping.geocoding.library.Response;
import com.agilitysolutions.mapping.geocoding.request.builders.GoogleGeocoderRequestBuilder;
import com.agilitysolutions.mapping.geocoding.response.handlers.GoogleGeocodeResponseHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.request.builders.RequestBuilder;
import com.agilitysolutions.mapping.interfaces.geocoding.request.handlers.RequestHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.response.handlers.ResponseHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.services.GeocoderProvider;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;

import java.security.InvalidKeyException;

public class GoogleGeocoderRequestHandler implements RequestHandler {
    private GeocoderProvider _geocoderProvider;
    private RequestBuilder _requestBuilder;
    private ResponseHandler _responseHandler;

    public GoogleGeocoderRequestHandler(GeocoderProvider geocoderProvider,
                                        GoogleGeocoderRequestBuilder requestBuilder,
                                        GoogleGeocodeResponseHandler responseHandler) {
        _geocoderProvider = geocoderProvider;
        _requestBuilder = requestBuilder;
        _responseHandler = responseHandler;
    }

    public Response handle(Request request) {
        Geocoder geocoder = _geocoderProvider.getGeocoder();

        return getResponse(request, geocoder);
    }

    public Response handle(Request request, String clientId, String clientKey) throws InvalidKeyException {
        Geocoder geocoder = _geocoderProvider.getGeocoder(clientId, clientKey);

        return getResponse(request, geocoder);
    }

    private Response getResponse(Request request, Geocoder geocoder) {
        GeocoderRequest geocoderRequest = _requestBuilder.build(request);

        GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
        return _responseHandler.build(geocoderResponse);
    }

}
