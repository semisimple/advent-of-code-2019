package de.semisimple.advent.day3;

import java.util.function.BiFunction;

public enum Direction {

  UP((p, s) -> new Point(p.x, p.y + s)),
  DOWN((p, s) -> new Point(p.x, p.y - s)),
  LEFT((p, s) -> new Point(p.x - s, p.y)),
  RIGHT((p, s) -> new Point(p.x + s, p.y));

  Direction(
      BiFunction<Point, Integer, Point> operator) {
    this.operator = operator;
  }

  private final BiFunction<Point, Integer, Point> operator;

  public static Direction parseDirection(String c) {
    switch (c) {
      case "U":
        return UP;
      case "D":
        return DOWN;
      case "L":
        return LEFT;
      case "R":
        return RIGHT;
      default:
        throw new IllegalArgumentException("only characters U, D, L, R are allowed");
    }
  }

  public Point apply(Point p, int steps) {
    return operator.apply(p, steps);
  }

}