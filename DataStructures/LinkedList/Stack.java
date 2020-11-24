/**
* Stack Interface
* @author Monica Chan
* @version 1.0
*/


interface Stack<E>{
  /**
  * Adds item to the top of the stack.
  * @param item to add into the stack.
  */
  void push(E item);

  /**
  * removes from the top of the stack.
  * @return the item that was removed.
  */
  E pop();

  /**
  * Checks what is at the head of the queue.
  * @return the head of the queue.
  */
  E peek();

  /**
  * checks if queue is empty.
  * @return true if it is, false if not.
  */
  boolean isEmpty();

}
