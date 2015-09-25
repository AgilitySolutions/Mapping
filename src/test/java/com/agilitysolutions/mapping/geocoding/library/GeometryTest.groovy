package com.agilitysolutions.mapping.geocoding.library

import com.agilitysolutions.mapping.geocoding.library.enums.LocationType

class GeometryTest extends GroovyTestCase {
    private Geometry _geometry;

    void setUp() {
        super.setUp()

        _geometry = new Geometry();
    }

    void testSetGetLocation() {
        Location location = new Location();
        location.setLatitude(BigDecimal.valueOf(34.172684));
        location.setLongitude(BigDecimal.valueOf(-118.604794));

        _geometry.setLocation(location);

        assertEquals(BigDecimal.valueOf(34.172684), _geometry.getLocation().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.604794), _geometry.getLocation().getLongitude());
    }

    void testSetGetLocationType() {
        _geometry.setLocationType(LocationType.Approximate);

        assertEquals(LocationType.Approximate, _geometry.getLocationType());
    }

    void testSetGetViewport() {
        Viewport viewport = new Viewport();

        Location northeast = new Location();
        northeast.setLatitude(BigDecimal.valueOf(34.236144));
        northeast.setLongitude(BigDecimal.valueOf(-118.500938));

        viewport.setNortheast(northeast);

        Location southwest = new Location();
        southwest.setLatitude(BigDecimal.valueOf(34.172684));
        southwest.setLongitude(BigDecimal.valueOf(-118.604794));

        viewport.setSouthwest(southwest);

        _geometry.setViewport(viewport);

        assertEquals(BigDecimal.valueOf(34.236144), _geometry.getViewport().getNortheast().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.500938), _geometry.getViewport().getNortheast().getLongitude());
        assertEquals(BigDecimal.valueOf(34.172684), _geometry.getViewport().getSouthwest().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.604794), _geometry.getViewport().getSouthwest().getLongitude());
    }
}
