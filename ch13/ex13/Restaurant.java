/*
 * Modify the previous exercise to add Customer objects that are 
 * also threads. The Customers will place order requests with 
 * WaitPersons, who give the requests to the Chefs, who fulfill 
 * the orders and notify the appropriate WaitPerson, who gives 
 * it to the appropriate Customer.
 */
 
import java.util.*;

class Order {
  // Reference that Chef will use to notify
  public WaitPerson wp;
  public OrderRequest req;
  private final int MAX_ORDERS = 10;
  private static int i = 0;
  private int count = i++;
  public Order(WaitPerson wp, OrderRequest req) {
    this.wp = wp;
    this.req = req;
  }
  
  public boolean isLastOrder() {
    if(count >= MAX_ORDERS) return true;
    else return false;
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

// For closing the restaurant
class OrderCheck extends Thread {
  @Override
  public void run() {
    try {
      sleep(12000);
    } catch(InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("*** Out of food, closing...***");
    System.exit(0);
  }
}

class WaitPerson extends Thread {
  private Restaurant restaurant;
  public WaitPerson(String waitPersonName, Restaurant r) {
    super(waitPersonName);
    restaurant = r;
    start();
  }
  private Order order;
  private OrderRequest tempReq;
  private boolean lastOrder = false;
  public void run() {
    while(true) {
      // WaitPerson generates an order using customerOrders 
      // and adds it to the
      // incomingOrders and goes on wait()
      // synchronized(restaurant.outgoingOrders) {
      synchronized(restaurant.customerOrders) {
        if(!restaurant.customerOrders.isEmpty()) {
          tempReq = 
          (OrderRequest)restaurant.customerOrders.poll();
          order = new Order(this, tempReq);
        } else {
            System.out.println("No order requests...");
            throw new RuntimeException();
        }
      }
      synchronized(restaurant.incomingOrders) {
        if(!order.isLastOrder()) {
          System.out.println(Thread.currentThread().getName() 
          + " generated " + order);
          restaurant.incomingOrders.add(order);
        } else if(order.isLastOrder()) {
            OrderCheck oc = new OrderCheck();
            oc.start();
            return;
        }
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
            // Give the order to respective customer
            tempOrd.req.customer.notify();
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
      yield(); // To give other Chefs a chance to prepare order.
    }
  }
}

// Represents order details that customer requests
class OrderRequest {
  // fields with order details go here...
  public Customer customer;
  public OrderRequest(Customer cust) {
    this.customer = cust;
  } 
  private static int i = 0;
  private int count = i++;
  @Override
  public String toString() { return "Order request " + count; }
  
}

class Customer extends Thread {
  private Restaurant restaurant;
  public Customer(String custName, Restaurant r) {
    super(custName);
    restaurant = r;
    start();
  }
  private OrderRequest req;
  @Override
  public void run() {
    while(true) {
      // Customer creates a request 
      // and adds it to the customerOrders then waits
      synchronized(restaurant.customerOrders) {
        req = new OrderRequest(this);
        System.out.println(Thread.currentThread().getName()
        + " placed an order request");
        restaurant.customerOrders.add(req);
      }
      synchronized(this) {
        try {
          System.out.println(Thread.currentThread.getName()
          + " is waiting for " + req);
          wait();
        } catch(InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      // WaitPerson notifies customer when the order is ready
      System.out.println(Thread.currentThread.getName() 
      + " received the " + req);
      // Time for customer to eat
      try {
        sleep(3000);
      } catch(InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

public class Restaurant {
  
  Queue incomingOrders = new LinkedList(); // incoming for chef
  Queue outgoingOrders = new LinkedList(); // outgoing for chef
  Queue customerOrders = new LinkedList();
  
  public static void main(String[] args)
   throws InterruptedException {
    Restaurant restaurant = new Restaurant();

    /* First recruit all WaitPersons and then recruit Chefs 
     */    
//    WaitPerson waitPerson = 
//    new WaitPerson("WP Chhotu", restaurant);
//    WaitPerson waitPerson2 = 
//    new WaitPerson("WP Gotu", restaurant);
//    WaitPerson waitPerson3 = 
//    new WaitPerson("WP Motu", restaurant);
//    WaitPerson waitPerson4 = 
//    new WaitPerson("WP Pinku", restaurant);
//    WaitPerson waitPerson5 = 
//    new WaitPerson("WP Lambu", restaurant);
//    WaitPerson waitPerson6 = 
//    new WaitPerson("WP Dhondu", restaurant);
//    
//    Chef chef = new Chef("Chef Singhania", restaurant);
//    Chef chef2 = new Chef("Chef Malya", restaurant);
//    Chef chef3 = new Chef("Chef Ambani", restaurant);
//    Chef chef4 = new Chef("Chef Birla", restaurant);
//    Chef chef5 = new Chef("Chef Tata", restaurant);
//    Chef chef6 = new Chef("Chef KrishnaMurti", restaurant);
    
    /* Recruit WaitPersons and Chefs simultaneiously */
    
    WaitPerson waitPerson = 
    new WaitPerson("WP Chhotu", restaurant);
    Chef chef = new Chef("Chef Singhania", restaurant);
    
    WaitPerson waitPerson2 = 
    new WaitPerson("WP Gotu", restaurant);
    Chef chef2 = new Chef("Chef Malya", restaurant);
    
    WaitPerson waitPerson3 = 
    new WaitPerson("WP Motu", restaurant);
    Chef chef3 = new Chef("Chef Ambani", restaurant);
    
    WaitPerson waitPerson4 = 
    new WaitPerson("WP Pinku", restaurant);
    Chef chef4 = new Chef("Chef Birla", restaurant);
    
    WaitPerson waitPerson5 = 
    new WaitPerson("WP Lambu", restaurant);
    Chef chef5 = new Chef("Chef Tata", restaurant);
    
    WaitPerson waitPerson6 = 
    new WaitPerson("WP Dhondu", restaurant);
    Chef chef6 = new Chef("Chef KrishnaMurti", restaurant);
  }
}
