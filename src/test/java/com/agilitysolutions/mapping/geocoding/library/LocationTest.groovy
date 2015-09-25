package com.agilitysolutions.mapping.geocoding.library

class LocationTest extends GroovyTestCase {
    private Location _location;

    void setUp() {
        super.setUp()

        _location = new Location();
    }

    void testSetGetLatitude() {
        _location.setLatitude(BigDecimal.valueOf(34.172684));

        assertEquals(BigDecimal.valueOf(34.172684), _location.getLatitude());
    }

    void testSeGettLongitude() {
        _location.setLongitude(BigDecimal.valueOf(-118.604794));

        assertEquals(BigDecimal.valueOf(-118.604794), _location.getLongitude());
    }
}
