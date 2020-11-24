/**
* LinkedList
* @author Monica Chan
* @version 1.0
*/

import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Queue<E>, Stack<E>, Iterable<E>{
  private ListNode<E> head, tail;

  /**
  * Default constructor, sets head and tail to null.
  * Runtime = O(1)
  */
  public LinkedList(){
    head = null;
    tail = null;
  }

  /**
  * Constructor with a head node, sets tail to null.
  * @param h is the head list node.
  * Runtime = O(1)
  */
  public LinkedList(ListNode<E> h){
    head = h;
    if(h.getNext() == null)
      tail = h;
    else{
      tail = h.getNext();
    }
  }

  /**
  * Copy constructor that copies another linked list.
  * @param other is the other linked list to be copied.
  * Runtime = O(n)
  */
  public LinkedList(LinkedList<E> other){
    for(int i = 0; i < other.size(); i++){
      this.add(other.get(i));
    }
  }

  /**
  * Returns the tail of the linked list. I wrote this function kind of for
  debugging, but just a cool functionality to have.
  * @return the tail of the list.
  * Ideal Runtime = O(1)
  */
  public E getTail(){
    if(tail == null)
      return null;
    return tail.getValue();
  }

  /**
  * Function to add to the tail end of the linked list.
  * @param o is the value to add.
  * Average runtime = O(1)
  */
  public void add(E o){
    ListNode<E> x = new ListNode<>(o);
    //if list is empty
    if(head == null){
      head = x;
      tail = x;
    }
    else{
      ListNode<E> temp = tail;
      temp.setNext(x);
      tail = x;
    }
  }

  /**
  * This function is from the Stack interface, and it adds an item to the head
  end of the LinkedList.
  * @param item is the item to add to the head.
  * Ideal Runtime = O(1)
  */
  public void push(E item){
    ListNode<E> s = new ListNode<>(item);
    // if list is empty
    if(head == null){
      head = s;
      tail = s;
    }
    else{
      s.setNext(head);
      head = s;
    }
  }

  /**
  * This function removes from the stack and throws a NoSuchElementException if
  the list is empty. (according to the actual javadoc of this function this is what
  makes it differ from poll)
  * @return the item that is removed
  * Runtime = O(1)
  */
  public E pop(){
    // if list is empty
    if(head == null)
      throw new NoSuchElementException("there is nothing in this list!");
    // if list has one item
    if(head == tail)
      this.clear();

    ListNode<E> newHead = head.getNext();
    ListNode<E> temp = head;
    head = newHead;
    return temp.getValue();
  }

  /**
  * This function looks at the head of the stack/queue without removing it. returns
  null if the list is empty.
  * @return element at the top.
  * Ideal Runtime = O(1)
  */
  public E peek(){
    // if list is empty
    if(head == null)
      return null;
    return head.getValue();
  }

  /**
  * Removes head of the queue, and returns its value. Returns null if list is empty.
  * @return head element.
  * Ideal Runtime = O(1)
  */
  public E poll(){
    ListNode<E> newHead = head.getNext();
    ListNode<E> temp = head;
    // if list is empty
    if(head == null)
      return null;
    // if list has one item
    if(head == tail){
      this.clear();
      return temp.getValue();
    }
    head = newHead;
    return temp.getValue();
  }

  /**
  * Checks if a list is empty and returns true or false accordingly.
  If the head is empty then by default everything else is empty as well.
  * @return true or false depending if the list is empty.
  * Ideal Runtime = O(1)
  */
  public boolean isEmpty(){
    // if list is empty
    if(head == null){
      return true;
    }
    return false;
  }

  /**
  * Adds item to the queue.
  * @param item is the thing to add to the queue.
  * Runtime = O(1)
  */
  public void offer(E item){
    this.add(item);
  }

  /**
  * Removes the item specified in the argument from the list. If it is not there
  return false. If it is, return true.
  * @param o is the value of the node to remove from the list.
  * @return true if the item was removed, false if it is not there.
  * Average runtime = O(n) Best case O(1)
  */
  public boolean remove(E o){
    ListNode<E> current = head;
    ListNode<E> previous = null;
    // if list is empty
    if(head == null)
      return false;
    // if list has one item
    else if(head == tail){
      if(head.getValue().equals(o))
        head = null;
        tail = null;
        return true;
    }
    if(current.getValue().equals(o)){
      this.head = this.head.getNext();
      return true;
    }

    while(current != null && !current.getValue().equals(o)){
      previous = current;
      current = current.getNext();
    }

    //meaning if the item was not found
    if(current == null)
      return false;
    if(current.getNext() == null)
      this.tail = previous;
    previous.setNext(current.getNext());
    return true;
  }

  /**
  * Removes item at a specified index. If the index exceeds the size of the list,
  throw new IndexOutOfBoundsException.
  * @param index is the index of the node to remove.
  * @return the item at that index that was removed.
  * Average runtime = O(n) Best case O(1)
  */
  public E remove(int index){
    if(index >= this.size())
      throw new IndexOutOfBoundsException("exceeds length of list!");
    ListNode<E> returnNode;
    if(index == 0){
      returnNode = head;
      head = head.getNext();
      return returnNode.getValue();
    }
    int members = this.size();
    if(index > members){
      throw new IndexOutOfBoundsException("Index exceeds length of the list");
    }
    ListNode<E> previous = null;
    ListNode<E> current = head;
    for(int i = 0; i < index; i++){
      previous = current;
      current = current.getNext();
    }

    if(current.getNext() == null){
        this.tail = previous;
    }
    previous.setNext(current.getNext());
    return current.getValue();

  }

  /**
  * Removes the item at the head. Returns null if the list is empty.
  * @return the head.
  * Ideal Runtime = O(1)
  */
  public E removeFirst(){
    ListNode<E> temp = head;
    // if list is empty
    if(head == null)
      return null;
    // if list has one item
    if(head == tail){
      tail = null;
      head = null;
      return temp.getValue();
    }
    head = head.getNext();
    return temp.getValue();
  }

  /**
  * Removes and returns item at the tail. Throws a null pointer exception if the list
  is empty.
  * @return the tail.
  * Average runtime = O(n) Best case O(1)
  */
  public E removeLast(){
    ListNode<E> current = head;
    ListNode<E> previous = null;
    // if list is empty
    if(head == null)
      throw new NullPointerException("the list is empty");
    //if list has one item
    if(head == tail){
      head = null;
      tail = null;
      return current.getValue();
    }
    for(int i = 0; i < this.size()-1; i++){
      previous = current;
      current = current.getNext();
    }
    previous.setNext(null);
    tail = previous;
    return current.getValue();
  }

  /**
  * returns a string representation of the linkedlist.
  * @return the string representation.
  * Average runtime = O(n) Best case O(1)
  */
  public String toString(){
    // if list is empty
    if (head == null) {
      return "";
    }
    String resultString = "";
    ListNode curr = head;
    while (curr.getNext() != null) {
      resultString += curr.getValue() + ", ";
      curr = curr.getNext();
    }
    resultString += tail.getValue();
    return resultString;
  }

  /**
  * Adds item to the head of the list. Basically does the same thing as push()
  so it just references push().
  * @param item to add to the head.
  * Ideal Runtime = O(1)
  */
  public void addFirst(E item){
    push(item);
  }

  /**
  * Adds item to the tail of the list. Does the same thing as add, so just references
  add().
  * @param item item to add to the tail end.
  * Average runtime = O(1)
  */
  public void addLast(E item){
    add(item);
  }

  /**
  * Checks if an item is in the linked list without removing it.
  * @param o item to find.
  * @return true if the item was found, false otherwise.
  * Average runtime = O(n) Best case O(1)
  */
  public boolean contains(E o){
    ListNode<E> temp = head;
    // if list is empty
    if(head == null)
      return false;
    // if list has one item
    if(head == tail){
      if(head.getValue().equals(o))
        return true;
      return false;
    }
    for(int i = 0; i < this.size(); i++){
      if(temp.getValue().equals(o))
        return true;
      temp = temp.getNext();
    }
    return false;
  }

  /**
  * Returns the size of the linked list.
  * @return the size of the linked list.
  * Average runtime = O(n) Best case O(1)
  */
  public int size(){
    // if list is empty
    if(head == null)
      return 0;
    if(head == tail)
    // if list has one item
      return 1;
    ListNode<E> temp = head;
    int count = 0;
    while(temp != null){
      count++;
      temp = temp.getNext();
    }
    return count;
  }

  /**
  * clears everything in the list. This can be accomplished by just
  setting the head and tail to null.
  * Ideal Runtime = O(1)
  */
  public void clear(){
    head = null;
    tail = null;
  }

  /**
  * retrieves item from an index of the linked list without removing it. If
  index exceeds the size of the list, throws IndexOutOfBoundsException, if it is
  empty throws NullPointerException
  * @param index is the index of the item to retrieve.
  * @return the value at that index.
  * Average runtime = O(n) Best case O(1)
  */
  public E get(int index){
    // if list is empty
    if(head == null)
      throw new NullPointerException("Nothing in the list!");
    if(index >= this.size())
      throw new IndexOutOfBoundsException("index exceeds length of list");
    ListNode<E> temp = head;
    int counter = 0;
    while(counter < index){
      temp = temp.getNext();
      counter++;
    }
    return temp.getValue();
  }

  /**
  * sets the value at a certain index to a given value. If the index exceeds the Size
  and the index is not 0, throws an IndexOutOfBoundsException.
  * @param index is the index to set.
  * @param o is the value to set that index to.
  * @return the value previously at that index.
  * Runtime = O(n)
  */
  public E set(int index, E o){
    ListNode<E> x = new ListNode<>(o);
    E tempValue;
    if(index >= this.size())
      throw new IndexOutOfBoundsException("exceeds length of list!");
    if(head == tail){
      tempValue = head.getValue();
      head = x;
      tail = x;
      return tempValue;
    }
    ListNode<E> temp = head;
    for(int i = 0; i < index; i++){
      temp = temp.getNext();
    }
    if(temp.getNext() == null)
      tail = temp;
    tempValue = temp.getValue();
    temp.setValue(o);
    return tempValue;
  }

  /**
  * adds value at a specified index. If the index exceeds the size of the list,
  then it throws an IndexOutOfBoundsException. But if the index is equal to the size,
  it will just append it normally.
  * @param index is the index that we want to add at.
  * @param o is the value of the item we want to add.
  * Runtime = O(n)
  */
  public void add(int index, E o){
    ListNode<E> temp = head;
    ListNode<E> x = new ListNode<>(o);
    if(index > this.size())
      throw new IndexOutOfBoundsException("index exceeds list constraints");
    else if(head == null){
      head = x;
      tail = x;
    }
    else if(head == tail){
      tail = x;
      temp.setNext(x);
    }
    else if(index == this.size())
      this.add(o);
    else if(index == 0)
      push(o);
    else{
      for(int i = 0; i < index-1; i++){
        temp = temp.getNext();
      }
      ListNode<E> next = temp.getNext();
      temp.setNext(x);
      x.setNext(next);
    }
  }

  /**
  * returns the index of the first instance of an object. If the object was not
  found, it will return -1.
  * @param o is the object to find.
  * @return the index of the first instance of that object.
  * Runtime = O(n)
  */
  public int indexOf(E o){
    ListNode<E> temp = head;
    for(int i = 0; i < this.size(); i++){
      if(o.equals(temp.getValue()))
        return i;
      temp = temp.getNext();
    }
    return -1;
  }

  /**
  * Creates a new LinkedListIterator
  * @return the Iterator.
  * Ideal Runtime = O(1)
  */
  public Iterator<E> iterator(){
    return new LinkedListIterator<E>(this);
  }

}
