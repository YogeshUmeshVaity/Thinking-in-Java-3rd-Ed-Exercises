//: c07:music3:Music3.java
// An extensible program.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package Ex4.music3;
//import com.bruceeckel.simpletest.*;
import Ex4.music.Note;

class Instrument {
  void play(Note n) {
    System.out.println("Instrument.play() " + n);
  }
  public String toString() { return "Instrument"; }
  void adjust() {}
}

class Wind extends Instrument {
  void play(Note n) {
    System.out.println("Wind.play() " + n);
  }
  public String toString() { return "Wind"; }
  void adjust() {}
}

class Percussion extends Instrument {
  void play(Note n) {
    System.out.println("Percussion.play() " + n);
  }
  public String toString() { return "Percussion"; }
  void adjust() {}
}

class Stringed extends Instrument {
  void play(Note n) {
    System.out.println("Stringed.play() " + n);
  }
  public String toString() { return "Stringed"; }
  void adjust() {}
}

class Electronic extends Instrument {
	void play(Note n) {
		System.out.println("Electronic.play() " + n);
	}
	public String toString() { return "Electronic"; }
	void adjust() {}
}

class Brass extends Wind {
  void play(Note n) {
    System.out.println("Brass.play() " + n);
  }
  void adjust() {
    System.out.println("Brass.adjust()");
  }
}

class Woodwind extends Wind {
  void play(Note n) {
    System.out.println("Woodwind.play() " + n);
  }
  public String toString() { return "Woodwind"; }
}

public class Music3 {
  //private static Test monitor = new Test();
  // Doesn't care about type, so new types
  // added to the system still work right:
  public static void tune(Instrument i) {
    // ...
    i.play(Note.MIDDLE_C);
  }
  public static void tuneAll(Instrument[] e) {
    for(int i = 0; i < e.length; i++) {
      tune(e[i]);
	  System.out.println(e[i]);
	}
  }
  public static void main(String[] args) {
    // Upcasting during addition to the array:
    Instrument[] orchestra = {
      new Wind(),
      new Percussion(),
      new Stringed(),
      new Brass(),
      new Woodwind(),
	  new Electronic()
    };
    tuneAll(orchestra);
    /* monitor.expect(new String[] {
      "Wind.play() Middle C",
      "Percussion.play() Middle C",
      "Stringed.play() Middle C",
      "Brass.play() Middle C",
      "Woodwind.play() Middle C"
    }); */
  }
} ///:~
