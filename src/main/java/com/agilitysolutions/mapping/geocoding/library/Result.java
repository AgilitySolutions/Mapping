package com.agilitysolutions.mapping.geocoding.library;

import com.agilitysolutions.mapping.geocoding.library.enums.AddressComponentType;

import java.util.List;

public class Result {
    private List<AddressComponentType> addressComponentTypes;
    private String formattedAddress;
    private List<AddressComponent> addressComponents;
    private Geometry geometry;
    private boolean partialMatch;

    public List<AddressComponentType> getAddressComponentTypes() {
        return addressComponentTypes;
    }

    public void setAddressComponentTypes(List<AddressComponentType> addressComponentTypes) {
        this.addressComponentTypes = addressComponentTypes;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public List<AddressComponent> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public boolean isPartialMatch() {
        return partialMatch;
    }

    public void setPartialMatch(boolean partialMatch) {
        this.partialMatch = partialMatch;
    }
}
