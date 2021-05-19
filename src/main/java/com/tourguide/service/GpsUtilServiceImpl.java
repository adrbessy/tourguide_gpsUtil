package com.tourguide.service;

import java.util.List;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

@Service
public class GpsUtilServiceImpl implements GpsUtilService {

  private static final Logger logger = LogManager.getLogger(GpsUtilServiceImpl.class);

  GpsUtil gpsUtil;

  /**
   * Get the last user location
   * 
   * @param userId user id
   * @return last user visited location
   */
  @Override
  public VisitedLocation getUserLocation(UUID userId) {
    logger.debug(gpsUtil.getUserLocation(userId));
    return gpsUtil.getUserLocation(userId);
  }

  /**
   * Get all the attractions
   * 
   * @return a list of attractions
   */
  @Override
  public List<Attraction> getAttractions() {
    logger.debug("getAttractionsGpsUtil");
    return gpsUtil.getAttractions();
  }

}
