package ch.bbw.m151.freshwater_fish;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

public class FreshwaterFish {

    @Entity
    public class FreshwaterFish {

        @javax.persistence.Id
        private Long id;

        public FreshwaterFish(String name, String species) {
            this.name = name;
            this.species = species;
        }

        @Id
        String name;
        String species;
        @OneToMany(mappedBy = "fish")
        List<FreshwaterFish>  FreshwaterFish;
        public FreshwaterFish() {

        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }
}
