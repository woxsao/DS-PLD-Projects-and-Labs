/**
* Queue Interface
* @author Monica Chan
* @version 1.0
*/
interface Queue<E>{
  /**
  * removes from the front of the queue.
  * @return the item that was removed.
  */
  E poll();

  /**
  * Adds item to the end of the queue.
  * @param item to add into the queue.
  */
  void offer(E item);

  /**
  * checks if queue is empty.
  * @return true if it is, false if not.
  */
  boolean isEmpty();

  /**
  * Checks what is at the head of the queue.
  * @return the head of the queue. 
  */
  E peek();
}
