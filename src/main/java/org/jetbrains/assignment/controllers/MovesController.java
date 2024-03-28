package org.jetbrains.assignment.controllers;

import org.jetbrains.assignment.models.Location;
import org.jetbrains.assignment.models.Move;
import org.jetbrains.assignment.services.PathService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/moves")
public class MovesController {

    private final PathService pathService;

    @Autowired
    public MovesController(PathService pathService) {
        this.pathService = pathService;
    }
    @PostMapping
    public List<Move> postMoves(@RequestBody List<Location> locations) {
        final List<Move> moves = new ArrayList<>();
        Location currentLocation = new Location(0, 0);

        for (Location location : locations) {
            moves.addAll(pathService.calculateMoves(currentLocation, location));
            currentLocation = location;
        }

        return moves;
    }

}