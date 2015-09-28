package com.agilitysolutions.mapping.geocoding.response.handlers

import com.agilitysolutions.mapping.geocoding.library.AddressComponent
import com.agilitysolutions.mapping.geocoding.library.Geometry
import com.agilitysolutions.mapping.geocoding.library.Location
import com.agilitysolutions.mapping.geocoding.library.Response
import com.agilitysolutions.mapping.geocoding.library.Result
import com.agilitysolutions.mapping.geocoding.library.Viewport
import com.agilitysolutions.mapping.geocoding.library.enums.AddressComponentType
import com.agilitysolutions.mapping.geocoding.library.enums.LocationType
import com.agilitysolutions.mapping.geocoding.library.enums.StatusCode
import com.google.code.geocoder.model.GeocodeResponse
import com.google.code.geocoder.model.GeocoderAddressComponent
import com.google.code.geocoder.model.GeocoderGeometry
import com.google.code.geocoder.model.GeocoderLocationType
import com.google.code.geocoder.model.GeocoderResult
import com.google.code.geocoder.model.GeocoderStatus
import com.google.code.geocoder.model.LatLng
import com.google.code.geocoder.model.LatLngBounds

class GoogleGeocodeResponseHandlerTest extends GroovyTestCase {
    private GoogleGeocodeResponseHandler _responseHandler;

    void setUp() {
        super.setUp()

        _responseHandler = new GoogleGeocodeResponseHandler();
    }

    void testBuildNull() {
        assertNull(_responseHandler.build(""));
    }

    void testGoodResponse() {
        GeocodeResponse geocodeResponse = new GeocodeResponse();
        geocodeResponse.setStatus(GeocoderStatus.OK);

        List<GeocoderResult> geocoderResultList = new ArrayList<GeocoderResult>();

        GeocoderResult geocoderResult = new GeocoderResult();
        geocoderResult.setFormattedAddress("123 Main St, Circleville, OH");
        geocoderResult.setPartialMatch(true);
        geocoderResult.setTypes(Arrays.asList("political", "administrative_area_level_2"));

        List<GeocoderAddressComponent> geocoderAddressComponentList = new ArrayList<GeocoderAddressComponent>();

        GeocoderAddressComponent geocoderAddressComponent = new GeocoderAddressComponent();
        geocoderAddressComponent.setLongName("Test Long Name");
        geocoderAddressComponent.setShortName("Test Short Name");
        geocoderAddressComponent.setTypes(Arrays.asList("country", "airport"));

        geocoderAddressComponentList.add(geocoderAddressComponent);

        geocoderResult.setAddressComponents(geocoderAddressComponentList);

        GeocoderGeometry geocoderGeometry = new GeocoderGeometry();
        geocoderGeometry.setLocation(new LatLng(BigDecimal.valueOf(40.714224), BigDecimal.valueOf(-73.961452)));
        geocoderGeometry.setLocationType(GeocoderLocationType.ROOFTOP);

        LatLngBounds latLngBounds = new LatLngBounds();
        latLngBounds.setNortheast(new LatLng(BigDecimal.valueOf(34.236144), BigDecimal.valueOf(-118.500938)));
        latLngBounds.setSouthwest(new LatLng(BigDecimal.valueOf(34.172684), BigDecimal.valueOf(-118.604794)));

        geocoderGeometry.setViewport(latLngBounds);

        geocoderResult.setGeometry(geocoderGeometry);

        geocoderResultList.add(geocoderResult);

        geocodeResponse.setResults(geocoderResultList);

        Response response = _responseHandler.build(geocodeResponse);

        assertTrue(areEqual(response, geocodeResponse));
    }

    private static boolean areEqual(Response response, GeocodeResponse geocodeResponse) {
        return response.getStatusCode() == StatusCode.Ok &&
                areEqualResultList(response.getResults(), geocodeResponse.getResults());
    }

    private static boolean areEqualResultList(List<Result> resultList, List<GeocoderResult> geocoderResultList) {
        if (resultList.size() != geocoderResultList.size()) {
            return false;
        }

        for (int i = 0; i < resultList.size(); i++) {
            Result result = resultList.get(i);
            GeocoderResult geocoderResult = geocoderResultList.get(i);

            if (result.getPartialMatch() != geocoderResult.isPartialMatch() ||
                    !result.getFormattedAddress().equals(geocoderResult.getFormattedAddress()) ||
                    !areEqualGeometry(result.getGeometry(), geocoderResult.getGeometry()) ||
                    !areEqualAddressComponentTypeList(result.getAddressComponentTypes(), geocoderResult.getTypes()) ||
                    !areEqualAddressComponentList(result.getAddressComponents(), geocoderResult.getAddressComponents())) {
                return false;
            }
        }

        return true;
    }

    private static boolean areEqualGeometry(Geometry geometry, GeocoderGeometry geocoderGeometry) {
        return areEqualLocation(geometry.getLocation(), geocoderGeometry.getLocation()) &&
                areEqualLocationType(geometry.getLocationType(), geocoderGeometry.getLocationType()) &&
                areEqualViewport(geometry.getViewport(), geocoderGeometry.getViewport());
    }

    private static boolean areEqualAddressComponentTypeList(List<AddressComponentType> addressComponentTypeList, List<String> geocoderTypeList) {
        if (addressComponentTypeList.size() != geocoderTypeList.size()) {
            return false;
        }

        for (int i = 0; i < addressComponentTypeList.size(); i++) {
            AddressComponentType addressComponentType = addressComponentTypeList.get(i);
            String geocoderType = geocoderTypeList.get(i);

            if (addressComponentType != AddressComponentType.getValue(geocoderType)) {
                return false;
            }
        }

        return true;
    }

    private static boolean areEqualAddressComponentList(List<AddressComponent> addressComponentList, List<GeocoderAddressComponent> geocoderAddressComponentList) {
        if (addressComponentList.size() != geocoderAddressComponentList.size()) {
            return false;
        }

        for (int i = 0; i < addressComponentList.size(); i++) {
            AddressComponent addressComponent = addressComponentList.get(i);
            GeocoderAddressComponent geocoderAddressComponent = geocoderAddressComponentList.get(i);

            addressComponent.getAddressComponentTypes();

            if (!addressComponent.getLongName().equals(geocoderAddressComponent.getLongName()) ||
                    !addressComponent.getShortName().equals(geocoderAddressComponent.getShortName()) ||
                    !areEqualAddressComponentTypeList(addressComponent.getAddressComponentTypes(), geocoderAddressComponent.getTypes())) {
                return false;
            }
        }

        return true;
    }

    private static boolean areEqualLocation(Location location, LatLng latLng) {
        return location.getLatitude().equals(latLng.getLat()) &&
                location.getLongitude().equals(latLng.getLng());
    }

    private static boolean areEqualLocationType(LocationType locationType, GeocoderLocationType geocoderLocationType) {
        return locationType == LocationType.getValue(geocoderLocationType.name());
    }

    private static boolean areEqualViewport(Viewport viewport, LatLngBounds latLngBounds) {
        return areEqualLocation(viewport.getNortheast(), latLngBounds.getNortheast()) &&
                areEqualLocation(viewport.getSouthwest(), latLngBounds.getSouthwest());
    }
}
