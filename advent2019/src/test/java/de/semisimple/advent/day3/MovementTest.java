package de.semisimple.advent.day3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MovementTest {

  @Test
  void parse_StringCodedMovement_ReturnsMovement() {

    assertAll("Movement parsing assertion",
        () -> assertMovement("D1", Direction.DOWN, 1),
        () -> assertMovement("U2", Direction.UP, 2),
        () -> assertMovement("L99", Direction.LEFT, 99),
        () -> assertMovement("R367", Direction.RIGHT, 367)
    );
  }


  private void assertMovement(String code, Direction expectedDirection, int expectedSteps) {
    final Movement m = Movement.parse(code);
    assertAll(
        () -> assertEquals(expectedSteps, m.steps),
        () -> assertEquals(expectedDirection, m.direction)
    );
  }

  @Test
  void move_StartPosition_ReturnsCorrectNewPosition() {
    assertEquals((new Point(0, -44)), Movement.parse("D44").move(new Point(0, 0)));
  }
}