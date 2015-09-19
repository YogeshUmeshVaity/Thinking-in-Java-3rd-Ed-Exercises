/*
 * Modify Restaurant.java so that multiple WaitPersons generate 
 * order requests to multiple Chefs, who produce orders and 
 * notify the WaitPerson who generated the request. You’ll need 
 * to use queues for both incoming order requests and outgoing 
 * orders.
 */
 
import java.util.*;
import com.bruceeckel.simpletest.*;

class Order {
  // Reference that Chef will use to notify
  
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
  public WaitPerson(String waitPersonName, Restaurant r) {
    super(waitPersonName);
    restaurant = r;
    start();
  }
  public void run() {
    while(true) {
      while(restaurant.order == null)
        synchronized(this) {
          try {
            wait();
          } catch(InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      System.out.println(Thread.currentThread().getName() 
      + " got " + restaurant.order);
      restaurant.order = null;
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
        synchronized(waitPerson) {
          waitPerson.notify();
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
  private static Test monitor = new Test();
  Queue incomingOrders = new LinkedList();
  Queue outgoingOrders = new LinkedList();
  //Order order; // Package access
  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant();
    WaitPerson waitPerson = new WaitPerson("Chhotu", restaurant);
    Chef chef = new Chef(restaurant, waitPerson);
  }
} ///:~
