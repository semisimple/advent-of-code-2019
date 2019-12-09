package de.semisimple.advent.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Password {

  final int password;
  final int length;
  final int[] digits;

  public Password(int password, int[] digits) {
    this.password = password;
    this.digits = digits;
    this.length = digits.length;
  }

  public static Password of(int password) {
    int[] d = new int[6];
    IntStream.range(0, d.length).forEach(i -> d[d.length - (i + 1)] = getDigit(password, i));
    return new Password(password, d);
  }

  static int getDigit(int password, int i) {
    final int pow = (int) Math.pow(10, i);
    final int d = password / pow;
    return d % 10;
  }

  public boolean hasIdenticalDigitsNextToEachOther() {
    return IntStream.range(0, this.length - 1).anyMatch(i -> digitsNeighborsAreSame(i));
  }

  public boolean isSortedAscending() {
    return !IntStream.range(0, length - 1).anyMatch(i -> digits[i] > digits[i + 1]);
  }


  public boolean isNotInLargerGroup() {
    Map<Integer, Integer> counts = new HashMap<>();

    IntStream.range(0, length)
        .filter(this::hasIndenticalNeighbor)
        .forEach(it -> updateMap(counts, digits[it]));

    return counts.entrySet().stream().anyMatch(it -> 3 > it.getValue());
  }

  private boolean hasIndenticalNeighbor(int i) {
    if (i == 0) {
      return digitsNeighborsAreSame(i);
    } else if (i < length - 1) {
      return digitsNeighborsAreSame(i) || digitsNeighborsAreSame(i - 1);
    } else {
      return digitsNeighborsAreSame(i - 1);
    }
  }

  private void updateMap(Map<Integer, Integer> counts, Integer key) {
    final Integer oldValue = counts.get(key);
    counts.put(key, oldValue != null ? oldValue + 1 : 1);
  }

  private boolean digitsNeighborsAreSame(int i) {
    return this.digits[i] == this.digits[i + 1];
  }
}
