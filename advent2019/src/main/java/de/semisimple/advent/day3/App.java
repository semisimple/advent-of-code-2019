package de.semisimple.advent.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) throws IOException {

    Path path = Paths.get("advent2019/src/main/resources/day3/input");
    final Stream<String> lines = Files.lines(path);
    final List<List<Movement>> cableMovements = lines.map(App::createMovementList)
        .collect(Collectors.toList());

    final CableTrace cableTrace0 = CableTrace.of(cableMovements.get(0));
    final CableTrace cableTrace1 = CableTrace.of(cableMovements.get(1));

    System.out.println((cableTrace0.point));
    System.out.println((cableTrace1.point));

    final OptionalLong min = cableTrace0.findIntersections(cableTrace1).stream()
        .filter(it -> it.x != 0 && it.y != 0)
        .mapToLong(it -> it.combinedDistanceCovered)
        .min();
    System.out.println(min);


  }

  private static List<Movement> createMovementList(String line) {
    return Arrays.stream(line.split(","))
        .map(Movement::parse)
        .collect(Collectors.toList());
  }

}
