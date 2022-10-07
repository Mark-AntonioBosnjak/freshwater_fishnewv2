package ch.bbw.m151.freshwater_fish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FreshwaterFishRepository extends JpaRepository<FreshwaterFish, String> {

    List<FreshwaterFish> findAllByImage(String image);
    List<FreshwaterFish> findAllWhereFishisSpecies();
    void deleteAllById(String name);
    List<FreshwaterFish.FreshwaterFish> findAllById(String name);
}
