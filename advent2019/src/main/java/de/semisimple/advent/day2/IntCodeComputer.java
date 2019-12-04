package de.semisimple.advent.day2;

import java.util.stream.IntStream;

public class IntCodeComputer {

  public int[] run(final int[] program) {
    int length = program.length;

    try {
      IntStream.range(0, length)
          .filter(this::istCodeIndex)
          .mapToObj(Operation::new)
          .forEach(it -> it.apply(program));
    } catch (RuntimeException e) {
      System.err.println(e);
    }
    return program;
  }

  private boolean istCodeIndex(int it) {
    return it % 4 == 0;
  }

}
