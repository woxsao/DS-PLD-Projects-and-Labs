/**
* Range Iterator Class
* @author Monica Chan
* @version 1.0
*/

import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import java.util.Iterator;
import java.lang.Iterable;


public class RangeIterator implements Iterator<Integer>
{
    //the Range object for iteration.
    private Range range;
    //number that represents where we are in the range. 
    private int index;

    /**
    * Constructor given a range, initializes the two fields.
    * @param range gives the Range object that implements Iterable.
    */
    public RangeIterator( Range r )
    {
        range = r;
        index = range.getStart();
    }

    /**
    * Returns true if the iteration has more elements. (In other words, returns
    true if next() would return an element rather than throwing an exception.)
    * @return true if there are more elements in the range, end inclusive, false otherwise
    */
    public boolean hasNext(){
      if(index <= range.getEnd())
        return true;
      return false;
    }

    /**
    *Returns the next element in the iteration. Required because we implement the Iterator interface.
    Throws NoSuchElementException if the iteration has no more elements.
    @return Integer that represents the next integer in the range.
    */

    public Integer next(){
      if(index > range.getEnd()){
        throw new NoSuchElementException("Exceeds Range!");
      }
      index++;
      return index -1;
    }



    //ignore for now
    /*
    public void remove() {
        throw new UnsupportedOperationException();
    }
    */
}
