package kea.touristguide.controller;

import kea.touristguide.model.TouristAttraction;
import kea.touristguide.service.TouristService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<TouristAttraction>> getAllTouristAttractions() {
        return ResponseEntity.ok(touristService.getAllTouristAttractions());
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getTouristAttraction(@PathVariable String name) {
        return ResponseEntity.ok(touristService.getTouristAttraction(name));
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction newTouristAttraction) {
        TouristAttraction newlyAddedTouristAttraction = touristService.addTouristAttraction(newTouristAttraction);
        return ResponseEntity.ok(newlyAddedTouristAttraction);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@PathVariable String name, @RequestBody TouristAttraction updatedTouristAttraction) {
        return ResponseEntity.ok(touristService.updateTouristAttraction(name, updatedTouristAttraction));
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@PathVariable String name) {
        return ResponseEntity.ok(touristService.deleteTouristAttraction(name));
    }
}
