package main.itinerary.application;

import main.itinerary.domain.Itinerary;
import main.itinerary.domain.ItineraryRepository;
import main.travel.application.TravelService;

import java.util.List;
import java.util.Objects;

public class ItineraryServiceImpl implements ItineraryService {
    private final ItineraryRepository repo;
    private final TravelService travelService;

    public ItineraryServiceImpl(ItineraryRepository repo, TravelService travelService) {
        this.repo = Objects.requireNonNull(repo);
        this.travelService = Objects.requireNonNull(travelService);
    }

    @Override
    public Itinerary save(Itinerary itinerary) {
        return repo.save(itinerary);
    }

    @Override
    public List<Itinerary> getItinerariesByTravelId(int travelId) {
        return repo.findItinerariesByTravelId(travelId);
    }

    @Override
    public List<Itinerary> getAllItineraries() {
        return repo.findAll();
    }

    @Override
    public boolean travelExists(int travelId) {
        return travelService.travelExists(travelId);
    }
}