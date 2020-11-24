/**
* Range Runner Class
* @author Monica Chan
* @version 1.0
*/

import java.lang.Iterable;
import java.util.Iterator;

public class RangeRunner
{

    public static void main( String[] args )
    {
        Range range = new Range(1, 10);

        Iterator<Integer> it = range.iterator();
        while( it.hasNext() )
        {
            System.out.println( it.next() );
        }


        for (Integer cur : range)
        {
            System.out.println(cur);
        }

    }


}
