package de.semisimple.advent.day2;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class Operation {

  int index;

  public Operation(int index) {
    this.index = index;
  }

  public void apply(int[] p) {
    Opcode opcode = Opcode.of(p[index]);
    if (Opcode.FINISH.equals(opcode)) {
      throw new RuntimeException("FINISH");
    }

    Integer result = opcode.apply(getTargetValue(p, 1), getTargetValue(p, 2));
    int saveIndex = p[index + 3];
    p[saveIndex] = result;
  }

  private int getTargetValue(int[] p, int offset) {
    return p[p[index + offset]];
  }

  private enum Opcode {

    ADD(1, (a, b) -> a + b),
    MULTIPLY(2, (a, b) -> a * b),
    FINISH(99, (a, b) -> {
      throw new UnsupportedOperationException("99 has no calculation");
    });

    private int code;
    private BinaryOperator<Integer> calculation;

    Opcode(int code, BinaryOperator<Integer> calculation) {
      this.code = code;
      this.calculation = calculation;

    }

    public static Opcode of(int code) {
      return Arrays.stream(Opcode.values())
          .filter(it -> it.code == code)
          .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public Integer apply(int a, int b) {
      return calculation.apply(a, b);
    }

  }

}
