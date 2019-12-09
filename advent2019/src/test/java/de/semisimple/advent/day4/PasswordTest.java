package de.semisimple.advent.day4;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PasswordTest {

  @Test
  void of_createsDigitArray() {
    assertAll("Digits are parsed right",
        () -> assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1}, Password.of(111111).digits),
        () -> assertArrayEquals(new int[]{1, 2, 3, 7, 8, 9}, Password.of(123789).digits),
        () -> assertArrayEquals(new int[]{2, 2, 3, 4, 5, 0}, Password.of(223450).digits)
    );
  }

  @Test
  void hasIdenticalDigitsNextToEachOther() {
    assertAll("Valid passwords need to have two identical digits next to each other.",
        () -> assertTrue(Password.of(111111).hasIdenticalDigitsNextToEachOther()),
        () -> assertFalse(Password.of(123789).hasIdenticalDigitsNextToEachOther()),
        () -> assertTrue(Password.of(223450).hasIdenticalDigitsNextToEachOther())
    );
  }

  @Test
  void isSortedAscending() {
    assertAll("Valid passwords need to be sorted ascending",
        () -> assertTrue(Password.of(111111).isSortedAscending()),
        () -> assertTrue(Password.of(123789).isSortedAscending()),
        () -> assertFalse(Password.of(223450).isSortedAscending())
    );
  }
}