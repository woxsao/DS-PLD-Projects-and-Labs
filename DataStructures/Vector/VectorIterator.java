/**
* VectorIterator
* @author Monica Chan
* @version 1.0
*/
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import java.util.Iterator;
import java.lang.Iterable;


public class VectorIterator<E> implements Iterator<E>
{
    //the Vector object for iteration.
    private Vector<E> vector;
    //number that represents what index we are at in the vector.
    private int index;

    /**
    * Constructor given a vector, initializes the two fields.
    * @param v gives the vector object that implements Iterable.
    * Runtime = O(1)
    */
    public VectorIterator(Vector<E> v)
    {
        vector = v;
        index = 0;
    }

    /**
    * Returns true if the iteration has more elements. (In other words, returns
    true if next() would return an element rather than throwing an exception.)
    * @return true if there are more elements in the vector, false otherwise
    * Runtime = O(1)
    */
    public boolean hasNext(){
      if(index < vector.size())
        return true;
      return false;
    }

    /**
    *Returns the next element in the iteration. Required because we implement the Iterator interface.
    Throws NoSuchElementException if the iteration has no more elements.
    @return Integer that represents the next integer in the range.
    * Runtime = O(1)
    */
    @SuppressWarnings("unchecked")
    public E next(){
      if(index >= vector.size()){
        throw new NoSuchElementException("Exceeds Range!");
      }
      index++;
      return (E) vector.get(index-1);
    }


}
