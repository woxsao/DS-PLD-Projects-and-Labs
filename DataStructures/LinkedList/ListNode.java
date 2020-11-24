/**
* ListNode
* @author Monica Chan
* @version 1.0
*/

public class ListNode<E>{
  private E value;
  private ListNode<E> next;

  /**
  * Constructor to make a new list node given an item and the next list node.
  * @param item is the value of this node.
  * @param n is the value of the next node.
  * Ideal Runtime = O(1)
  */
  public ListNode(E item, ListNode<E> n){
    value = item;
    next = n;
  }

  /**
  * Constructor to make a new list node just given a value. Makes the next
  list node null.
  * @param item is the value of this node.
  * Ideal Runtime = O(1)
  */
  public ListNode(E item){
    value = item;
    next = null;
  }

  /**
  * accessor to get the next list node.
  * @return the next list node.
  * Ideal Runtime = O(1)
  */
  public ListNode<E> getNext(){
    return next;
  }

  /**
  * accessor to get the value of the list node.
  * @return the value of the node.
  * Ideal Runtime = O(1)
  */
  public E getValue(){
    return value;
  }

  /**
  * Modifier to modify the next list node.
  * @param node is the node to become the new next node.
  * Ideal Runtime = O(1)
  */
  public void setNext(ListNode<E> node){
    next = node;

  }

  /**
  * Modifier to set the value of the node.
  * @param item is the new value of the node.
  * Ideal Runtime = O(1)
  */
  public void setValue(E item){
    value = item;
  }

  /**
  * toString function to print a visual representation of the node. Prints null
  if there is nothing in the list.
  * @return the string representation of the node.
  * Ideal Runtime = O(1)
  */
  public String toString(){
    String returnString = value.toString() + " and the next value is: ";
    if(next == null)
      returnString += "null";
    else{
      returnString += next.getValue().toString();
    }
    return returnString;
  }


}
