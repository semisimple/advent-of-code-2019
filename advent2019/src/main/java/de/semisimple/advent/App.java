package de.semisimple.advent;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import de.semisimple.advent.day1.Module;

public class App {

  public static void main(String[] args) {

    Path path = Paths.get("advent2019/src/main/resources/day1/input");

    try (Stream<String> lines = Files.lines(path)) {
      long sum = lines.map(Integer::parseInt)
          .map(Module::of)
          .mapToInt(Module::calculateFuelRequirement)
          .asLongStream()
          .sum();

      System.out.println("Required Fuel: " + sum);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}