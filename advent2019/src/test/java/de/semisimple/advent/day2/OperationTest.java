package de.semisimple.advent.day2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class OperationTest {

  Operation operation = new Operation(0);

  @Test
  void apply_addition_yieldsCorrectResults() {
    assertAll("Some sums",
        () -> assertArrayEquals(new int[]{1, 2, 0, 1}, applyOperation(new int[]{1, 2, 0, 3})),
        () -> assertArrayEquals(new int[]{1, 2, 5, 2}, applyOperation(new int[]{1, 2, 3, 2}))
    );
  }

  @Test
  void apply_multiplication_yieldsCorrectResults() {
    assertAll("Some products",
        () -> assertArrayEquals(new int[]{0, 2, 0, 0}, applyOperation(new int[]{2, 2, 0, 0})),
        () -> assertArrayEquals(new int[]{2, 3, 1, 9}, applyOperation(new int[]{2, 3, 1, 3}))
    );
  }

  @Test
  void apply_finish_yieldsStop() {
    final RuntimeException e = assertThrows(RuntimeException.class,
        () -> operation.apply(new int[]{99}));
    assertEquals("FINISH", e.getMessage());
  }

  private int[] applyOperation(int[] input) {
    operation.apply(input);
    return input;
  }
}
