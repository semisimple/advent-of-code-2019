package de.semisimple.advent.day3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DirectionTest {

  @Test
  void parseDirection_DirectionLetters_ResolvesDirection() {
    assertAll("Direction parse",
        () -> assertEquals(Direction.UP, Direction.parseDirection("U")),
        () -> assertEquals(Direction.DOWN, Direction.parseDirection("D")),
        () -> assertEquals(Direction.RIGHT, Direction.parseDirection("R")),
        () -> assertEquals(Direction.LEFT, Direction.parseDirection("L")));

  }
}