package de.semisimple.advent.day2;

import java.util.Optional;
import java.util.stream.IntStream;

public class IntCodeAnalyzer {

  private IntCodeComputer intCodeComputer;
  private int[] program;

  public IntCodeAnalyzer(IntCodeComputer intCodeComputer, int[] program) {
    this.intCodeComputer = intCodeComputer;
    this.program = program;
  }

  public static IntCodeAnalyzer of(IntCodeComputer intCodeComputer, int[] program) {
    return new IntCodeAnalyzer(intCodeComputer, program);
  }

  public void findNounVerbTupelFor(int result) {
    final Optional<NounVerbTupel> first = IntStream.range(1, 100000).mapToObj(NounVerbTupel::of)
        .dropWhile(it -> runCopy(it) != result).findFirst();

    first.ifPresent(
        it -> System.out.println("" + (it.noun * 100 + it.verb) + ":" + it.noun + " " + it.verb));
    System.out.println("FINISH");
  }

  private int runCopy(NounVerbTupel t) {
    final int[] clone = program.clone();
    t.passNounVerb(clone);
    final int[] result = intCodeComputer.run(clone);
    return result[0];
  }

}
