package org.jetbrains.assignment.controllers;

import org.jetbrains.assignment.models.Location;
import org.jetbrains.assignment.models.Move;
import org.jetbrains.assignment.services.PathService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    private final PathService pathService;

    public LocationsController(PathService pathService) {
        this.pathService = pathService;
    }

    @PostMapping
    public List<Location> postMoves(@RequestBody List<Move> moves) {
        final Location initialLocation = new Location(0,0);
        final List<Location> locations = new ArrayList<>();
        locations.add(initialLocation);

        for (final Move move : moves) {
            Location newLocation = pathService.applyMove(locations.get(locations.size() - 1), move);
            locations.add(newLocation);
        }

        return locations;
    }

}