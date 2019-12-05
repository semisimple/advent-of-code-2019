package de.semisimple.advent.day2;

class NounVerbTupel {

  public final int noun;
  public final int verb;

  private NounVerbTupel(int noun, int verb) {
    this.noun = noun;
    this.verb = verb;
  }

  public static NounVerbTupel createInZigzag(int index) {

    int n = 0;
    int v = 0;
    boolean isDirectionFlipped = false;

    for (int i = 0; i < index; i++) {
      if (v == 0 && isDirectionFlipped) {
        n++;
        isDirectionFlipped = !isDirectionFlipped;
      } else if (n == 0 && !isDirectionFlipped) {
        v++;
        isDirectionFlipped = !isDirectionFlipped;
      } else if (isDirectionFlipped) {
        v--;
        n++;
      } else {
        n--;
        v++;
      }
    }
    return new NounVerbTupel(n, v);
  }

  public static NounVerbTupel of(int index) {
    int n = 0;
    int v = 0;

    for (int i = 0; i < index; i++) {
      if (n == 0) {
        v++;
        n = v;
        v = 0;
      } else {
        n--;
        v++;
      }
    }

    return new NounVerbTupel(n, v);
  }

  public void passNounVerb(int[] program) {
    program[1] = noun;
    program[2] = verb;

  }
}

