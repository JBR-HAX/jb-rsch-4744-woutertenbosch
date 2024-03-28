package org.jetbrains.assignment.models;

public enum MoveDirection {
    EAST(1, 0), WEST(-1, 0), NORTH(0, 1), SOUTH(0, -1);

    MoveDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
