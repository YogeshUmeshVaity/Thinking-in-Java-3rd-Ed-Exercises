public class WithSleep {
  public static void main(String[] args) {
    final int NUMBER_OF_OBJECTS = 10000;
    final long delayTime = 30;
    for(int i = 0; i < NUMBER_OF_OBJECTS; i++) {
      final int TEMP_I = i;
      new Thread() {
        @Override
        public void run() {
          try {
            sleep(delayTime);
          } catch(InterruptedException e) {
            throw new RuntimeException(e);
          }
          System.out.println("Task " + TEMP_I 
          + " in Progress...");
          int x = 9, y = 36;
          int z = 0;
          z = x * y;
          return;
        }
      }.start();
    }
    try {
      Thread.sleep(9000);
    } catch(InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
