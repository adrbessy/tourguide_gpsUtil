package com.tourguide_gpsUtil.unitTest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.tourguide_gpsUtil.service.GpsUtilService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import gpsUtil.location.VisitedLocation;

@SpringBootTest
@AutoConfigureMockMvc
public class TestGpsUtilController {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  GpsUtilService gpsUtilServiceMock;

  @Test
  public void testGetUserLocation() throws Exception {
    UUID userId = UUID.randomUUID();
    Location location = new Location(0.1, 0.2);
    VisitedLocation visitedLocation = new VisitedLocation(UUID.randomUUID(), location,
        new Date());

    when(gpsUtilServiceMock.getUserLocation(userId)).thenReturn(visitedLocation);

    mockMvc.perform(get("/userLocation?userId=" + userId)).andExpect(status().isOk());
  }

  @Test
  public void testGetAttractions() throws Exception {
    Attraction attraction = new Attraction("attractionNam", "city", "state", 0.3, 2.3);
    List<Attraction> attractionList = new ArrayList<>();
    attractionList.add(attraction);

    when(gpsUtilServiceMock.getAttractions()).thenReturn(attractionList);

    mockMvc.perform(get("/attractions")).andExpect(status().isOk());
  }

}
