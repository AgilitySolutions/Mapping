package com.agilitysolutions.mapping.geocoding.library

import com.agilitysolutions.mapping.geocoding.library.enums.StatusCode

class ResponseTest extends GroovyTestCase {
    private Response _response;

    void setUp() {
        super.setUp()

        _response = new Response();
    }

    void testGetStatusCode() {
        _response.setStatusCode(StatusCode.OverQueryLimit);

        assertEquals(StatusCode.OverQueryLimit, _response.getStatusCode());
    }

    void testGetResults() {
        ArrayList<Result> resultList = new ArrayList<Result>();

        Result result = new Result();

        result.setFormattedAddress("Test Address");
        result.setPartialMatch(true);

        resultList.add(result);

        _response.setResults(resultList);

        assertEquals(resultList, _response.getResults());
    }
}
