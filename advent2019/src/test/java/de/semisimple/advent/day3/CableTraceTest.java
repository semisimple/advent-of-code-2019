package de.semisimple.advent.day3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CableTraceTest {


  @Test
  void trackMovement_CableMovement_shouldTrackPosition() {
    final CableTrace cableTrace = new CableTrace();
    final Point start = cableTrace.point;

    cableTrace.trackMovement(Movement.parse("D3"));
    assertAll("All given Examples should work",
        () -> assertEquals(3, cableTrace.distanceCovered),
        () -> assertEquals(new Point(0, -3), cableTrace.point),
        () -> assertEquals(1, cableTrace.edgeList.size()),
        () -> assertEquals(new Edge(start, cableTrace.point, 0), cableTrace.edgeList.get(0))
    );

  }

  @Test
  void findIntersections_2ndCableTrace_FindsAllIntersections() {
    final CableTrace cableTrace0 = new CableTrace();

    cableTrace0.trackMovement(Movement.parse("D3"));

    final CableTrace cableTrace1 = CableTrace.of(List.of(
        Movement.parse("R1"),
        Movement.parse("D1"),
        Movement.parse("L1"),
        Movement.parse("D1"),
        Movement.parse("U1"),
        Movement.parse("R1"),
        Movement.parse("D1")
    ));

    final Set<IntersectionPoint> intersections = cableTrace0.findIntersections(cableTrace1);

    assertAll("Find all 4 Intersections with correct distance",
        () -> assertEquals(4, intersections.size()),
        () -> assertTrue(intersections.contains(new IntersectionPoint(new Point(0, 0), 0, 0))),
        () -> assertTrue(intersections.contains(new IntersectionPoint(new Point(0, -1), 3, 1))),
        () -> assertTrue(intersections.contains(new IntersectionPoint(new Point(0, -1), 5, 1))),
        () -> assertTrue(intersections.contains(new IntersectionPoint(new Point(0, -2), 4, 2)))
    );

  }
}