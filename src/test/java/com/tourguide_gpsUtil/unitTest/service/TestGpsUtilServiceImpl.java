package com.tourguide_gpsUtil.unitTest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import com.tourguide_gpsUtil.service.GpsUtilService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import gpsUtil.location.VisitedLocation;

@SpringBootTest()
public class TestGpsUtilServiceImpl {

  @Autowired
  private GpsUtilService gpsUtilService;

  @MockBean
  GpsUtil gpsUtilMock;

  @Test
  public void testGetUserLocationIfNoVisitedLocation() {
    UUID userId = UUID.randomUUID();
    Location location = new Location(0.1, 0.2);
    VisitedLocation visitedLocation = new VisitedLocation(UUID.randomUUID(), location,
        new Date());

    when(gpsUtilMock.getUserLocation(userId)).thenReturn(visitedLocation);

    VisitedLocation result = gpsUtilService.getUserLocation(userId);

    assertThat(result).isEqualTo(visitedLocation);
  }

  @Test
  public void testGetAttractions() throws Exception {
    Attraction attraction = new Attraction("attractionNam", "city", "state", 0.3, 2.3);
    List<Attraction> attractionList = new ArrayList<>();
    attractionList.add(attraction);

    when(gpsUtilMock.getAttractions()).thenReturn(attractionList);

    List<Attraction> result = gpsUtilService.getAttractions();

    assertThat(result).isEqualTo(attractionList);
  }

}
