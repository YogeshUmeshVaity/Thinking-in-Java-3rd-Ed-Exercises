/* 
 * Solve a single producer, single consumer problem using wait() 
 * and notify( ). The producer must not overflow the receiver's 
 * buffer, which can happen if the producer is faster than the 
 * consumer. If the consumer is faster than the producer, then 
 * it must not read the same data more than once. Do not assume 
 * anything about the relative speeds of the producer or 
 * consumer.
 */

class Product {
  private static int count = 0;
  private int productID = count++;
  public Product() {
    if(productID > 12) {
      System.out.println("System out of goods, closing...");
      System.exit(0);
    }
  }
  @Override
  public String toString() {
    return "product # : " + productID;
  }
}

class Producer extends Thread {
  private Product[] product;
  public Producer(String name, Product[] p) {
    super(name);
    product = p;
    start();
  }
  @Override
  public void run() {
    while(true) {
      synchronized(product) {
        if(product[0] == null) {
          product[0] = new Product();
          System.out.println(getName() + " produced " + product[0]);
          product.notify();
        }
        else {
          try {
            product.wait();
          } catch(InterruptedException ie) {
            System.out.println(getName() + "'s wait interrupted " 
            + "while waiting for consumer to consume");
          }
        }
      }
    }
  }
}

class Consumer extends Thread {
  private Product[] product;
  public Consumer(String name, Product[] p) {
    super(name);
    product = p;
    start();
  }
  @Override
  public void run() {
    while(true) {
      synchronized(product) {
        if(product[0] != null) {
          // store the productID
          String productNumber = product[0].toString();
          product[0] = null;
          System.out.println(getName() + " consumed " + 
          productNumber);
          product.notify();
        } 
        else {
          try {
            product.wait();
          } catch(InterruptedException ie) {
            System.out.println(getName() + "'s wait was " + 
            "interrupted while waiting for Producer");
          }
        }
      }
    }
  }
}

public class WaitNotifyMethod {
  public static void main(String[] args) {
    Product product1 = null;
    Product[] product = { product1 };
    Producer producer = new Producer("Producer", product);
    Consumer consumer = new Consumer("Consumer", product);
  }
}










