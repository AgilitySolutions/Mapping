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

    void testGetGeocode() {
        _googleGeocodingService.getGeocode(_mockRequest);
        Mockito.verify(_mockRequestHandler, Mockito.times(1)).handle(_mockRequest);
    }

    void testGetGeocodeWithClientIdAndClientKey() {
        _googleGeocodingService.getGeocode(_mockRequest, "Test Client Id", "Test Client Key");
        Mockito.verify(_mockRequestHandler, Mockito.times(1)).handle(_mockRequest, "Test Client Id", "Test Client Key");
    }
}
