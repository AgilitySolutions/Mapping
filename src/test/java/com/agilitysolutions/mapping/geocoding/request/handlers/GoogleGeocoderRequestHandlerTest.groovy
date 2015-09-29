package com.agilitysolutions.mapping.geocoding.request.handlers

import com.agilitysolutions.mapping.geocoding.library.Request
import com.agilitysolutions.mapping.geocoding.request.builders.GoogleGeocoderRequestBuilder
import com.agilitysolutions.mapping.geocoding.response.handlers.GoogleGeocodeResponseHandler
import com.agilitysolutions.mapping.geocoding.services.GeocoderProviderService
import com.google.code.geocoder.Geocoder
import com.google.code.geocoder.model.GeocodeResponse
import com.google.code.geocoder.model.GeocoderRequest
import org.mockito.Mockito

class GoogleGeocoderRequestHandlerTest extends GroovyTestCase {
    private Request _mockRequest;
    private GeocoderRequest _mockGeocoderRequest;
    private GeocodeResponse _mockGeocodeResponse;

    private GeocoderProviderService _mockGeocoderProviderService;
    private Geocoder _mockGeocoder;
    private GoogleGeocoderRequestBuilder _mockRequestBuilder;
    private GoogleGeocodeResponseHandler _mockResponseHandler;
    private GoogleGeocoderRequestHandler _googleGeocoderRequestHandler;

    void setUp() {
        super.setUp()

        _mockRequest = Mockito.mock(Request.class);
        _mockGeocoderRequest = Mockito.mock(GeocoderRequest.class);
        _mockGeocodeResponse = Mockito.mock(GeocodeResponse.class);

        _mockGeocoderProviderService = Mockito.mock(GeocoderProviderService.class);
        _mockGeocoder = Mockito.mock(Geocoder.class)
        _mockRequestBuilder = Mockito.mock(GoogleGeocoderRequestBuilder.class);
        _mockResponseHandler = Mockito.mock(GoogleGeocodeResponseHandler.class);

        Mockito.when(_mockRequestBuilder.build(_mockRequest)).thenReturn(_mockGeocoderRequest);
        Mockito.when(_mockGeocoderProviderService.getGeocoder()).thenReturn(_mockGeocoder);
        Mockito.when(_mockGeocoderProviderService.getGeocoder("Test Client ID", "Test Client Key")).thenReturn(_mockGeocoder);
        Mockito.when(_mockGeocoder.geocode(_mockGeocoderRequest)).thenReturn(_mockGeocodeResponse);

        _googleGeocoderRequestHandler = new GoogleGeocoderRequestHandler(_mockGeocoderProviderService, _mockRequestBuilder, _mockResponseHandler);
    }

    void testHandle() {
        _googleGeocoderRequestHandler.handle(_mockRequest);

        Mockito.verify(_mockGeocoderProviderService, Mockito.times(1)).getGeocoder();
        Mockito.verify(_mockRequestBuilder, Mockito.times(1)).build(_mockRequest);
        Mockito.verify(_mockGeocoder, Mockito.times(1)).geocode(_mockGeocoderRequest);
        Mockito.verify(_mockResponseHandler, Mockito.times(1)).build(_mockGeocodeResponse);
    }

    void testHandleWotjClientIdAndClientKey() {
        _googleGeocoderRequestHandler.handle(_mockRequest, "Test Client ID", "Test Client Key");

        Mockito.verify(_mockGeocoderProviderService, Mockito.times(1)).getGeocoder("Test Client ID", "Test Client Key");
        Mockito.verify(_mockRequestBuilder, Mockito.times(1)).build(_mockRequest);
        Mockito.verify(_mockGeocoder, Mockito.times(1)).geocode(_mockGeocoderRequest);
        Mockito.verify(_mockResponseHandler, Mockito.times(1)).build(_mockGeocodeResponse);
    }
}
