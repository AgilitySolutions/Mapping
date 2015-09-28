package com.agilitysolutions.mapping.geocoding.response.handlers;

import com.agilitysolutions.mapping.geocoding.library.*;
import com.agilitysolutions.mapping.geocoding.library.enums.AddressComponentType;
import com.agilitysolutions.mapping.geocoding.library.enums.LocationType;
import com.agilitysolutions.mapping.geocoding.library.enums.StatusCode;
import com.agilitysolutions.mapping.interfaces.geocoding.response.handlers.IResponseHandler;
import com.google.code.geocoder.model.*;

import java.util.ArrayList;
import java.util.List;

public class GoogleGeocodeResponseHandler implements IResponseHandler {
    public Response build(Object responseObject) {
        if (!(responseObject instanceof GeocodeResponse)) {
            return null;
        }

        GeocodeResponse geocodeResponse = (GeocodeResponse) responseObject;

        Response response = new Response();

        response.setStatusCode(StatusCode.getValue(geocodeResponse.getStatus().name()));
        response.setResults(buildResults(geocodeResponse.getResults()));

        return response;
    }

    private List<Result> buildResults(List<GeocoderResult> geocodeResults) {
        List<Result> results = new ArrayList<Result>();

        for (GeocoderResult geocoderResult : geocodeResults) {
            Result result = new Result();

            result.setAddressComponents(buildAddressComponents(geocoderResult.getAddressComponents()));
            result.setAddressComponentTypes(buildAddressComponentTypes(geocoderResult.getTypes()));
            result.setFormattedAddress(geocoderResult.getFormattedAddress());
            result.setGeometry(buildGeometry(geocoderResult.getGeometry()));
            result.setPartialMatch(geocoderResult.isPartialMatch());

            results.add(result);
        }

        return results;
    }

    private Geometry buildGeometry(GeocoderGeometry geocoderGeometry) {
        Geometry geometry = new Geometry();

        geometry.setLocation(buildLocation(geocoderGeometry.getLocation()));
        geometry.setLocationType(LocationType.getValue(geocoderGeometry.getLocationType().name()));
        geometry.setViewport(buildViewport(geocoderGeometry.getViewport()));

        return geometry;
    }

    private Location buildLocation(LatLng latLng) {
        Location location = new Location();
        location.setLatitude(latLng.getLat());
        location.setLongitude(latLng.getLng());

        return location;
    }

    private Viewport buildViewport(LatLngBounds latLngBounds) {
        Viewport viewport = new Viewport();
        viewport.setNortheast(buildLocation(latLngBounds.getNortheast()));
        viewport.setSouthwest(buildLocation(latLngBounds.getSouthwest()));

        return viewport;
    }

    private List<AddressComponent> buildAddressComponents(List<GeocoderAddressComponent> geocoderAddressComponents) {
        List<AddressComponent> addressComponents = new ArrayList<AddressComponent>();

        for (GeocoderAddressComponent geocoderAddressComponent : geocoderAddressComponents) {
            AddressComponent addressComponent = new AddressComponent();

            addressComponent.setAddressComponentTypes(buildAddressComponentTypes(geocoderAddressComponent.getTypes()));
            addressComponent.setLongName(geocoderAddressComponent.getLongName());
            addressComponent.setShortName(geocoderAddressComponent.getShortName());

            addressComponents.add(addressComponent);
        }

        return addressComponents;
    }

    private List<AddressComponentType> buildAddressComponentTypes(List<String> geocoderAddressComponentTypes) {
        List<AddressComponentType> addressComponentTypes = new ArrayList<AddressComponentType>();

        for (String geocoderAddressComponentType : geocoderAddressComponentTypes) {
            addressComponentTypes.add(AddressComponentType.getValue(geocoderAddressComponentType));
        }

        return addressComponentTypes;
    }
}
