package com.agilitysolutions.mapping.geocoding.library;

import com.agilitysolutions.mapping.geocoding.library.enums.AddressComponentType;

import java.util.List;

public class Result {
    private List<AddressComponentType> _addressComponentTypes;
    private String _formattedAddress;
    private List<AddressComponent> _addressComponents;
    private Geometry _geometry;
    private boolean _partialMatch;

    public List<AddressComponentType> getAddressComponentTypes() {
        return _addressComponentTypes;
    }

    public void setAddressComponentTypes(List<AddressComponentType> addressComponentTypes) {
        _addressComponentTypes = addressComponentTypes;
    }

    public String getFormattedAddress() {
        return _formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        _formattedAddress = formattedAddress;
    }

    public List<AddressComponent> getAddressComponents() {
        return _addressComponents;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        _addressComponents = addressComponents;
    }

    public Geometry getGeometry() {
        return _geometry;
    }

    public void setGeometry(Geometry geometry) {
        _geometry = geometry;
    }

    public boolean getPartialMatch() {
        return _partialMatch;
    }

    public void setPartialMatch(boolean partialMatch) {
        _partialMatch = partialMatch;
    }
}
