package org.jetbrains.assignment.services;

import org.jetbrains.assignment.models.Location;
import org.jetbrains.assignment.models.Move;
import org.jetbrains.assignment.models.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PathServiceTest {

    final PathService pathService = new PathService();

    @Test
    void testApplyMove() {
        Assertions.assertEquals(new Location(34, 52), pathService.applyMove(new Location(31, 52), new Move(MoveDirection.EAST, 3)));
        Assertions.assertEquals(new Location(31, 48), pathService.applyMove(new Location(31, 52), new Move(MoveDirection.SOUTH, 4)));
        Assertions.assertEquals(new Location(31, 57), pathService.applyMove(new Location(31, 52), new Move(MoveDirection.NORTH, 5)));
        Assertions.assertEquals(new Location(25, 52), pathService.applyMove(new Location(31, 52), new Move(MoveDirection.WEST, 6)));
    }

    @Test
    void testRequireMove() {
        Assertions.assertEquals(List.of(), pathService.calculateMoves(new Location(12, 23), new Location(12, 23)));
        Assertions.assertEquals(List.of(new Move(MoveDirection.EAST, 3)), pathService.calculateMoves(new Location(12, 23), new Location(15, 23)));
        Assertions.assertEquals(List.of(new Move(MoveDirection.EAST, 3), new Move(MoveDirection.NORTH, 2)), pathService.calculateMoves(new Location(12, 23), new Location(15, 25)));
    }

    @Test
    void testConsistency() {
        final Location source = new Location(34, 56);
        final Location target = new Location(-12, 91);

        final List<Move> moves = pathService.calculateMoves(source, target);

        Location loc = source;
        for (final Move move : moves) {
            loc = pathService.applyMove(loc, move);
        }
        Assertions.assertEquals(target, loc);
    }

}