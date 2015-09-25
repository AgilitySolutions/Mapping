package com.agilitysolutions.mapping.geocoding.library

class ViewportTest extends GroovyTestCase {
    private Viewport _viewport;

    void setUp() {
        super.setUp()

        _viewport = new Viewport();
    }

    void testSetGetSouthwest() {
        Location southwest = new Location();
        southwest.setLatitude(BigDecimal.valueOf(34.172684));
        southwest.setLongitude(BigDecimal.valueOf(-118.604794));

        _viewport.setSouthwest(southwest);

        assertEquals(BigDecimal.valueOf(34.172684), _viewport.getSouthwest().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.604794), _viewport.getSouthwest().getLongitude());
    }

    void testSetGetNortheast() {
        Location northeast = new Location();
        northeast.setLatitude(BigDecimal.valueOf(34.236144));
        northeast.setLongitude(BigDecimal.valueOf(-118.500938));

        _viewport.setNortheast(northeast);

        assertEquals(BigDecimal.valueOf(34.236144), _viewport.getNortheast().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.500938), _viewport.getNortheast().getLongitude());
    }
}
