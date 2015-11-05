/* Create a class called Battery containing an int that is a 
 * battery number (as a unique identifier). Make it cloneable and 
 * give it a toString( ) method. Now create a class called Toy 
 * that contains an array of Battery and a toString( ) that 
 * prints out all the batteries. Write a clone( ) for Toy that 
 * automatically clones all of its Battery objects. Test this by 
 * cloning Toy and printing the result.
 */

class Battery implements Cloneable {
  private int id;
  
  private static int count = 0;
  Battery() {
    id = count++;
  }
  
  @Override 
  public String toString() {
    return Integer.toString(id);
  }
  
  @Override
  public Object clone() {
    Object o = null;
    try {
      o = super.clone();
    } catch(CloneNotSupportedException e) {
      System.out.println("Cannot clone Battery");
    }
    return o;
  }
  
}

class Toy implements Cloneable {
  private Battery[] batteries = 
    { new Battery(), new Battery(), new Battery() };
  
  @Override
  public String toString() {
    String s = "";
    for(int i = 0; i < batteries.length; i++) {
      s += batteries[i];
      s += ", ";
    }
    return s;
  }
  
  @Override
  public Object clone() {
    Toy o = null;
    try {
      o = (Toy)super.clone();
    } catch(CloneNotSupportedException e) {
      System.out.println("Cannot clone Toy");
    }
    o.batteries = this.batteries.clone();
    for (int i = 0; i < this.batteries.length; i++) {
      o.batteries[i] = (Battery)(this.batteries[i].clone());
    }
    return o;
  }
  
  public void changeBatteries() {
    for (int i = 0; i < batteries.length; i++) {
      batteries[i] = new Battery();
    }
  }
  
}

public class BatteryToy {

  public static void main(String[] args) {
    Toy toy = new Toy();
    Toy toyClone = (Toy)toy.clone();
    System.out.println("toy after clone : " + toy);
    System.out.println("toyClone after clone : " + toyClone);
    // changeBatteries
    toyClone.changeBatteries();
    System.out.println("toy after changeBatteries : " + toy);
    System.out.println("toyClone after changeBatteries : " +
      toyClone);
  }
  
}
