package main.itinerary.application;

import main.itinerary.domain.Itinerary;
import java.util.List;

public interface ItineraryService {
    Itinerary save(Itinerary itinerary);
    List<Itinerary> getItinerariesByTravelId(int travelId);
    List<Itinerary> getAllItineraries();

    boolean travelExists(int travelId);
}
