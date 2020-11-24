/**
* Range Class
* @author Monica Chan
* @version 1.0
*/


import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;


public class Range implements Iterable<Integer> {
    //the start value of the range
    private int start;
    //the end value of the range
    private int end;

    /**
    * Given a starting value and ending value, initializes the Range Object
    * @param s is the starting value
    * @param e is the ending value
    */
    public Range(int s, int e) {
        start = s;
        end = e;
    }

    /**
    * This function returns the first integer in the range.
    * @return the first element in the range.
    */
    public int getStart() {
    	return start;
    }

    /**
    * This function returns the last integer in the range.
    * @return the last element in the range.
    */
    public int getEnd() {
    	return end;
    }


    /**
    * returns the Range iterator
    @return an object that implements the iterator class, required because we
    extend the Iterable interface.
    */
    public Iterator<Integer> iterator(){
      return new RangeIterator(this);
    }
}
