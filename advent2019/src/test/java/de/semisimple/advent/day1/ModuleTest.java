package de.semisimple.advent.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ModuleTest {


  @Test
  public void calculateFuelRequirement_exampleMasses_returnTeirExampleRequirement() {

    assertAll("All given Examples should work",
        () -> assertEquals(2, Module.of(12).calculateFuelRequirement()),
        () -> assertEquals(2, Module.of(14).calculateFuelRequirement()),
        () -> assertEquals(966, Module.of(1969).calculateFuelRequirement()),
        () -> assertEquals(50346, Module.of(100756).calculateFuelRequirement())
    );
  }

  @Test
  public void calculateFuelRequirement_lowMasses_requireZeroFuel() {
    assertAll("Small modules break ;)",
        () -> assertEquals(0, Module.of(-1).calculateFuelRequirement()),
        () -> assertEquals(0, Module.of(0).calculateFuelRequirement()),
        () -> assertEquals(0, Module.of(5).calculateFuelRequirement())
    );
  }

}