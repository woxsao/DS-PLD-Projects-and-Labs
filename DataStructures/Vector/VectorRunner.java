/**
* Vector class Runner
* @author Monica Chan
* @version 1.0
*/

public class VectorRunner{
  public static void main(String[] args){

    Vector<String> b = new Vector<>(2);
    System.out.println("TESTS FOR ADD AND REMOVE: ");
    System.out.println(b);
    System.out.println("size of b = " + b.size());
    b.add("hi");
    System.out.println(b);
    System.out.println("size of b = " + b.size());
    b.add("how are you");
    System.out.println(b);
    System.out.println("size of b = " + b.size());
    b.add("good thanks");
    System.out.println(b);
    System.out.println("size of b = " + b.size());
    b.add("bye!");
    System.out.println(b);
    System.out.println("size of b = " + b.size());
    System.out.println();
    String bRemove = b.remove(3);
    System.out.println("Removed the last element: " + bRemove);
    System.out.println(b);
    System.out.println("size of b = " + b.size());
    System.out.println();
    System.out.println("Removed the first element: " + b.remove(0));
    System.out.println(b);
    System.out.println("size of b = " + b.size());
    System.out.println();
    System.out.println("Removed the second element: " + b.remove(1));
    System.out.println(b);
    System.out.println("size of b = " + b.size());
    System.out.println();
    b.add("fine");
    System.out.println("added 'fine'");
    b.add("and you?");
    System.out.println("added 'and you?'");
    b.add("thanks for asking!");
    System.out.println("added 'thanks for asking!'");
    b.add(3, "well thanks!");
    System.out.println("added 'well thanks!' to index 3");
    System.out.println(b);
    System.out.println("size of b = " + b.size());
    System.out.println();
    b.add(0, "Nice to see you again!");
    System.out.println("added 'Nice to see you again!' to the front of the vector");
    System.out.println(b);
    System.out.println();
    b.add(6, "bye!");
    System.out.println("added 'bye!' to index 6");
    System.out.println(b);
    System.out.println("size of b = " + b.size());
    System.out.println();
    b.remove("bye!");
    System.out.println("Removed 'bye!'");
    System.out.println(b);
    System.out.println("size of b = " + b.size());
    System.out.println();
    b.remove("Nice to see you again!");
    System.out.println("removed 'Nice to see you again!'");
    System.out.println(b);
    System.out.println("size of b = " + b.size());

    System.out.println();



    System.out.println("TESTS FOR SET: ");
    System.out.println("Set first element to 'ok'");
    b.set(0, "ok");
    System.out.println(b);
    System.out.println("Set last element to 'fine'");
    b.set(3, "fine");
    System.out.println(b);
    System.out.println("Set second element to 'good'");
    b.set(1, "good");
    System.out.println(b);
    System.out.println();

    System.out.println("TESTS FOR GET:");
    Vector<Integer> c = new Vector<>(3);
    c.add(1);
    c.add(2);
    c.add(3);
    System.out.println(c);
    System.out.println("At index 0: " + c.get(0));
    System.out.println("At index 1: " + c.get(1));
    System.out.println("At index 2: " + c.get(2));
    System.out.println();

    System.out.println("TESTS FOR COPY CONSTRUCTOR AND ITERATOR: ");
    System.out.println("B : " + b);
    Vector<String> d = new Vector<>(b);
    System.out.println("D: " + d);
    System.out.println();
    System.out.println("Foreach loop of d: ");
    for(String i : d){
      System.out.println(i);
    }
    System.out.println();

    System.out.println("TESTS FOR CLEAR: ");
    b.clear();
    System.out.println(b);

    System.out.println("TESTS FOR EMPTY:");
    System.out.println(b.isEmpty());
    System.out.println();

    System.out.println("TESTS FOR CONTAINS:");
    System.out.println("Does Vector c contain the number 4? " + c.contains(4));
    System.out.println("Does vector c contain the number 1? " + c.contains(1));
    System.out.println();

    System.out.println("TESTS OF INDEXOF:");
    System.out.println("Index of 1: " + c.indexOf(1));
    System.out.println("Index of 4: " + c.indexOf(4));

    Vector<Integer> f = new Vector<>(2);
    f.add(3);
    f.add(2);
    f.add(1);
  }
}
