package de.semisimple.advent.day3;

import java.util.Objects;

public class Point {

  final int x;
  final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Point move(Movement m) {
    return m.move(this);
  }

  public int calculateDistance(Point p) {
    return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
  }

  @Override
  public String toString() {
    return "Point{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return x == point.x &&
        y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

}
