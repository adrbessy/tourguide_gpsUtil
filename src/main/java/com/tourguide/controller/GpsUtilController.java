package com.tourguide.controller;

import com.tourguide.service.GpsUtilService;
import java.util.List;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

@RestController
public class GpsUtilController {

  private static final Logger logger = LogManager.getLogger(GpsUtilController.class);

  @Autowired
  GpsUtilService gpsUtilService;

  /**
   * Get last user location
   *
   * @param userId user id
   * @return last user location
   */
  @GetMapping("/userLocation")
  public VisitedLocation getUserLocation(@RequestParam UUID userId) {
    logger.info("Get request with the endpoint 'userLocation'");
    VisitedLocation visitedLocation = gpsUtilService.getUserLocation(userId);
    return visitedLocation;
  }

  /**
   * Get all the attractions
   * 
   * @return a list of all attractions
   */
  @GetMapping("/attractions")
  public List<Attraction> getAttractions() {
    logger.info("Get request with the endpoint 'attractions'");
    return gpsUtilService.getAttractions();
  }


}