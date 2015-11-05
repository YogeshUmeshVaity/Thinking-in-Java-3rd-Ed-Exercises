/* Create a class MyString containing a String object that you 
 * initialize in the constructor using the constructor’s 
 * argument. Add a toString( ) method and a method concatenate( ) 
 * that appends a String object to your internal string. 
 * Implement clone( ) in MyString. Create two static methods that 
 * each take a MyString x reference as an argument and call 
 * x.concatenate("test"), but in the second method call clone( ) 
 * first. Test the two methods and show the different effects.
 */

public class MyString implements Cloneable {
  private String stringObject;
  
  public MyString(String s) {
    stringObject = s;
  }
  
  @Override
  public String toString() {
    return stringObject;
  }
  
  public void concatenate(String conString) {
    stringObject += conString;
  }
  
  @Override
  public Object clone() {
    Object o = null;
    try {
      o = super.clone();
    } catch(CloneNotSupportedException e) {
      System.out.println("MyString cannot be cloned");
    }
    return o;
  }
  
  public static void withoutClone(MyString x) {
    x.concatenate("test");
  }
  
  public static void withClone(MyString x) {
    x = (MyString)x.clone();
    x.concatenate("test");
  }
  
  public static void main(String[] args) {
    MyString string = new MyString("Windows");
    System.out.println("stringObject initially is " + string);
    withClone(string);
    System.out.println("stringObject after withClone() is " +
      string);
    withoutClone(string);
    System.out.println("stringObject after withoutClone is " +
      string);
   
  }
  
}
