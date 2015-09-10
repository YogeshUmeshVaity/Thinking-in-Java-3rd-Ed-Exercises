//: c08:music5:Music5.java
// Interfaces.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package Ex7.music5;
import com.bruceeckel.simpletest.*;
import Ex7.music.Note;

interface Playable {
	void play(Note n); // Automatically public
}

interface Instrument {
  // Compile-time constant:
  int I = 5; // static & final
  // Cannot have method definitions:
  String what();
  void adjust();
}

class Wind implements Instrument, Playable {
  public void play(Note n) {
    System.out.println("Wind.play() " + n);
  }
  public String what() { return "Wind"; }
  public void adjust() {}
}

class Percussion implements Instrument, Playable {
  public void play(Note n) {
    System.out.println("Percussion.play() " + n);
  }
  public String what() { return "Percussion"; }
  public void adjust() {}
}

class Stringed implements Instrument, Playable {
  public void play(Note n) {
    System.out.println("Stringed.play() " + n);
  }
  public String what() { return "Stringed"; }
  public void adjust() {}
}

class Brass extends Wind {
  public void play(Note n) {
    System.out.println("Brass.play() " + n);
  }
  public void adjust() {
    System.out.println("Brass.adjust()");
  }
}

class Woodwind extends Wind {
  public void play(Note n) {
    System.out.println("Woodwind.play() " + n);
  }
  public String what() { return "Woodwind"; }
}

public class Music5 {
  private static Test monitor = new Test();
  // Doesn't care about type, so new types
  // added to the system still work right:
  static void tune(Playable p) {
    // ...
    p.play(Note.MIDDLE_C);
  }
  static void tuneAll(Playable[] e) {
    for(int i = 0; i < e.length; i++)
      tune(e[i]);
  }
  public static void main(String[] args) {
    // Upcasting during addition to the array:
    Playable[] orchestra = {
      new Wind(),
      new Percussion(),
      new Stringed(),
      new Brass(),
      new Woodwind(),
    };
    tuneAll(orchestra);
    monitor.expect(new String[] {
      "Wind.play() Middle C",
      "Percussion.play() Middle C",
      "Stringed.play() Middle C",
      "Brass.play() Middle C",
      "Woodwind.play() Middle C"
    });
  }
} ///:~
