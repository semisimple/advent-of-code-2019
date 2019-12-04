package de.semisimple.advent.day2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) {
    IntCodeComputer intCodeComputer = new IntCodeComputer();

    Path path = Paths.get("advent2019/src/main/resources/day2/input");
    try (final Stream<String> lines = Files.lines(path)) {
      final int[] programm = lines.map(it -> it.split(","))
          .flatMap(Arrays::stream)
          .mapToInt(Integer::parseInt)
          .toArray();

      programm[1] = 12;
      programm[2] = 2;

      final int[] result = intCodeComputer.run(programm);

      System.out.println("Result (Index 0) " + result[0]);
    } catch (Exception e) {
      System.err.println(e);
    }

  }
}
