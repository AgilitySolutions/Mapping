package com.agilitysolutions.mapping.geocoding.library.enums;

public enum LocationType {
    Rooftop("ROOFTOP"),                         // indicates that the returned result is a precise geocode for which we have location information accurate down to street address precision
    RangeInterpolated("RANGE_INTERPOLATED"),    // indicates that the returned result reflects an approximation (usually on a road) interpolated between two precise points (such as intersections). Interpolated results are generally returned when rooftop geocodes are unavailable for a street address
    GeometricCenter("GEOMETRIC_CENTER"),        // indicates that the returned result is the geometric center of a result such as a polyline (for example, a street) or polygon (region)
    Approximate("APPROXIMATE");                 // indicates that the returned result is approximate

    private final String code;

    LocationType(String code) {
        this.code = code;
    }

    public static LocationType getValue(String code) {
        for (LocationType locationType : LocationType.values()) {
            if (locationType.code.equals(code)) {
                return locationType;
            }
        }

        return null;
    }
}
