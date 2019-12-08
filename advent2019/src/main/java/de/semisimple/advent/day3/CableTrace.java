package de.semisimple.advent.day3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CableTrace {

  int distanceCovered = 0;
  Point point = new Point(0, 0);
  List<Edge> edgeList = new ArrayList<>();


  public void trackMovement(Movement m) {
    final Point nextPoint = m.move(point);
    final Edge e = new Edge(point, nextPoint, distanceCovered);
    edgeList.add(e);

    distanceCovered += m.steps;
    point = nextPoint;
  }

  public static CableTrace of(List<Movement> movements) {
    final CableTrace cableTrace = new CableTrace();
    movements.forEach(cableTrace::trackMovement);
    return cableTrace;
  }

  public Set<IntersectionPoint> findIntersections(CableTrace c) {
    return edgeList.stream()
        .map(c::findIntersectionWithEdge)
        .flatMap(Collection::stream)
        .collect(Collectors.toSet());
  }

  private Set<IntersectionPoint> findIntersectionWithEdge(Edge edge) {
    return edgeList.stream().map(edge::overlap).flatMap(Collection::stream)
        .collect(Collectors.toSet());
  }

}
