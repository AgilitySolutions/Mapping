package com.agilitysolutions.mapping.geocoding.request.builders

import com.agilitysolutions.mapping.geocoding.library.Bounds
import com.agilitysolutions.mapping.geocoding.library.Location
import com.agilitysolutions.mapping.geocoding.library.Request
import com.google.code.geocoder.GeocoderRequestBuilder
import com.google.code.geocoder.model.LatLng
import com.google.code.geocoder.model.LatLngBounds
import org.mockito.Mockito

class GoogleGeocoderRequestBuilderTest extends GroovyTestCase {
    private GoogleGeocoderRequestBuilder _googleGeocoderRequestBuilder;
    private Request _request;
    private GeocoderRequestBuilder _mockGeocoderRequestBuilder;

    void setUp() {
        super.setUp()

        _request = new Request();
        _mockGeocoderRequestBuilder = Mockito.mock(GeocoderRequestBuilder.class);

        _googleGeocoderRequestBuilder = new GoogleGeocoderRequestBuilder(_mockGeocoderRequestBuilder);
    }

    void testBuild() {
        _request.setAddress("Test Address");
        _request.setLanguage("en");
        _request.setRegion("Test Region");

        Bounds bounds = new Bounds();

        Location northeast = new Location();
        northeast.setLatitude(BigDecimal.valueOf(34.236144));
        northeast.setLongitude(BigDecimal.valueOf(-118.500938));

        bounds.setNortheast(northeast);

        Location southwest = new Location();
        southwest.setLatitude(BigDecimal.valueOf(34.172684));
        southwest.setLongitude(BigDecimal.valueOf(-118.604794));

        bounds.setSouthwest(southwest);

        _request.setBounds(bounds);

        Location location = new Location();
        location.setLatitude(BigDecimal.valueOf(34.236144));
        location.setLongitude(BigDecimal.valueOf(-118.500938));

        _request.setLocation(location);

        _googleGeocoderRequestBuilder.build(_request);

        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setLanguage(_request.getLanguage());
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setRegion(_request.getRegion());
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setAddress(_request.getAddress());
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setBounds(Mockito.any(LatLngBounds.class));
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setLocation(Mockito.any(LatLng.class));
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).getGeocoderRequest();
    }

    void testBuildWithoutBounds() {
        _request.setAddress("Test Address");
        _request.setLanguage("en");
        _request.setRegion("Test Region");

        Location location = new Location();
        location.setLatitude(BigDecimal.valueOf(34.236144));
        location.setLongitude(BigDecimal.valueOf(-118.500938));

        _request.setLocation(location);

        _googleGeocoderRequestBuilder.build(_request);

        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setLanguage(_request.getLanguage());
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setRegion(_request.getRegion());
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setAddress(_request.getAddress());
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setBounds(Mockito.any(LatLngBounds.class));
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setLocation(Mockito.any(LatLng.class));
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).getGeocoderRequest();
   }

    void testBuildWithoutLocation() {
        _request.setAddress("Test Address");
        _request.setLanguage("en");
        _request.setRegion("Test Region");

        Bounds bounds = new Bounds();

        Location northeast = new Location();
        northeast.setLatitude(BigDecimal.valueOf(34.236144));
        northeast.setLongitude(BigDecimal.valueOf(-118.500938));

        bounds.setNortheast(northeast);

        Location southwest = new Location();
        southwest.setLatitude(BigDecimal.valueOf(34.172684));
        southwest.setLongitude(BigDecimal.valueOf(-118.604794));

        bounds.setSouthwest(southwest);

        _request.setBounds(bounds);

        _googleGeocoderRequestBuilder.build(_request);

        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setLanguage(_request.getLanguage());
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setRegion(_request.getRegion());
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setAddress(_request.getAddress());
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setBounds(Mockito.any(LatLngBounds.class));
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).setLocation(Mockito.any(LatLng.class));
        Mockito.verify(_mockGeocoderRequestBuilder, Mockito.times(1)).getGeocoderRequest();
    }
}
