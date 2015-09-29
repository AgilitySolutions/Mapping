package com.agilitysolutions.mapping.interfaces.geocoding.request.builders;

import com.agilitysolutions.mapping.geocoding.library.Request;
import com.google.code.geocoder.model.GeocoderRequest;

public interface IRequestBuilder {
    GeocoderRequest build(Request request);
}
