package de.semisimple.advent.day2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class NounVerbTupelTest {

  @Test
  void createInZigZag_shouldReturn_diagonalTupelInZigzag() {

    assertAll("Tupel check, going in zigzag",
        () -> assertZigzagTupelValue(0, 0, 0),
        () -> assertZigzagTupelValue(1, 0, 1),
        () -> assertZigzagTupelValue(2, 1, 0),
        () -> assertZigzagTupelValue(3, 2, 0),
        () -> assertZigzagTupelValue(4, 1, 1),
        () -> assertZigzagTupelValue(5, 0, 2),
        () -> assertZigzagTupelValue(6, 0, 3),
        () -> assertZigzagTupelValue(7, 1, 2)
    );
  }

  @Test
  void of_shouldReturn_diagonalTupel() {

    assertAll("Tupel check, going in diagonals",
        () -> assertTupelValue(0, 0, 0),
        () -> assertTupelValue(1, 1, 0),
        () -> assertTupelValue(2, 0, 1),
        () -> assertTupelValue(3, 2, 0),
        () -> assertTupelValue(4, 1, 1),
        () -> assertTupelValue(5, 0, 2),
        () -> assertTupelValue(6, 3, 0),
        () -> assertTupelValue(7, 2, 1)
    );
  }


  void assertTupelValue(int index, int noun, int verb) {
    final NounVerbTupel t = NounVerbTupel.of(index);
    assertion(noun, verb, t);
  }

  void assertZigzagTupelValue(int index, int noun, int verb) {
    final NounVerbTupel t = NounVerbTupel.createInZigzag(index);
    assertion(noun, verb, t);
  }

  private void assertion(int noun, int verb, NounVerbTupel t) {
    final int[] expected = {noun, verb};
    final int[] actual = {t.noun, t.verb};
    assertArrayEquals(expected, actual);
  }
}