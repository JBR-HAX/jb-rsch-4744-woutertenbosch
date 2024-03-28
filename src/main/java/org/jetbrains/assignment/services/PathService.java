package org.jetbrains.assignment.services;

import org.jetbrains.assignment.models.Location;
import org.jetbrains.assignment.models.Move;
import org.jetbrains.assignment.models.MoveDirection;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The PathService class is responsible for calculating moves and applying moves to a given location.
 */
@Service
public class PathService {

    /**
     * Applies the given move to the given location and returns a new location.
     *
     * @param location the current location
     * @param move the move to apply
     * @return the new location after applying the move
     */
    public Location applyMove(final Location location, final Move move) {
        return new Location(location.x() + move.direction().getX() * move.steps(), location.y() + move.direction().getY() * move.steps());
    }

    /**
     * Calculates the moves required to move from the source location to the target location.
     *
     * @param source the starting location
     * @param target the target location
     * @return a list of moves to move from the source to the target location
     */
    public List<Move> calculateMoves(final Location source, final Location target) {
        final List<Move> moves = new ArrayList<>();

        // horizontal case
        final int xSteps = target.x() - source.x();
        if (xSteps > 0) {
            moves.add(new Move(MoveDirection.EAST, xSteps));
        }
        if (xSteps < 0) {
            moves.add(new Move(MoveDirection.WEST, -xSteps));
        }

        // vertical case
        final int ySteps = target.y() - source.y();
        if (ySteps > 0) {
            moves.add(new Move(MoveDirection.NORTH, ySteps));
        }
        if (ySteps < 0) {
            moves.add(new Move(MoveDirection.SOUTH, -ySteps));
        }

        return moves;
    }

}