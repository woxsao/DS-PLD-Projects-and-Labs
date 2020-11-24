/**
* LinkedListIterator
* @author Monica Chan
* @version 1.0
*/

import java.util.Iterator;
import java.lang.Iterable;


public class LinkedListIterator<E> implements Iterator<E>{
  //the LinkedList object for iteration.
  private LinkedList<E> linkedList;
  //number that represents what index we are at in the linkedlist.
  private int index;

  /**
  * Constructor given a linkedlist, initializes the two fields.
  * @param l gives the linkedlist object that implements Iterable.
  * Ideal Runtime = O(1)
  */
  public LinkedListIterator(LinkedList<E> l){
    linkedList = l;
    index = 0;
  }

  /**
  * Returns true if the iteration has more elements. (In other words, returns
  true if next() would return an element rather than throwing an exception.)
  * @return true if there are more elements in the linkedlist, false otherwise
  * Ideal Runtime = O(n)
  */
  public boolean hasNext(){
    if(index < linkedList.size())
      return true;
    return false;
  }

  /**
  * Returns the next element in the iteration. Required because we implement the Iterator interface.
  Throws NoSuchElementException if the iteration has no more elements.
  @return item that represents the value of the next node in the linkedlist.
  * Runtime = O(1)
  */
  public E next(){
    if(index > linkedList.size())
      throw new IndexOutOfBoundsException("exceeds range!");
    index++;
    return linkedList.get(index-1);
  }
}
