package com.agilitysolutions.mapping.geocoding.library

class BoundsTest extends GroovyTestCase {
    private Bounds _bounds;
    private Location _northeast;
    private Location _southwest;

    void setUp() {
        super.setUp()

        _bounds = new Bounds();

        _southwest = new Location();
        _southwest.setLatitude(BigDecimal.valueOf(34.172684));
        _southwest.setLongitude(BigDecimal.valueOf(-118.604794));

        _northeast = new Location();
        _northeast.setLatitude(BigDecimal.valueOf(34.236144));
        _northeast.setLongitude(BigDecimal.valueOf(-118.500938));
    }

    void testSetGetSouthwest() {
        _bounds.setSouthwest(_southwest);

        assertEquals(BigDecimal.valueOf(34.172684), _bounds.getSouthwest().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.604794), _bounds.getSouthwest().getLongitude());
    }

    void testSetGetNortheast() {
        _bounds.setNortheast(_northeast);

        assertEquals(BigDecimal.valueOf(34.236144), _bounds.getNortheast().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.500938), _bounds.getNortheast().getLongitude());
    }
}
