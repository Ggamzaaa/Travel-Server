package main.travel.domain;

import main.common.domain.Repository;
import java.util.Optional;

public interface TravelRepository extends Repository<Travel, Integer> {
    Optional<Travel> findById(Integer id);
}
