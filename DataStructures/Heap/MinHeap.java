/**
* MinHeap
* @author Monica Chan
* @version 1.0
*/

public class MinHeap<T extends Comparable<T>>{
  private int capacity;
  private int size;
  private Object[] heap;

  /**
  * This is a default constructor that sets capacity to ten, size to 0 and makes a new
  heap array to fit the capacity specified. It is implemented as having a size of 11
  since my code is written to handle indexing starting at 1 rather than 0.
  runtime: O(1)
  */
  public MinHeap(){
    capacity = 10;
    size = 0;
    heap = new Object[11];
  }

  /**
  * This is a constructor with a specified intial capacity.
  runtime: O(1)
  * @param initCapacity the initial starting capacity.
  */
  public MinHeap(int initCapacity){
    capacity = initCapacity;
    size = 0;
    heap = new Object[capacity+1];
  }

  /**
  * This function returns the size.
  runtime: O(1)
  * @return the size of the heap.
  */
  public int size(){
    return size;
  }

  /**
  * Determines whether the heap is empty
  runtime: O(1)
  * @return true if the heap is empty, false otherwise.
  */
  public boolean isEmpty(){
    if(size == 0)
      return true;
    return false;
  }

  /**
  * this function returns (but does not remove) the smallest element of the min heap.
  runtime: O(1)
  * @return the smallest element.
  */
  @SuppressWarnings("unchecked")
  public T peek(){
    if(isEmpty())
      return null;
    return (T) heap[1];
  }

  /**
  * This function removes the specified element and maintains the property of a
  min heap using heapifyDown (private method).
  runtime: O(log(n))
  * @param o the object to remove.
  * @return true if the item was removed, false otherwise.
  */
  @SuppressWarnings("unchecked")
  public boolean remove(T o){
    int index = find(o);
    T lowest = (T) heap[size];
    if(index == -1){
      return false;
    }
    else if(size == 1){
      heap[1] = null;
      return true;
    }
    heap[index] = lowest;
    heap[size] = null;
    heapifyDown(index);
    size--;
    return true;
  }

  /**
  * This function maintains the min heap characteristics when removing items from the heap.
  runtime: O(log(n))
  * @param index the index of the item that was just removed.
  */
  @SuppressWarnings("unchecked")
  private void heapifyDown(int index){
    T x = (T) heap[index];
    T leftChild = getLeft(index);
    T rightChild = getRight(index);
    while(leftChild != null && rightChild != null && (x.compareTo(leftChild) > 0 || x.compareTo(rightChild) > 0)){
      if(leftChild.compareTo(rightChild) > 0)
        heap[index] = rightChild;
      else
        heap[index] = leftChild;
      heap[2*index] = x;
      index = 2 * index;
      leftChild = getLeft(index);
      rightChild = getRight(index);
    }
  }

  /**
  * This function removes the first item of the min heap. I just implemented the remove function
  for this task.
  runtime: O(log(n))
  * @return the item that was at the top of the min heap.
  */
  @SuppressWarnings("unchecked")
  public T poll(){
    if(isEmpty())
      throw new NullPointerException("There is nothing in the heap!");
    T x = (T) heap[1];
    remove(x);
    return x;
  }

  /**
  *This function inserts a specified item into the minheap while maintaining the
  characteristics of the minheap.
  runtime: O(log(n))
  * @param element is the element we want to add into the minheap.
  */
  @SuppressWarnings("unchecked")
  public void insert(T element){
    if(size == 0){
      heap[1] = element;
      size++;
      return;
    }

    if(size+1 > capacity){
      heap = copy();
    }

    heap[size+1] = element;
    size++;
    heapifyUp();


  }

  /**
  * This function maintains the characteristic of a minheap when inserting items
  into the minheap.
  runtime: O(log(n))
  */
  @SuppressWarnings("unchecked")
  private void heapifyUp() {
    T x = (T) heap[size];

    T parent = (T) heap[size/2];
    int index = size;
    while(index > 1 && x.compareTo(parent) < 0){
      heap[index/2] = x;
      heap[index] = parent;
      index = index/2;
      parent = (T) heap[index/2];
    }
  }


  /**
  * This function returns the string representation of the minheap array.
  * runtime: O(n)
  * @return the minheap string.
  */
  public String toString(){
    String returnString = "";
    for(int i = 1; i < size; i++){
      returnString += heap[i] + ", ";
    }
    returnString += heap[size];
    return returnString;
  }

  //HELPER FUNCTIONS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  /**
  * This method copies the old heap into a new heap with double the size.
  * runtime: O(n)
  * @return the copied heap
  */
  private Object[] copy(){
    capacity *= 2;
    Object[] newHeap = new Object[capacity];
    for(int i = 0; i <= size(); i++)
      newHeap[i] = heap[i];
    return newHeap;
  }

  /**
  * This function returns the left child of a node in the min heap.
  * runtime: O(1)
  * @param index the index of the node.
  * @return the left child of that node.
  */
  @SuppressWarnings("unchecked")
  private T getLeft(int index){
    try{
      return (T) heap[2*index];
    }
    catch(IndexOutOfBoundsException e){
      return null;
    }
  }

  /**
  * This function returns the right child of a node in the min heap.
  * runtime: O(1)
  * @param index the index of the node.
  * @return the right child of that node.
  */
  @SuppressWarnings("unchecked")
  private T getRight(int index){
    try{
      return (T) heap[2*index + 1];
    }
    catch(IndexOutOfBoundsException e){
      return null;
    }
  }

  /**
  * This function finds the index of an item in the min heap array.
  * runtime: O(n)
  * @param o the value of the item.
  * @return the index of the item in the array.
  */
  @SuppressWarnings("unchecked")
  private int find(T o){
    if(size == 0)
      throw new NullPointerException("There is nothing in the list");
    for(int i = 1; i <= size; i++){
      if(heap[i].equals(o))
        return i;
    }
    return -1;
  }
}
