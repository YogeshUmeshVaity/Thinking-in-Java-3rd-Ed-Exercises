/* Using the mutable-companion-class technique, make an immutable 
 * class containing an int, a double, and an array of char.
 */

public class Notebook {
  private int pages;
  private double heightInches;
  private char[] brandName = new char[36];
  
  public Notebook(int pgs, double height, char[] brand) {
    pages = pgs;
    heightInches = height;
    brandName = brand;
  }
  
  public int getPages() {
    return pages;
  }
  
  public double getHeight() {
    return heightInches;
  }
  
  public char[] getBrandName() {
    return brandName;
  }
  
  public Notebook modify(int pgs, double hgt, char[] brnd) {
    return new Notebook(pgs, hgt, brnd);
  }
  
  @Override
  public String toString() {
    String brandNameString = new String(brandName);
    return "" + pages + " " + heightInches + " " + brandNameString;
  }
  
  public static void main(String[] args) {
    Notebook n1 = new Notebook(99, 9.9, 
      new char[] {'d', 'e', 'l', 'l'});
    System.out.println("n1 before modify : " + n1);
    Notebook n1Copy = n1.modify(102, 10.2,
      new char[] {'I', 'B', 'M'});
    System.out.println("n1 after modify : " + n1);
    System.out.println("n1Copy after modify : " + n1Copy);
  }
  
}
