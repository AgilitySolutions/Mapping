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
        _googleGeocodingService.initialize("test client id", "test client key");
        Mockito.verify(_mockRequestHandler, Mockito.times(1)).initialize("test client id", "test client key");
    }

    void testGetGeocode() {
        _googleGeocodingService.getGeocode(_mockRequest);
        Mockito.verify(_mockRequestHandler, Mockito.times(1)).handle(_mockRequest);
    }
}
