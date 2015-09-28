package com.agilitysolutions.mapping.interfaces.geocoding.request.handlers;

import com.agilitysolutions.mapping.geocoding.library.Request;
import com.agilitysolutions.mapping.geocoding.library.Response;

public interface IRequestHandler {
    //TODO - figure out a better way to handle this one
    void initialize(String clientId, String clientKey);

    Response handle(Request request);
}
