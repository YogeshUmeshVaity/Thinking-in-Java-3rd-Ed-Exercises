/* 
 * Solve a single producer, single consumer problem using wait( ) 
 * and notify( ). The producer must not overflow the receiver's 
 * buffer, which can happen if the producer is faster than the 
 * consumer. If the consumer is faster than the producer, then it 
 * must not read the same data more than once. Do not assume 
 * anything about the relative speeds of the producer or consumer.
 */

/* Instead of using the traditional non-thread-safe methods, we'll
 * use the new interface BlockingQueue introduced in java 1.5, to 
 * solve this problem. It supports operations that wait for the 
 * queue to become non-empty when retrieving an element, and wait 
 * for space to become available in the queue when storing an 
 * element.
 */

import java.util.*;
import java.util.concurrent.*;

class Product {}
 
class Producer extends Thread {
  private BlockingQueue queue;
  public Producer(String name, BlockingQueue queue) {
    super(name);
    this.queue = queue;
    start();
  }
  @Override
  public void run() {
    while(true) {
      // Produce a product
      Product p = new Product();
      // Put product in queue
      // put() waits untill consumer doesn't need product
      try {
        queue.put(p);
      } catch(InterruptedException ie) {
        System.out.println(getName() + "'s wait inturrpted " + 
        "while waiting for consumer to consume");
        throw new RuntimeException(ie);
      }
    }
  }
}

class Consumer extends Thread {
  private BlockingQueue queue;
  public Consumer(String name, BlockingQueue queue) {
    super(name);
    this.queue = queue;
    start();
  }
  @Override
  public void run() {
    while(true) {
      // Retrieve the product
      // take() waits for product if it's not available currently
      try {
        Product p = ((Product)queue.take());
        p = null;
      } catch(InterruptedException ie) {
        System.out.println(getName() + "'s wait was" + 
        " interrupted while waiting for Producer to produce");
        throw new RuntimeException(ie);
      }
      // Consumer the product
      
    }
  }
}

public class ProducerConsumer {
  public void main(String[] args) {
    BlockingQueue queue = new LinkedList();
    Product p = new Product();
    Producer producer = new Producer("Producer", queue);
    Consumer consumer = new Consumer("Consumer", queue);
  }
}






















