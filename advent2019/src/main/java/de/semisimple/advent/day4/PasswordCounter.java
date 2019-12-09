package de.semisimple.advent.day4;

import java.util.stream.IntStream;

public class PasswordCounter {

  private final int from;
  private final int to;

  public PasswordCounter(int from, int to) {
    this.from = from;
    this.to = to;
  }

  public long countPasswordsInRange() {
    return IntStream.range(from, to)
        .mapToObj(Password::of)
        .filter(Password::hasIdenticalDigitsNextToEachOther)
        .filter(Password::isSortedAscending)
        .count();

  }
}