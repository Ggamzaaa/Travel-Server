package itinerary.application;

import itinerary.domain.Itinerary;
import itinerary.domain.ItineraryRepository;

import java.time.LocalDateTime;
import java.util.Objects;
public class ItineraryFactory {
    private final ItineraryRepository itineraryRepository;

    public ItineraryFactory(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = Objects.requireNonNull(itineraryRepository);
    }

    public Itinerary newItinerary(
            int travelId,
            String departurePlace,
            String destination,
            LocalDateTime departureTime,
            LocalDateTime arrivalTime,
            LocalDateTime checkIn,
            LocalDateTime checkOut
    ) {
        int nextId = itineraryRepository.findItinerariesByTravelId(travelId).stream()
                .mapToInt(Itinerary::getItineraryId)
                .max()
                .orElse(0) + 1;

        return new Itinerary(nextId, travelId, departurePlace, destination,
                departureTime, arrivalTime, checkIn, checkOut);
    }
}
