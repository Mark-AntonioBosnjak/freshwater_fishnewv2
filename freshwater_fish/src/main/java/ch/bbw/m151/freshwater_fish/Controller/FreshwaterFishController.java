package ch.bbw.m151.freshwater_fish.Controller;

import ch.bbw.m151.freshwater_fish.Fish;
import ch.bbw.m151.freshwater_fish.FreshwaterFish;
import ch.bbw.m151.freshwater_fish.FreshwaterFishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/project")
public class FreshwaterFishController {

    private final FreshwaterFishRepository freshwaterFishRepository;

    @Autowired
    public FreshwaterFishController(FreshwaterFishRepository freshwaterFishRepository) {
        this.freshwaterFishRepository = freshwaterFishRepository;
    }
    @GetMapping("/Fish/{detailsURL}/{imageURL}")
    public ResponseEntity<List<Fish>> getAllByDetailsURLAndImageURL(@PathVariable String detailsURL,
                                                                    @PathVariable String imageURL) {
        List<FreshwaterFish> Fish;
        if (imageURL == null | detailsURL == null) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.FORBIDDEN);
        } else {
            Fish = freshwaterFishRepository.findAllByImage(imageURL);
        }
        return new ResponseEntity<>(Fish, HttpStatus.OK);
    }

    @GetMapping("/Fish/{name}")
    public ResponseEntity<List<Fish>> getAllByName(@PathVariable String name) {
        List<FreshwaterFish.FreshwaterFish> Fish;
        if (name == null) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.FORBIDDEN);
        } else {
            Fish = freshwaterFishRepository.findAllById(name);
        }

        return new ResponseEntity<>(Fish, HttpStatus.OK);
    }


    @GetMapping("/Fish/all")
    public ResponseEntity<List<Fish>> getAll() {
        List<FreshwaterFish> Fish = freshwaterFishRepository.findAll();
        return new ResponseEntity<>(Fish, HttpStatus.OK);
    }
}