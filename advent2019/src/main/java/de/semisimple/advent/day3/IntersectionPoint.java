package de.semisimple.advent.day3;


import java.util.Objects;

public class IntersectionPoint extends Point {

  public long combinedDistanceCovered;

  public IntersectionPoint(Point p, long distanceCoveredC0, long distanceCoveredC1) {
    super(p.x, p.y);
    this.combinedDistanceCovered = distanceCoveredC0 + distanceCoveredC1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    IntersectionPoint that = (IntersectionPoint) o;
    return combinedDistanceCovered == that.combinedDistanceCovered;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), combinedDistanceCovered);
  }
}
