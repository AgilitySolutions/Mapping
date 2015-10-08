package com.agilitysolutions.mapping.interfaces.geocoding.response.handlers;

import com.agilitysolutions.mapping.geocoding.library.Response;

public interface ResponseHandler {
    Response build(Object responseObject);
}
