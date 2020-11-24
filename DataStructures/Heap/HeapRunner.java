public class HeapRunner{
  public static void main(String[] args){
    Integer x = 1;
    System.out.println(x.compareTo(2));
    MinHeap<Integer> a = new MinHeap<Integer>();
    a.insert(2);
    System.out.println(a);
    a.insert(3);
    System.out.println(a);
    a.insert(4);
    System.out.println(a);
    a.insert(1);
    System.out.println(a);

    a.insert(16);
    a.insert(5);
    a.insert(7);
    a.insert(6);
    a.insert(8);
    a.insert(12);
    a.insert(13);
    System.out.println(a);
    System.out.println("Size of a: " + a.size());
    a.remove(3);
    System.out.println("Removed 3 from a, a: " + a);
    System.out.println("Size of a: " + a.size());
    a.remove(12);
    System.out.println("Removed 12 from a, a: " + a);
    System.out.println("Size of a: " + a.size());
    a.remove(6);
    System.out.println("Removed 6 from a, a: " + a);
    System.out.println("Size of a: " + a.size());

    MinHeap<String> b = new MinHeap<String>();
    b.insert("h");
    b.insert("z");
    b.insert("a");
    b.insert("b");
    b.insert("j");

    System.out.println(b);
    System.out.println("Size of b: " + b.size());
    b.poll();
    System.out.println("Polled from b, b: " + b);
    System.out.println(b);
    System.out.println("Size of b: " + b.size());
    System.out.println("What is at the top of b?: " + b.peek());
    System.out.println("Is b empty?: " + b.isEmpty());

    MinHeap<Integer> c = new MinHeap<Integer>();
    System.out.println("Is c empty? : " + c.isEmpty());



  }
}
