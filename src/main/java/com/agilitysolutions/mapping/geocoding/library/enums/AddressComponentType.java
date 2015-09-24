package com.agilitysolutions.mapping.geocoding.library.enums;

public enum AddressComponentType {
    StreetAddress("street_address"),                            // indicates a precise street address
    Route("route"),                                             // indicates a named route (such as "US 101")
    Intersection("intersection"),                               // indicates a major intersection, usually of two major roads
    Political("political"),                                     // indicates a political entity. Usually, this type indicates a polygon of some civil administration
    Country("country"),                                         // indicates the national political entity, and is typically the highest order type returned by the Geocoder
    AdministrativeAreaLevel1("administrative_area_level_1"),    // indicates a first-order civil entity below the country level. Within the United States, these administrative levels are states. Not all nations exhibit these administrative levels
    AdministrativeAreaLevel2("administrative_area_level_2"),    // indicates a second-order civil entity below the country level. Within the United States, these administrative levels are counties. Not all nations exhibit these administrative levels
    AdministrativeAreaLevel3("administrative_area_level_3"),    // indicates a third-order civil entity below the country level. This type indicates a minor civil division. Not all nations exhibit these administrative levels
    ColloquialArea("colloguial_area"),                          // indicates a commonly-used alternative name for the entity
    Locatity("locality"),                                       // indicates an incorporated city or town political entity
    Sublocality("sublocality"),                                 // indicates an first-order civil entity below a locality
    Neighborhood("neighborhood"),                               // indicates a named neighborhood
    Premise("premise"),                                         // indicates a named location, usually a building or collection of buildings with a common name
    Subpremise("subpremise"),                                   // indicates a first-order entity below a named location, usually a singular building within a collection of buildings with a common name
    PostalCode("postal_code"),                                  // indicates a postal code as used to address postal mail within the country
    NaturalFeature("natural_feature"),                          // indicates a prominent natural feature
    Airport("airport"),                                         // indicates an airport
    Park("park"),                                               // indicates a named park
    PointOfInterest("point_of_interest"),                       // indicates a named point of interest. Typically, these "POI"s are prominent local entities that don't easily fit in another category such as "Empire State Building" or "Statue of Liberty"
    PostBox("post_box"),                                        // indicates a specific postal box
    StreetNumber("street_number"),                              // indicates the precise street number
    Floor("floor"),                                             // indicates the floor of a building address
    Room("room");                                               // indicates the room of a building address

    private final String code;

    AddressComponentType(String code) {
        this.code = code;
    }

    public static AddressComponentType getValue(String code) {
        for (AddressComponentType addressComponentType : AddressComponentType.values()) {
            if (addressComponentType.code.equals(code)) {
                return addressComponentType;
            }
        }

        return null;
    }
}
