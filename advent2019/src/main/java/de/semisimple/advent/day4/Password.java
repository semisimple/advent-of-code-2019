package de.semisimple.advent.day4;

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
    return IntStream.range(0, this.length - 1).anyMatch(i -> this.digits[i] == this.digits[i + 1]);
  }

  public boolean isSortedAscending() {
    return !IntStream.range(0, this.length - 1).anyMatch(i -> this.digits[i] > this.digits[i + 1]);
  }


}
