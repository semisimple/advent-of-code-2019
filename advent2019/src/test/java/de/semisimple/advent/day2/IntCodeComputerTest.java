package de.semisimple.advent.day2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class IntCodeComputerTest {

  @Test
  void run_exampleProgramm_returnExampleResult() {
    IntCodeComputer intCodeComputer = new IntCodeComputer();

    int[] programm0 = {1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50};
    int[] programm1 = {1, 0, 0, 0, 99};
    int[] programm2 = {2, 3, 0, 3, 99};
    int[] programm3 = {2, 4, 4, 5, 99, 0};
    int[] programm4 = {1, 1, 1, 4, 99, 5, 6, 0, 99};

    assertAll("Example programs",
        () -> assertArrayEquals(new int[]{3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50},
            intCodeComputer.run(programm0)),
        () -> assertArrayEquals(new int[]{2, 0, 0, 0, 99}, intCodeComputer.run(programm1)),
        () -> assertArrayEquals(new int[]{2, 3, 0, 6, 99}, intCodeComputer.run(programm2)),
        () -> assertArrayEquals(new int[]{2, 4, 4, 5, 99, 9801}, intCodeComputer.run(programm3)),
        () -> assertArrayEquals(new int[]{30, 1, 1, 4, 2, 5, 6, 0, 99},
            intCodeComputer.run(programm4)));
  }
}
