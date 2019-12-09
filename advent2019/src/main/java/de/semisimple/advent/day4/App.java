package de.semisimple.advent.day4;

import de.semisimple.advent.day3.Movement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) throws IOException {

    Path path = Paths.get("advent2019/src/main/resources/day4/input");
    final Stream<String> lines = Files.lines(path);
    final List<String> stringList = lines.collect(Collectors.toList());

    final String[] split = stringList.get(0).split("-");
    int from = Integer.parseInt(split[0]);
    int to = Integer.parseInt(split[1]);

    final PasswordCounter p = new PasswordCounter(from, to);

    final long result = p.countPasswordsInRange();

    System.out.println("#Passwords:" + result);


  }

  private static List<Movement> createMovementList(String line) {
    return Arrays.stream(line.split(","))
        .map(Movement::parse)
        .collect(Collectors.toList());
  }

}
