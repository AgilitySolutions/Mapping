package com.agilitysolutions.mapping.geocoding.library.enums

class LocationTypeTest extends GroovyTestCase {
    void testGetValue() {
        assertEquals(LocationType.Rooftop, LocationType.getValue("ROOFTOP"));
        assertEquals(LocationType.RangeInterpolated, LocationType.getValue("RANGE_INTERPOLATED"));
        assertEquals(LocationType.GeometricCenter, LocationType.getValue("GEOMETRIC_CENTER"));
        assertEquals(LocationType.Approximate, LocationType.getValue("APPROXIMATE"));

        assertNull(LocationType.getValue("something"));
    }
}
