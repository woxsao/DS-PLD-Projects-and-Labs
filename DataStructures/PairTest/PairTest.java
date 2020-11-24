/**
* @author Monica Chan
* @version 1.0
* Generics Exercise0
*/

public class PairTest
{
  public static void main(String[] args)
  {
    String[] words = { "Type", "is", "a", "type", "in", "Python"};

  Pair<String> mm = ArrayAlg.minmax(words);
  System.out.println("min = " + mm.getFirst() );
  System.out.println("max = " + mm.getSecond() );
  }

}


class Pair<T extends Comparable<T>>{
  private T first, second;
  Pair(T a, T b){
    first = a;
    second = b;
  }

  T getFirst(){
    return first;
  }

  T getSecond(){
    return second;
  }

}


class ArrayAlg
{
  /**
  * Gets the minimum and maximum of an array of Strings. I used a for loop to iterate through the
  method to find the min and max using comparable, and then used the two values for min and max to create a new pair.
  Pair is a generic class that uses classes that extend Comparable; in this case we use this functionality for String.
  Within the minmax function because it is a generic method that accepts the generic array. Therefore, this is implementable for
  not only String, but also numbers as well.
  * @param arr an array of Strings
  * @return a pair with the min and max value, or null if a is a null or empty
  *
  */

  public static <T extends Comparable<T>> Pair<T> minmax(T[] arr){
    T min = arr[0];
    T max = arr[1];
    for(int i = 0; i< arr.length; i++){
      if(arr[i].compareTo(min)<0){
        min = arr[i];
      }
      else if(arr[i].compareTo(max) > 0){
        max = arr[i];
      }
    }
    Pair<T> gener = new Pair<>(min, max);

    return gener;

  }




}
