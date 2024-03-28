package org.jetbrains.assignment.models;

public record Location(int x, int y) {

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}