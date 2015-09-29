package com.agilitysolutions.mapping.geocoding.request.handlers;

import com.agilitysolutions.mapping.geocoding.library.Request;
import com.agilitysolutions.mapping.geocoding.library.Response;
import com.agilitysolutions.mapping.geocoding.request.builders.GoogleGeocoderRequestBuilder;
import com.agilitysolutions.mapping.geocoding.response.handlers.GoogleGeocodeResponseHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.request.builders.IRequestBuilder;
import com.agilitysolutions.mapping.interfaces.geocoding.request.handlers.IRequestHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.response.handlers.IResponseHandler;
import com.agilitysolutions.mapping.interfaces.geocoding.services.IGeocoderProviderService;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;

import java.security.InvalidKeyException;

public class GoogleGeocoderRequestHandler implements IRequestHandler {
    private IGeocoderProviderService _geocoderProviderService;
    private IRequestBuilder _requestBuilder;
    private IResponseHandler _responseHandler;

    public GoogleGeocoderRequestHandler(IGeocoderProviderService geocoderProviderService,
                                        GoogleGeocoderRequestBuilder requestBuilder,
                                        GoogleGeocodeResponseHandler responseHandler) {
        _geocoderProviderService = geocoderProviderService;
        _requestBuilder = requestBuilder;
        _responseHandler = responseHandler;
    }

    public Response handle(Request request) {
        Geocoder geocoder = _geocoderProviderService.getGeocoder();

        return getResponse(request, geocoder);
    }

    public Response handle(Request request, String clientId, String clientKey) throws InvalidKeyException {
        Geocoder geocoder = _geocoderProviderService.getGeocoder(clientId, clientKey);

        return getResponse(request, geocoder);
    }

    private Response getResponse(Request request, Geocoder geocoder) {
        GeocoderRequest geocoderRequest = _requestBuilder.build(request);

        GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
        return _responseHandler.build(geocoderResponse);
    }

}
