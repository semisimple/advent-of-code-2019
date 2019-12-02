package de.semisimple.advent.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ModuleTest {


  @Test
  public void calculateFuelRequirement_exampleMasses_returnTeirExampleRequirement() {

    assertAll("All given Examples should work",
        () -> assertEquals(2, Module.of(12).calculateFuelRequirement()),
        () -> assertEquals(2, Module.of(14).calculateFuelRequirement()),
        () -> assertEquals(654, Module.of(1969).calculateFuelRequirement()),
        () -> assertEquals(33583, Module.of(100756).calculateFuelRequirement())
    );
  }

  @Test
  public void calculateFuelRequirement_lowMasses_throwIllegalArgumentException() {
    assertAll("Small modules break ;)",
        () -> assertThatMassCreationThrowsIllegalArgumentException(-1),
        () -> assertThatMassCreationThrowsIllegalArgumentException(0),
        () -> assertThatMassCreationThrowsIllegalArgumentException(5)
    );
  }

  private void assertThatMassCreationThrowsIllegalArgumentException(int a) {
    assertThrows(IllegalArgumentException.class, () -> Module.of(a));
  }
}