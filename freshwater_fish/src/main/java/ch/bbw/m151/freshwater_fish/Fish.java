package ch.bbw.m151.freshwater_fish;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

public class Fish {
    @NamedNativeQuery(name= "InjectionQuery", query = "delete from fish where name=(?)", resultClass = Fish.class)

    @Entity
    @Table(name = "fish")
    public class Fish {
        public Fish(String name, String species, String imageURL, String remarks, String tempRange, String phRange, String detailsURL, Lake lake) {
            this.name = name;
            this.species = species;
            this.imageURL = imageURL;
            this.remarks = remarks;
            this.tempRange = tempRange;
            this.phRange = phRange;
            this.detailsURL = detailsURL;
        }

        @Id
        String name;
        String species;
        String imageURL;
        String remarks;
        String tempRange;
        String phRange;
        String detailsURL;


        public Fish() {

        }
    }
}
