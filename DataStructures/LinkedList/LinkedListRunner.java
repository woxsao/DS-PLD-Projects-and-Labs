public class LinkedListRunner{
  public static void main(String[] args){
    ListNode<String> a = new ListNode<>("apple");
    ListNode<String> blue = new ListNode<>("blueberry", a);
    LinkedList<String> fruit = new LinkedList<>(blue);
    System.out.println("Fruit stack: " + fruit);
    fruit.push("banana");
    fruit.push("orange");
    System.out.println("pushed 'banana' then 'orange': " + fruit);
    fruit.push("peach");
    System.out.println("pushed peach, fruit: " + fruit);
    fruit.push("pineapple");
    System.out.println("pushed pineapple, fruit: " + fruit);
    fruit.pop();
    System.out.println("Popped from fruit linkedlist: " + fruit);
    fruit.push("grape");
    System.out.println("Pushed grape: " + fruit);
    fruit.pop();
    System.out.println("Popped, fruit: " + fruit);
    System.out.println("Peek : " + fruit.peek());
    System.out.println("Fruit: " + fruit);
    System.out.println();

    LinkedList<Integer> b = new LinkedList<>();
    System.out.println("B: " + b);
    Integer b1 = Integer.valueOf(3);
    System.out.println("Removed 3 from Linked List B? : " + b.remove(b1));
    System.out.println("Is B empty? : " + b.isEmpty());
    System.out.println();

    ListNode<String> corn = new ListNode<>("corn");
    LinkedList<String> vegetables = new LinkedList<String>(corn);
    System.out.println("Stack vegetables: " + vegetables);
    System.out.println("Vege head: " + vegetables.peek());
    System.out.println("Vege tail: " + vegetables.getTail());
    vegetables.offer("broccoli");
    vegetables.offer("carrot");
    System.out.println("Offered broccoli then offered carrot: " + vegetables);
    vegetables.poll();
    System.out.println("Polled from vegetables: " + vegetables);
    vegetables.poll();
    System.out.println("Polled again from vegetables: " + vegetables);
    System.out.println("What is at the head of vegetables? : " + vegetables.peek());
    System.out.println("Does vegetables contain cauliflower? : " + vegetables.contains("cauliflower"));
    vegetables.offer("beans");
    vegetables.offer("bok choy");
    vegetables.offer("tomato");
    System.out.println("Offered some veggies, vegetables: " + vegetables);
    System.out.println("Foreach loop: ");
    for(String i: vegetables){
      System.out.println(i);
    }


    System.out.println("Does vegetables contain beans? : " + vegetables.contains("beans"));
    System.out.println("What is at the end of vegetables? : " + vegetables.get(1));
    System.out.println("Size of vegetables: " + vegetables.size());
    vegetables.removeLast();
    System.out.println("Removed the last element of vegetables, vegetables: " + vegetables);
    vegetables.removeLast();
    System.out.println("Removed the last element of vegetables, vegetables: " + vegetables);

    System.out.println();

    Integer five = Integer.valueOf(5);
    ListNode<Integer> young = new ListNode<>(five);
    LinkedList<Integer> age = new LinkedList<>(young);
    age.add(Integer.valueOf(27));
    age.add(Integer.valueOf(100));
    System.out.println("Age LinkedList: " + age);
    age.remove(0);
    System.out.println("Removed first item, Age LinkedList is now: " + age);
    System.out.println();

    LinkedList<String> animals = new LinkedList<>();
    animals.addFirst("zebra");
    System.out.println("Animals: " + animals);
    animals.removeFirst();
    System.out.println("Removed the first element of the list, Animals: " + animals);
    animals.add("hippo");
    animals.add("tortoise");
    animals.add("seagull");
    System.out.println("animals: " + animals);
    animals.removeFirst();
    System.out.println("removed the first element of the list, Animals: " + animals);
    animals.addFirst("pelican");
    System.out.println("added pelican to the front of the list, Animals: " + animals);
    animals.addLast("pig");
    System.out.println("added pig to the end of the list, Animals: " + animals);
    System.out.println("Does Animals contain a tortoise? : " + animals.contains("tortoise"));
    System.out.println("How many elements does Animal have? : " + animals.size());
    animals.clear();
    System.out.println("Cleared Animals. Animals now contains: " + animals);
    System.out.println("The size of animals is now: " + animals.size());
    System.out.println();

    LinkedList<String> newFruit = new LinkedList<>(fruit);
    System.out.println("new fruit list: " + newFruit);
    System.out.println("head of newFruit: " + newFruit.peek());
    System.out.println("tail of newFruit: " + newFruit.getTail());
    System.out.println("What is the second element of newFruit? : " + newFruit.get(1));
    newFruit.remove(0);
    newFruit.remove(0);
    System.out.println("removed two items from newFruit. newFruit: " + newFruit);
    System.out.println("What is the first element of newFruit? : " + newFruit.get(0));
    System.out.println("head of newFruit: " + newFruit.peek());
    System.out.println("tail of newFruit: " + newFruit.getTail());
    System.out.println("Is newFruit empty? : " + newFruit.isEmpty());
    System.out.println("What is the size of newFruit? : " + newFruit.size());
    System.out.println();

    LinkedList<Integer> nums = new LinkedList<>();
    nums.add(32);
    System.out.println("LinkedList nums: " + nums);
    nums.removeFirst();
    System.out.println("Removed the head of nums, nums: " + nums);
    System.out.println("Size of nums: " + nums.size());
    nums.add(4);
    nums.add(6);
    nums.add(8);
    nums.add(10);
    System.out.println("Added some numbers to nums, nums: " + nums);
    nums.removeLast();
    System.out.println("Removed the last element of nums, nums: " + nums);
    nums.remove(2);
    System.out.println("Removed the third element of nums, nums: " + nums);
    nums.set(0, Integer.valueOf(5));
    System.out.println("Set the first element to be 5, nums: " + nums);
    nums.set(1, Integer.valueOf(3));
    System.out.println("Set the second element to be 3, nums: " + nums);
    nums.add(2, Integer.valueOf(4));
    System.out.println("Added the number 4 to the third spot of the linked list, nums: " + nums);
    nums.add(0, Integer.valueOf(10));
    System.out.println("Added the number 10 to the first spot of the linked list, nums: " + nums);
    nums.add(1, Integer.valueOf(13));
    nums.add(3, Integer.valueOf(13));
    System.out.println("Added the number 13 to the second spot of the linked list, nums: " + nums);
    System.out.println("What is the index of 4? : " + nums.indexOf(Integer.valueOf(4)));
    System.out.println("What is the index of 10? : " + nums.indexOf(Integer.valueOf(10)));
    System.out.println("What is the index of 80? : " + nums.indexOf(Integer.valueOf(80)));
    System.out.println("What is the index of the first occurence of 13? : " + nums.indexOf(Integer.valueOf(13)));
    nums.remove(Integer.valueOf(13));
    System.out.println("Removed teh first instance of 13, nums: " + nums);




//check if head and tail are null
//head and tail are one thing
// more items


  }
}
