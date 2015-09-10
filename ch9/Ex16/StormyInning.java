//: c09:StormyInning.java
// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}
class UmpireArgument extends Exception {}
class UmpireCallOff extends UmpireArgument {}

abstract class Inning {
  public Inning() throws BaseballException {}
  public void event() throws BaseballException {
    // Doesn't actually have to throw anything
  }
  public abstract void atBat() throws Strike, Foul;
  public void walk() {} // Throws no checked exceptions
  public void umpireDecideCallOff() throws UmpireCallOff {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
  public void event() throws RainedOut;
  public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
  // OK to add new exceptions for constructors, but you
  // must deal with the base constructor exceptions:
  public StormyInning() 
    throws RainedOut, BaseballException {}
  public StormyInning(String s) 
    throws Foul, BaseballException {}
  // Regular methods must conform to base class:
//! void walk() throws PopFoul {} //Compile error
  // Interface CANNOT add exceptions to existing
  // methods from the base class:
//! public void event() throws RainedOut {}
  // If the method doesn't already exist in the
  // base class, the exception is OK:
  public void rainHard() throws RainedOut {}
  public void umpireAngry() throws UmpireArgument {}
  // You can choose to not throw any exceptions,
  // even if the base version does:
  public void event() {}
  // Overridden methods can throw inherited exceptions:
  public void atBat() throws PopFoul {}
  public static void main(String[] args) {
    try {
      StormyInning si = new StormyInning();
      si.atBat();
	  si.umpireAngry();
	  si.umpireDecideCallOff();
    } catch(PopFoul e) {
      System.err.println("Pop foul");
    } catch(RainedOut e) { // this is handled for the derived class contructor StormyInning
      System.err.println("Rained out");
    } catch(BaseballException e) {// this is handled for the derived class contructor StormyInning
      System.err.println("Generic baseball exception");
    } catch(UmpireCallOff uc) {
	  System.err.println("UmpireCallOff exception");
	} catch(UmpireArgument ua) {
	  System.err.println("UmpireArgument exception");
	}
    // Strike not thrown in derived version.
    try {
      // What happens if you upcast?
      Inning i = new StormyInning();
      i.atBat();
	  i.umpireDecideCallOff();
      // You must catch the exceptions from the
      // base-class version of the method:
    } catch(Strike e) {
      System.err.println("Strike");
    } catch(Foul e) {
      System.err.println("Foul");
    } catch(RainedOut e) { // this is handled for the derived class contructor StormyInning
      System.err.println("Rained out");
    } catch(BaseballException e) { // this is handled for the derived class contructor StormyInning
      System.err.println("Generic baseball exception");
    } catch(UmpireCallOff uc) {
	  System.err.println("UmpireCallOff exception");
	}
  }
} ///:~