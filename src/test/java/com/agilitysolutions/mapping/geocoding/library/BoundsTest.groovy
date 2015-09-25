package com.agilitysolutions.mapping.geocoding.library

class BoundsTest extends GroovyTestCase {
    private Bounds _bounds;

    void setUp() {
        super.setUp()

        _bounds = new Bounds();
    }

    void testSetGetSouthwest() {
        Location southwest = new Location();
        southwest.setLatitude(BigDecimal.valueOf(34.172684));
        southwest.setLongitude(BigDecimal.valueOf(-118.604794));

        _bounds.setSouthwest(southwest);

        assertEquals(BigDecimal.valueOf(34.172684), _bounds.getSouthwest().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.604794), _bounds.getSouthwest().getLongitude());
    }

    void testSetGetNortheast() {
        Location northeast = new Location();
        northeast.setLatitude(BigDecimal.valueOf(34.236144));
        northeast.setLongitude(BigDecimal.valueOf(-118.500938));

        _bounds.setNortheast(northeast);

        assertEquals(BigDecimal.valueOf(34.236144), _bounds.getNortheast().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.500938), _bounds.getNortheast().getLongitude());
    }
}
