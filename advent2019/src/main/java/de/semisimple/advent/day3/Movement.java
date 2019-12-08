package de.semisimple.advent.day3;


public class Movement {

  int steps;
  Direction direction;

  private Movement(int steps, Direction direction) {
    this.steps = steps;
    this.direction = direction;
  }

  public Point move(Point p) {
    return direction.apply(p, steps);
  }

  public static Movement parse(String codedMovement) {
    final String n = codedMovement.substring(1);
    int steps = Integer.parseInt(n);

    final String d = codedMovement.substring(0, 1);
    Direction direction = Direction.parseDirection(d);

    return new Movement(steps, direction);
  }
}
