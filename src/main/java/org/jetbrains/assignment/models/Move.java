package org.jetbrains.assignment.models;

public record Move(MoveDirection direction, int steps) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return steps == move.steps && direction == move.direction;
    }

    @Override
    public String toString() {
        return "Move{" +
                "direction=" + direction +
                ", steps=" + steps +
                '}';
    }
}