package com.agilitysolutions.mapping.interfaces.geocoding.request.builders;

import com.agilitysolutions.mapping.geocoding.library.Request;

public interface IRequestBuilder {
    Object build(Request request);
}
