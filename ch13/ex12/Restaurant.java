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
  public void run() {
    while(true) {
      // WaitPerson generates an order and adds it to the
      // incomingOrders and goes on wait()
      synchronized(restaurant.outgoingOrders) {
        Order order = new Order(this);
        restaurant.incomingOrders.add(order);
      }
      synchronized(this) {
        try {
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
            .getName() + " got " + restaurant.order);
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
  Queue incomingOrders = new LinkedList(); // incoming for chef
  Queue outgoingOrders = new LinkedList(); // outgoing for chef
  //Order order; // Package access
  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant();
    WaitPerson waitPerson = new WaitPerson("Chhotu", restaurant);
    Chef chef = new Chef(restaurant, waitPerson);
  }
} ///:~
