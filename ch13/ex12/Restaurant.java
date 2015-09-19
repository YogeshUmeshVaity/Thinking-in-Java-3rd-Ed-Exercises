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
  public WaitPerson wp;
  private static int i = 0;
  private int count = i++;
  public Order(WaitPerson wp) {
    this.wp = wp;
    if(count == 10) {
      System.out.println("Out of food, closing");
      System.exit(0);
    }
  }
  // To notify the respective WaitPerson
  public void notifyWP() {
    synchronized(wp) {
      wp.notify();
    }
  }
  @Override
  public boolean equals(Object o) {
    Order ord = (Order)o;
    return ((o instanceof Order) && (count == ord.count));
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
  private Order order;
  public void run() {
    while(true) {
      // WaitPerson generates an order and adds it to the
      // incomingOrders and goes on wait()
      synchronized(restaurant.outgoingOrders) {
        order = new Order(this);
        System.out.println(Thread.currentThread().getName() 
        + " generated " + order);
        restaurant.incomingOrders.add(order);
      }
      synchronized(this) {
        try {
          System.out.println(Thread.currentThread().getName() 
          + " is on wait");
          wait();
        } catch(InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      // When he wakes up, he tries to retrieve his order
      // from the outgoingOrders
      synchronized(restaurant.outgoingOrders) {
        Iterator it = restaurant.outgoingOrders.iterator();
        while(it.hasNext()) {
          Order tempOrd = (Order)it.next();
          if(tempOrd.equals(order)) {
            System.out.println(Thread.currentThread()
            .getName() + " got " + tempOrd);
            it.remove(); // gives it to the customer
            break;
          }
        }
      }
    }
  }
}

class Chef extends Thread {
  private Restaurant restaurant;
  public Chef(String chefName, Restaurant r) {
    super(chefName);
    restaurant = r;
    start();
  }
  public void run() {
    while(true) {
      // Get lock on incomingOrders and fetche the first order
      synchronized(restaurant.incomingOrders) {
        if(!restaurant.incomingOrders.isEmpty()) {
          // retrieve and remove the order from queue : poll()
          Order order = (Order)restaurant.incomingOrders.poll();
          System.out.println(Thread.currentThread().getName() + 
          " is preparing " + order);
          try {
            // Time taken by Chef to prepare the order
            sleep(100);
          } catch(InterruptedException e) {
            throw new RuntimeException(e);
          }
          // add the prepared order to outgoingOrders
          synchronized(restaurant.outgoingOrders) {
            restaurant.outgoingOrders.add(order);
          }
          System.out.println(order + " is up!");
          // notify the respective WaitPerson
          order.notifyWP();
        }
      }
      yield();
    }
  }
}

public class Restaurant {
  private static Test monitor = new Test();
  Queue incomingOrders = new LinkedList(); // incoming for chef
  Queue outgoingOrders = new LinkedList(); // outgoing for chef
  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant();
    WaitPerson waitPerson = 
    new WaitPerson("WP Chhotu", restaurant);
    Chef chef = new Chef("Chef Singhania", restaurant);
  }
} ///:~
