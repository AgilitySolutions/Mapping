package com.agilitysolutions.mapping.interfaces.geocoding.request.handlers;

import com.agilitysolutions.mapping.geocoding.library.Request;
import com.agilitysolutions.mapping.geocoding.library.Response;

import java.security.InvalidKeyException;

public interface RequestHandler {
    Response handle(Request request);
    Response handle(Request request, String clientId, String clientKey) throws InvalidKeyException;
}
