package de.semisimple.advent.day3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.Test;

class EdgeTest {

  @Test
  void findOverlapp() {
    final Edge e0 = new Edge(new Point(0, 0), new Point(0, 3), 0);
    final Edge e1 = new Edge(new Point(0, 0), new Point(3, 0), 0);
    final Edge e2 = new Edge(new Point(0, 1), new Point(3, 1), 0);

    final IntersectionPoint p = new IntersectionPoint(new Point(0, 0), 0, 0);

    final Set<IntersectionPoint> overlap = e0.overlap(e1);
    assertAll("Intersections or overlap of Edges",
        () -> assertEquals(1, overlap.size()),
        () -> assertTrue(overlap.contains(p)),
        () -> assertTrue(e1.overlap(e2).isEmpty())
    );

  }
}