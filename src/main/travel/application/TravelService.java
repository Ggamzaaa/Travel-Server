package main.travel.application;

import java.util.List;
import main.travel.domain.Travel;

public interface TravelService {
    Travel save(Travel travel);

    List<Travel> listAll();
    
    boolean travelExists(int travelId);
}
