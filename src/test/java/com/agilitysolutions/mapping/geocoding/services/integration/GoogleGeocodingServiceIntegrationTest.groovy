package com.agilitysolutions.mapping.geocoding.services.integration

import com.agilitysolutions.mapping.geocoding.library.Bounds
import com.agilitysolutions.mapping.geocoding.library.Location
import com.agilitysolutions.mapping.geocoding.library.Request
import com.agilitysolutions.mapping.geocoding.library.Response
import com.agilitysolutions.mapping.geocoding.library.enums.AddressComponentType
import com.agilitysolutions.mapping.geocoding.library.enums.LocationType
import com.agilitysolutions.mapping.geocoding.library.enums.StatusCode
import com.agilitysolutions.mapping.geocoding.request.builders.GoogleGeocoderRequestBuilder
import com.agilitysolutions.mapping.geocoding.request.handlers.GoogleGeocoderRequestHandler
import com.agilitysolutions.mapping.geocoding.response.handlers.GoogleGeocodeResponseHandler
import com.agilitysolutions.mapping.geocoding.services.GeocoderProviderService
import com.agilitysolutions.mapping.geocoding.services.GoogleGeocodingService
import com.agilitysolutions.mapping.interfaces.geocoding.request.builders.IRequestBuilder
import com.agilitysolutions.mapping.interfaces.geocoding.response.handlers.IResponseHandler
import com.agilitysolutions.mapping.interfaces.geocoding.services.IGeocoderProviderService
import com.google.code.geocoder.GeocoderRequestBuilder

class GoogleGeocodingServiceIntegrationTest extends GroovyTestCase {
    private IGeocoderProviderService _geocoderProviderService;
    private IRequestBuilder _requestBuilder;
    private IResponseHandler _responseHandler;
    private GeocoderRequestBuilder _geocoderRequestBuilder;
    private GoogleGeocoderRequestHandler _googleGeocoderRequestHandler;
    private GoogleGeocodingService _googleGeocodingService;

    void setUp() {
        super.setUp()

        _geocoderProviderService = new GeocoderProviderService();
        _geocoderRequestBuilder = new GeocoderRequestBuilder();
        _requestBuilder = new GoogleGeocoderRequestBuilder(_geocoderRequestBuilder);
        _responseHandler = new GoogleGeocodeResponseHandler();

        _googleGeocoderRequestHandler = new GoogleGeocoderRequestHandler(_geocoderProviderService,
                _requestBuilder,
                _responseHandler);

        _googleGeocodingService = new GoogleGeocodingService(_googleGeocoderRequestHandler);
    }

    void testAddress() {
        Request request = new Request();
        request.setAddress("320 Victor Dr, Circleville, OH");

        Response response = _googleGeocodingService.getGeocode(request);

        assertEquals(StatusCode.Ok, response.getStatusCode());
        assertEquals(1, response.getResults().size());

        def result = response.getResults()[0];

        assertEquals("320 Victor Dr, Circleville, OH 43113, USA", result.getFormattedAddress());
        assertTrue(result.getPartialMatch());
        assertEquals(1, result.getAddressComponentTypes().size());
        assertEquals(8, result.getAddressComponents().size());

        assertEquals(AddressComponentType.StreetAddress, result.getAddressComponentTypes()[0]);

        def addressComponent = result.getAddressComponents()[0];

        assertEquals("320", addressComponent.getLongName());
        assertEquals("320", addressComponent.getShortName());
        assertEquals(1, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.StreetNumber, addressComponent.getAddressComponentTypes()[0])

        addressComponent = result.getAddressComponents()[1];

        assertEquals("Victor Drive", addressComponent.getLongName());
        assertEquals("Victor Dr", addressComponent.getShortName());
        assertEquals(1, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.Route, addressComponent.getAddressComponentTypes()[0])

        addressComponent = result.getAddressComponents()[2];

        assertEquals("Circleville", addressComponent.getLongName());
        assertEquals("Circleville", addressComponent.getShortName());
        assertEquals(2, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.Locatity, addressComponent.getAddressComponentTypes()[0])
        assertEquals(AddressComponentType.Political, addressComponent.getAddressComponentTypes()[1])

        addressComponent = result.getAddressComponents()[3];

        assertEquals("Pickaway County", addressComponent.getLongName());
        assertEquals("Pickaway County", addressComponent.getShortName());
        assertEquals(2, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.AdministrativeAreaLevel2, addressComponent.getAddressComponentTypes()[0])
        assertEquals(AddressComponentType.Political, addressComponent.getAddressComponentTypes()[1])

        addressComponent = result.getAddressComponents()[4];

        assertEquals("Ohio", addressComponent.getLongName());
        assertEquals("OH", addressComponent.getShortName());
        assertEquals(2, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.AdministrativeAreaLevel1, addressComponent.getAddressComponentTypes()[0])
        assertEquals(AddressComponentType.Political, addressComponent.getAddressComponentTypes()[1])

        addressComponent = result.getAddressComponents()[5];

        assertEquals("United States", addressComponent.getLongName());
        assertEquals("US", addressComponent.getShortName());
        assertEquals(2, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.Country, addressComponent.getAddressComponentTypes()[0])
        assertEquals(AddressComponentType.Political, addressComponent.getAddressComponentTypes()[1])

        addressComponent = result.getAddressComponents()[6];

        assertEquals("43113", addressComponent.getLongName());
        assertEquals("43113", addressComponent.getShortName());
        assertEquals(1, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.PostalCode, addressComponent.getAddressComponentTypes()[0])

        addressComponent = result.getAddressComponents()[7];

        assertEquals("1295", addressComponent.getLongName());
        assertEquals("1295", addressComponent.getShortName());
        assertEquals(1, addressComponent.getAddressComponentTypes().size());
        assertEquals(null, addressComponent.getAddressComponentTypes()[0])

        def geometry = result.getGeometry();

        assertEquals(LocationType.RangeInterpolated, geometry.getLocationType());
        assertEquals(39.6276977, geometry.getLocation().getLatitude());
        assertEquals(-82.93448939999999, geometry.getLocation().getLongitude());

        assertEquals(39.62635581970851, geometry.getViewport().getSouthwest().getLatitude());
        assertEquals(-82.93583823029149, geometry.getViewport().getSouthwest().getLongitude());
        assertEquals(39.6290537802915, geometry.getViewport().getNortheast().getLatitude());
        assertEquals(-82.93314026970849, geometry.getViewport().getNortheast().getLongitude());
    }

    void testLocation() {
        Request request = new Request();

        Location location = new Location();
        location.setLongitude(40.714224);
        location.setLatitude(-73.961452);

        request.setLocation(location);

        Response response = _googleGeocodingService.getGeocode(request);

        assertEquals(StatusCode.Ok, response.getStatusCode());
        assertEquals(1, response.getResults().size());

        def result = response.getResults()[0];

        assertEquals("Antarctica", result.getFormattedAddress());
        assertFalse(result.getPartialMatch())
        assertEquals(2, result.getAddressComponentTypes().size());
        assertEquals(1, result.getAddressComponents().size());

        assertEquals(AddressComponentType.Country, result.getAddressComponentTypes()[0])
        assertEquals(AddressComponentType.Political, result.getAddressComponentTypes()[1])

        def addressComponent = result.getAddressComponents()[0];

        assertEquals("Antarctica", addressComponent.getLongName());
        assertEquals("AQ", addressComponent.getShortName());
        assertEquals(2, addressComponent.getAddressComponentTypes().size());

        assertEquals(AddressComponentType.Country, addressComponent.getAddressComponentTypes()[0])
        assertEquals(AddressComponentType.Political, addressComponent.getAddressComponentTypes()[1])

        def geometry = result.getGeometry();

        assertEquals(LocationType.Approximate, geometry.getLocationType());
        assertEquals(-75.250973, geometry.getLocation().getLatitude());
        assertEquals(-0.07138899999999999, geometry.getLocation().getLongitude());

        assertEquals(-90, geometry.getViewport().getSouthwest().getLatitude());
        assertEquals(-180, geometry.getViewport().getSouthwest().getLongitude());
        assertEquals(-61.0490419, geometry.getViewport().getNortheast().getLatitude());
        assertEquals(180, geometry.getViewport().getNortheast().getLongitude());
    }

    void testPartialAddress() {
        Request request = new Request();
        request.setAddress("Winnetka");

        Response response = _googleGeocodingService.getGeocode(request);

        assertEquals(StatusCode.Ok, response.getStatusCode());
        assertEquals(1, response.getResults().size());

        def result = response.getResults()[0];

        assertEquals("Winnetka, IL, USA", result.getFormattedAddress());
        assertFalse(result.getPartialMatch());
        assertEquals(2, result.getAddressComponentTypes().size());
        assertEquals(5, result.getAddressComponents().size());

        assertEquals(AddressComponentType.Locatity, result.getAddressComponentTypes()[0]);
        assertEquals(AddressComponentType.Political, result.getAddressComponentTypes()[1]);

        def addressComponent = result.getAddressComponents()[0];

        assertEquals("Winnetka", addressComponent.getLongName());
        assertEquals("Winnetka", addressComponent.getShortName());
        assertEquals(2, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.Locatity, addressComponent.getAddressComponentTypes()[0])
        assertEquals(AddressComponentType.Political, addressComponent.getAddressComponentTypes()[1])

        addressComponent = result.getAddressComponents()[1];

        assertEquals("New Trier", addressComponent.getLongName());
        assertEquals("New Trier", addressComponent.getShortName());
        assertEquals(2, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.AdministrativeAreaLevel3, addressComponent.getAddressComponentTypes()[0])
        assertEquals(AddressComponentType.Political, addressComponent.getAddressComponentTypes()[1])

        addressComponent = result.getAddressComponents()[2];

        assertEquals("Cook County", addressComponent.getLongName());
        assertEquals("Cook County", addressComponent.getShortName());
        assertEquals(2, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.AdministrativeAreaLevel2, addressComponent.getAddressComponentTypes()[0])
        assertEquals(AddressComponentType.Political, addressComponent.getAddressComponentTypes()[1])

        addressComponent = result.getAddressComponents()[3];

        assertEquals("Illinois", addressComponent.getLongName());
        assertEquals("IL", addressComponent.getShortName());
        assertEquals(2, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.AdministrativeAreaLevel1, addressComponent.getAddressComponentTypes()[0])
        assertEquals(AddressComponentType.Political, addressComponent.getAddressComponentTypes()[1])

        addressComponent = result.getAddressComponents()[4];

        assertEquals("United States", addressComponent.getLongName());
        assertEquals("US", addressComponent.getShortName());
        assertEquals(2, addressComponent.getAddressComponentTypes().size());
        assertEquals(AddressComponentType.Country, addressComponent.getAddressComponentTypes()[0])
        assertEquals(AddressComponentType.Political, addressComponent.getAddressComponentTypes()[1])

        def geometry = result.getGeometry();

        assertEquals(LocationType.Approximate, geometry.getLocationType());
        assertEquals(42.10808340000001, geometry.getLocation().getLatitude());
        assertEquals(-87.735895, geometry.getLocation().getLongitude());

        assertEquals(42.0886089, geometry.getViewport().getSouthwest().getLatitude());
        assertEquals(-87.7708629, geometry.getViewport().getSouthwest().getLongitude());
        assertEquals(42.1282269, geometry.getViewport().getNortheast().getLatitude());
        assertEquals(-87.71081629999999, geometry.getViewport().getNortheast().getLongitude());
    }

    void testBounds() {
        Request request = new Request();

        Bounds bounds = new Bounds();

        Location northeast = new Location();
        northeast.setLongitude(34.236144);
        northeast.setLatitude(-118.500938);

        bounds.setNortheast(northeast);

        Location southwest = new Location();
        southwest.setLongitude(34.172684);
        southwest.setLatitude(-118.604794);

        bounds.setSouthwest(southwest);

        request.setBounds(bounds);

        Response response = _googleGeocodingService.getGeocode(request);
    }

    void testCityOnly() {
        Request request = new Request();
        request.setAddress("Toledo");

        Response response = _googleGeocodingService.getGeocode(request);
    }

    void testCityWithLanguage() {
        Request request = new Request();
        request.setAddress("Toledo");
        request.setLanguage("es");

        Response response = _googleGeocodingService.getGeocode(request);
    }
}
