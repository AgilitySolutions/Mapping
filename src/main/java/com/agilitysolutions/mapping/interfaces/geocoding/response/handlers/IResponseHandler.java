package com.agilitysolutions.mapping.interfaces.geocoding.response.handlers;

import com.agilitysolutions.mapping.geocoding.library.Response;

public interface IResponseHandler {
    Response build(Object responseObject);
}
