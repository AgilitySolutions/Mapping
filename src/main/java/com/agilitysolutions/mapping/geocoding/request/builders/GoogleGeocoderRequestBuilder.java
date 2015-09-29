package com.agilitysolutions.mapping.geocoding.request.builders;

import com.agilitysolutions.mapping.geocoding.library.Bounds;
import com.agilitysolutions.mapping.geocoding.library.Location;
import com.agilitysolutions.mapping.geocoding.library.Request;
import com.agilitysolutions.mapping.interfaces.geocoding.request.builders.IRequestBuilder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.LatLng;
import com.google.code.geocoder.model.LatLngBounds;

public class GoogleGeocoderRequestBuilder implements IRequestBuilder {
    private GeocoderRequestBuilder _geocoderRequestBuilder;

    public GoogleGeocoderRequestBuilder(GeocoderRequestBuilder geocoderRequestBuilder) {
        if (geocoderRequestBuilder == null) throw new IllegalArgumentException();

        _geocoderRequestBuilder = geocoderRequestBuilder;
    }

    public GeocoderRequest build(Request request) {
        _geocoderRequestBuilder.setLanguage(request.getLanguage());
        _geocoderRequestBuilder.setRegion(request.getRegion());
        _geocoderRequestBuilder.setAddress(request.getAddress());
        _geocoderRequestBuilder.setBounds(convertBoundsToLatLngBounds(request.getBounds()));
        _geocoderRequestBuilder.setLocation(convertLocationToLatLng(request.getLocation()));

        return _geocoderRequestBuilder.getGeocoderRequest();
    }

    private LatLngBounds convertBoundsToLatLngBounds(Bounds bounds) {
        if (bounds == null) {
            return null;
        }

        LatLngBounds latLngBounds = new LatLngBounds();
        latLngBounds.setNortheast(new LatLng(bounds.getNortheast().getLatitude(), bounds.getNortheast().getLongitude()));
        latLngBounds.setSouthwest(new LatLng(bounds.getSouthwest().getLatitude(), bounds.getSouthwest().getLongitude()));

        return latLngBounds;
    }

    private LatLng convertLocationToLatLng(Location location) {
        if (location == null) {
            return null;
        }

        return new LatLng(location.getLatitude(), location.getLongitude());
    }
}
