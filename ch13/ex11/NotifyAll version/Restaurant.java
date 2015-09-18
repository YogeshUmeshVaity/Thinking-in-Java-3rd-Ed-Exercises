//: c13:Restaurant.java
// The producer-consumer approach to thread cooperation.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

class Order {
  private static int i = 0;
  private int count = i++;
  public Order() {
    if(count == 10) {
      System.out.println("Out of food, closing");
      System.exit(0);
    }
  }
  public String toString() { return "Order " + count; }
}

class WaitPerson extends Thread {
  private Restaurant restaurant;
  public WaitPerson(String threadName, Restaurant r) {
    super(threadName);
    restaurant = r;
    start();
  }
  public void run() {
    while(true) {
      while(restaurant.order == null)
        synchronized(restaurant) {
          try {
            restaurant.wait();
          } catch(InterruptedException e) {
            throw new RuntimeException(e);
          }
          // Need this statement in notifyAll version
          if(restaurant.order == null) continue;
          System.out.println(Thread.currentThread().getName() 
          + " got " + restaurant.order);
          restaurant.order = null;
        }
    }
  }
}

class Chef extends Thread {
  private Restaurant restaurant;
  private WaitPerson waitPerson;
  public Chef(Restaurant r, WaitPerson w) {
    restaurant = r;
    waitPerson = w;
    start();
  }
  public void run() {
    while(true) {
      if(restaurant.order == null) {
        restaurant.order = new Order();
        System.out.print("Order up! ");
        synchronized(restaurant) {
          restaurant.notifyAll();
        }
      }
      try {
        sleep(100);
      } catch(InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

public class Restaurant {
  Order order; // Package access
  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant();
    WaitPerson waitPerson = 
    new WaitPerson("waitPerson1", restaurant);
    WaitPerson waitPerson2 = 
    new WaitPerson("waitPerson2", restaurant);
    WaitPerson waitPerson3 = 
    new WaitPerson("waitPerson3", restaurant);
    WaitPerson waitPerson4 = 
    new WaitPerson("waitPerson4", restaurant);
    WaitPerson waitPerson5 = 
    new WaitPerson("waitPerson5", restaurant);
    WaitPerson waitPerson6 = 
    new WaitPerson("waitPerson6", restaurant);
    Chef chef = new Chef(restaurant, waitPerson);
  }
} ///:~
