package com.agilitysolutions.mapping.geocoding.library

class RequestTest extends GroovyTestCase {
    private Request _request;

    void setUp() {
        super.setUp()

        _request = new Request();
    }

    void testSetGetAddress() {
        _request.setAddress("Test Address");

        assertEquals("Test Address", _request.getAddress());
    }

    void testSetGetLanguage() {
        _request.setLanguage("en");

        assertEquals("en", _request.getLanguage());
    }

    void testSetGetRegion() {
        _request.setRegion("Test Region");

        assertEquals("Test Region", _request.getRegion());
    }

    void testSetGetBounds() {
        Bounds bounds = new Bounds();

        Location northeast = new Location();
        northeast.setLatitude(BigDecimal.valueOf(34.236144));
        northeast.setLongitude(BigDecimal.valueOf(-118.500938));

        bounds.setNortheast(northeast);

        Location southwest = new Location();
        southwest.setLatitude(BigDecimal.valueOf(34.172684));
        southwest.setLongitude(BigDecimal.valueOf(-118.604794));

        bounds.setSouthwest(southwest);

        _request.setBounds(bounds);

        assertEquals(BigDecimal.valueOf(34.236144), _request.getBounds().getNortheast().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.500938), _request.getBounds().getNortheast().getLongitude());
        assertEquals(BigDecimal.valueOf(34.172684), _request.getBounds().getSouthwest().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.604794), _request.getBounds().getSouthwest().getLongitude());
    }

    void testSetGetLocation() {
        Location location = new Location();
        location.setLatitude(BigDecimal.valueOf(34.236144));
        location.setLongitude(BigDecimal.valueOf(-118.500938));

        _request.setLocation(location);

        assertEquals(BigDecimal.valueOf(34.236144), _request.getLocation().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.500938), _request.getLocation().getLongitude());
    }
}
