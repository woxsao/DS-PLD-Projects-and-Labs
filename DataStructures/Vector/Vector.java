/**
* Vector Assignment
* @author Monica Chan
* @version 1.0

*/
import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;



public class Vector<E> implements Iterable<E>{
  //Storage array
  private Object[] data;
  //How many items the vector can currently hold
  private int capacity;
  //how many items are in the vector
  private int size;

  /**
  *Initializes a vector of type e with the default capacity being 10.
  * Runtime =  O(1)
  */
  public <E> Vector(){
    data = new Object[10];
    capacity = 10;
    size = 0;
  }
  /**
  *Initializes a vector of type e with the input being the capacity.
  * @param initCapacity is the desired starting capacity for the vector.
  * Runtime =  O(1)
  */
  public <E> Vector(int initCapacity){
    data = new Object[initCapacity];
    capacity = initCapacity;
    size = 0;
  }

  /**
  *Initializes a vector of type e to copy another constructor also of type e.
  * @param other is the vector that we want to copy.
  * Runtime =  O(n)
  */
  public <E> Vector(Vector<E> other){
    data = new Object[other.capacity];
    for(int i = 0; i < other.capacity; i++){
      data[i] = other.get(i);
    }
    size = other.size;
    capacity = other.capacity;
  }

  /**
  * Add an object to the end of the vector array.
  * @param toAdd is the object of type E we want to add into the vector.
  * Runtime =  O(1)
  */
  public void add(E toAdd){
    if(data[capacity-1] != null)
      this.increaseCapacity();
    data[size] = toAdd;
    size++;
  }

  /**
  * Adds an object toAdd into the desired index, and shift the rest of the elements down.
  Precondition is that index has to be less than the size.
  * @param index is the index we want to add the object to.
  * @param toAdd is the object we want to add at index.
  * Runtime =  O(n)
  */
@SuppressWarnings("unchecked")
 public void add(int index, E toAdd){
   if(index > size)
    throw new IndexOutOfBoundsException("index can not be greater than size");
   if(data[index] == null){
    data[index] = toAdd;
    size++;
    return;
  }
   if(data[capacity-1] != null)
      this.increaseCapacity();
   E x = (E) toAdd;

   for(int j = index; j < data.length; j++){
     E temp = x;
     x = (E) data[j];
     data[j] = temp;
   }
   size++;
 }

 /**
 * This function doubles the capacity of the vector array.
 * Runtime =  O(n)
 */
  private void increaseCapacity(){
    Object[] temp = new Object[capacity*2];
    for(int i = 0; i < data.length; i++){
      temp[i] = data[i];
    }
    data = new Object[temp.length];
    for(int m = 0; m< temp.length; m++){
      data[m] = temp[m];
    }
    capacity *= 2;
  }

  /**
  * This function removes an element from the vector at a given index, shifts
  all the elements after it to the left, and returns the element formerly at
  that index. I first check if the element is last, and if it is remove and
  return the last element, since no shifting is necessary. Then for the shifting,
  I simply set the element to the value of the one to its right.
  * @param index is the integer index to remove
  * @return the element at that index.
  * Runtime =  O(n)
  */
  @SuppressWarnings("unchecked")
  public E remove(int index){
    E returnValue = (E) data[index];
    if(index == size-1){
      data[index] = null;
      size--;
      return returnValue;
    }

    for(int i = index+1; i < data.length; i++){
      data[i-1] = data[i];
    }
    data[data.length-1] = null;
    size--;
    return returnValue;
  }

  /**
  *This function removes an element with a given value, then returns true if it
  was removed, or false if no occurrences of such element were found. I use the
  same shifting method as I did in the previous method.
  * @param obj is the value to remove from the vector.
  * @return true if the element was removed, false otherwise
  * Runtime =  O(n)
  */
  public boolean remove(E obj){
    for(int i = 0; i < data.length; i++){
      if(data[i].equals(obj)){
        for(int j = i+1; j < data.length; j++){
          data[j-1] = data[j];
        }
        data[data.length-1] = null;
        size--;
        return true;
      }
    }
    size--;
    return false;

  }

  /**
  *This function sets a given value to an index of the vector and returns the value
  of the element formerly at that index. First, I make sure that the index is valid
  for the size of the vector. Then I set the index to that value.
  * @param index is the index of the vector to add the value to.
  * @param obj is the value to set
  * @return the element formerly at that index.
  * Runtime =  O(1)
  */
  @SuppressWarnings("unchecked")
  public E set(int index, E obj){
    if(index >= this.capacity)
      throw new NoSuchElementException("Exceeds capacity of vector!");
    E returnValue = (E) data[index];
    data[index] = obj;
    return returnValue;
  }

  /**
  *This function gets returns a value from a certain index. I first check that the index
  does not exceed the capacity, if it does I throw a NoSuchElementException.
  * @param index is the index of the item we want to return
  * @return the value at that index.
  * Runtime = O(1)
  */
  @SuppressWarnings("unchecked")
  public E get(int index){
    if(index > this.capacity)
      throw new NoSuchElementException("Exceeds capacity of vector!");
    E ob = (E) data[index];
    return ob;
  }

  /**
  * This function returns the size of the vector.
  * @return the size.
  * Runtime = O(1)
  */
  public int size(){
    return size;
  }

  /**
  *This function clears the entire vector and sets everything to null.
  * Runtime = O(n)
  */
  public void clear(){
    for(int i = 0; i < data.length; i++){
      data[i] = null;
    }
  }

  /**
  *This function checks whether the vector is empty and returns true if it is, false
  otherwise.
  * @return true if vector is empty, false if it isn't.
  * Runtime = O(n)
  */
  public boolean isEmpty(){
    for(int i = 0; i < data.length; i++){
      if(!(data[i] == null))
        return false;
    }
    return true;
  }

  /**
  * This function checks whether a vector holds a value or not.
  * @param obj is the value to find
  * @return true if it is found in the vector, false otherwise
  * Runtime = O(n)
  */
  @SuppressWarnings("unchecked")
  public boolean contains(E obj){
    for(int i = 0; i < data.length; i++){
      if(((E)data[i]).equals(obj))
        return true;
    }
    return false;
  }

  /**
  * This function finds and returns the index of a value, if it does not exist in the
  function it returns -1.
  * @param obj is the value to find the index of.
  * @return integer index or -1 if the value was not found.
  * Runtime = O(n)
  */
  @SuppressWarnings("unchecked")
  public int indexOf(E obj){
    for(int i = 0; i < data.length; i++){
      if(((E)data[i]).equals(obj))
        return i;
    }
    return -1;
  }

  /**
  * String representation of the vector, automatically called when main calls
  System.out.println(vector)
  * @return string representation of the vector.
  * Runtime = O(n)
  */
  public String toString(){
    String a = "";
    for(int i = 0; i < data.length-1; i++){
      a+= data[i] + ", ";
    }
    a += data[data.length-1];
    return a;
  }

  /**
  * Creates Iterator for the vector.
  * @return iterator of type E.
  * Runtime = O(1)
  */
  @SuppressWarnings("unchecked")
  public Iterator<E> iterator(){
    return new VectorIterator(this);
  }

}
