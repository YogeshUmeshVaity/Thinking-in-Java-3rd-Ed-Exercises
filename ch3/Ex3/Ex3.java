public class Ex3 {
    static void test(int testval, int begin, int end) {
    if((testval >= begin) && (testval <= end))
      System.out.println("testval " + testval + " is within the range of " + begin + " and " + end);
    else 
	  System.out.println("Out of range.");
  }
  public static void main(String[] args) {
    test(7, 5, 10);
    test(112, 50, 100);
    test(50, 18, 50);
    }
}
