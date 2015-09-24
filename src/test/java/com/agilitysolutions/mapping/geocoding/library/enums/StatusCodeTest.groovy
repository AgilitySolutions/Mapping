package com.agilitysolutions.mapping.geocoding.library.enums

class StatusCodeTest extends GroovyTestCase {
    void testGetValue() {
        assertEquals(StatusCode.Ok, StatusCode.getValue("OK"));
        assertEquals(StatusCode.ZeroResults, StatusCode.getValue("ZERO_RESULTS"));
        assertEquals(StatusCode.OverQueryLimit, StatusCode.getValue("OVER_QUERY_LIMIT"));
        assertEquals(StatusCode.RequestDenied, StatusCode.getValue("REQUEST_DENIED"));
        assertEquals(StatusCode.InvalidRequest, StatusCode.getValue("INVALID_REQUEST"));

        assertNull(StatusCode.getValue("something"));
    }
}
