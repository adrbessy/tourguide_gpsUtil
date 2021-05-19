package com.tourguide.service;

import java.util.List;
import java.util.UUID;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

public interface GpsUtilService {

  /**
   * Get the last user location
   * 
   * @param userId user id
   * @return last user visited location
   */
  VisitedLocation getUserLocation(UUID userId);

  /**
   * Get all the attractions
   * 
   * @return a list of attractions
   */
  List<Attraction> getAttractions();

}
