package com.agilitysolutions.mapping.geocoding.services

import com.google.code.geocoder.Geocoder

class GeocoderProviderServiceTest extends GroovyTestCase {
    private GeocoderProviderService _geocoderProviderService;

    void setUp() {
        super.setUp()

        _geocoderProviderService = new GeocoderProviderService();
    }

    void testGetGeocoder() {
        Geocoder geocoder = _geocoderProviderService.getGeocoder();

        assertNotNull(geocoder);
    }

    void testGetGeocoder1() {
        Geocoder geocoder = _geocoderProviderService.getGeocoder("Test Client ID", "Test Client Key");

        assertNotNull(geocoder);
    }
}
