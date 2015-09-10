//: c06:Chess.java
// Inheritance, constructors and arguments.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Game {
  Game(int i) {
    System.out.println("Game constructor");
  }
}

class BoardGame extends Game {
  BoardGame(int i) {
    super(i);
    System.out.println("BoardGame constructor");
  }
}

public class Chess extends BoardGame {
  private static Test monitor = new Test();
  /* Chess() {
    super(11);
    System.out.println("Chess constructor");
  } */
  public static void main(String[] args) {
    Chess x = new Chess();
    /* monitor.expect(new String[] {
      "Game constructor",
      "BoardGame constructor",
      "Chess constructor"
    }); */
  }
} ///:~

// The compiler will synthesize a default constructor for Chess.
// But since class Game and BoardGame don't have default constructors
//(they have constructors with arguments), the compile will complain.
