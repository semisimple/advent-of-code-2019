package de.semisimple.advent.day3;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Edge {

  Point a;
  Point b;
  long sumOfEdges;

  public Edge(Point startPoint, Point endPoint, int sumOfEdges) {
    this.a = startPoint;
    this.b = endPoint;
    this.sumOfEdges = sumOfEdges;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Edge edge = (Edge) o;
    return sumOfEdges == edge.sumOfEdges &&
        Objects.equals(a, edge.a) &&
        Objects.equals(b, edge.b);
  }

  @Override
  public int hashCode() {
    return Objects.hash(a, b, sumOfEdges);
  }

  public Set<IntersectionPoint> overlap(Edge e) {
    Set<Integer> xOverlapp = findOverlappInOneDimension(a.x, b.x, e.a.x, e.b.x);
    Set<Integer> yOverlapp = findOverlappInOneDimension(a.y, b.y, e.a.y, e.b.y);

    final Set<Point> points = xOverlapp.stream()
        .map(x -> createPoints(yOverlapp, x))
        .flatMap(Collection::stream)
        .collect(Collectors.toSet());

    return points.stream()
        .map(it -> new IntersectionPoint(it, e.distanceEdgeToPoint(it),
            distanceEdgeToPoint(it)))
        .collect(Collectors.toSet());

  }

  private long distanceEdgeToPoint(Point it) {
    return it.calculateDistance(this.a) + this.sumOfEdges;
  }


  private Set<Point> createPoints(Set<Integer> yOverlapp, Integer x) {
    return yOverlapp.stream()
        .map(y -> new Point(x, y))
        .collect(Collectors.toSet());
  }

  Set<Integer> findOverlappInOneDimension(int e0, int e1, int d0, int d1) {
    final int endE = Math.max(e0, e1);
    final int startE = Math.min(e0, e1);
    final int endD = Math.max(d0, d1);
    final int startD = Math.min(d0, d1);

    final int start = Math.max(startE, startD);
    final int ende = Math.min(endE, endD);
    return IntStream.range(start, ende + 1).mapToObj(Integer::valueOf).collect(Collectors.toSet());
  }


}
