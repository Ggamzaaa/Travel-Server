package main.travel.application;

import main.travel.domain.Travel;
import main.travel.domain.TravelRepository;

import java.util.List;
import java.util.Objects;

public class TravelServiceImpl implements TravelService {
    private final TravelRepository repo;

    public TravelServiceImpl(TravelRepository repo) {
        this.repo = Objects.requireNonNull(repo);
    }

    public Travel save(Travel travel) {
        return repo.save(travel);
    }

    public List<Travel> listAll() {
        return repo.findAll();
    }
    
    @Override
    public boolean travelExists(int travelId) {
        return repo.findById(travelId).isPresent();
    }
}
