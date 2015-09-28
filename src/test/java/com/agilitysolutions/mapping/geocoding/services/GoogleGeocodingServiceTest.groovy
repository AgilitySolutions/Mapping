package com.agilitysolutions.mapping.geocoding.services

import com.agilitysolutions.mapping.geocoding.library.Request
import com.agilitysolutions.mapping.geocoding.request.handlers.GoogleGeocoderRequestHandler
import org.mockito.Mockito

class GoogleGeocodingServiceTest extends GroovyTestCase {
    private Request _mockRequest;
    private GoogleGeocoderRequestHandler _mockRequestHandler;
    private GoogleGeocodingService _googleGeocodingService;

    void setUp() {
        super.setUp()

        _mockRequest = Mockito.mock(Request.class);
        _mockRequestHandler = Mockito.mock(GoogleGeocoderRequestHandler.class);

        _googleGeocodingService = new GoogleGeocodingService(_mockRequestHandler);
    }

    void testInitialize() {
        String CLIENT_KEY = "test client key";
        String CLIENT_ID = "test client id";

        _googleGeocodingService.initialize(CLIENT_ID, CLIENT_KEY);
        Mockito.verify(_mockRequestHandler, Mockito.times(1)).initialize(CLIENT_ID, CLIENT_KEY);
    }

    void testGetGeocode() {
        _googleGeocodingService.getGeocode(_mockRequest);
        Mockito.verify(_mockRequestHandler, Mockito.times(1)).handle(_mockRequest);
    }
}
