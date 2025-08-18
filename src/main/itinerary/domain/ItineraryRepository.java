package main.itinerary.domain;

import main.common.domain.Repository;
import java.util.List;


public interface ItineraryRepository extends Repository<Itinerary, Integer> {
    List<Itinerary> findItinerariesByTravelId(int travelId);
}
