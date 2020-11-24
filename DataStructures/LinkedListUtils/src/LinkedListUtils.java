/**
 * LinkedListUtils
 * @author Monica Chan
 * @version 1.0
 */

import java.util.LinkedList;


public class LinkedListUtils{
    public static void main(String[] args){

        LinkedList<Integer> nums1 = new LinkedList<>();
        nums1.add(Integer.valueOf(1));
        nums1.add(Integer.valueOf(1));
        nums1.add(Integer.valueOf(2));
        nums1.add(Integer.valueOf(3));
        System.out.println("nums1: " + nums1);
        insertSorted(nums1, 2);
        System.out.println("Inserted the number 2 into nums1: ");
        System.out.println(nums1);
        insertSorted(nums1, 3);
        System.out.println("Inserted the number 3 into nums1: ");
        System.out.println(nums1);
        insertSorted(nums1, 7);
        System.out.println("Inserted the number 7 into nums1: ");
        System.out.println(nums1);
        insertSorted(nums1, 5);
        System.out.println("Inserted the number 5 into nums1: ");
        System.out.println(nums1);
        LinkedList<Integer> nums2 = new LinkedList<>();
        System.out.println("nums2: " + nums2);
        insertSorted(nums2, 1);
        System.out.println("Inserted 1 into nums2: " + nums2);
        nums2.add(1);
        System.out.println("added 1 into nums2: " + nums2);
        insertSorted(nums2, -1);
        System.out.println("Inserted -1 into nums2: " + nums2);

        LinkedList<String> str1 = new LinkedList<>();
        str1.add("hi");
        str1.add("hi");
        str1.add("potato");
        str1.add("how are you doing?");
        str1.add("hi");
        System.out.println("str1: " + str1);
        removeMaximumValues(2, str1);
        System.out.println("Removed the two greatest strings in str1: " + str1);

        LinkedList<String> str2 = new LinkedList<>();
        str2.add("eggplant");
        System.out.println("str2: " + str2);
        removeMaximumValues(1, str2);
        System.out.println("removed the greatest string from str2, str2: ");
        str2.add("poppy");
        str2.add("poppy");
        System.out.println("Added the string 'poppy' to the list twice. str2: " + str2);
        removeMaximumValues(0,str2);
        System.out.println("removed nothing from str2, str2: " + str2);
        removeMaximumValues(1, str2);
        System.out.println("removed the greatest string from str2, str2: " + str2);
        LinkedList<String> plants = new LinkedList<>();
        plants.add("cactus");

        System.out.println("plants: " + plants);
        LinkedList<String> plants1 = new LinkedList<>();

        plants1.add("cactus");


        System.out.println("plants1: " + plants1);
        System.out.println("Does plants contain plants1?: " + containsSubsequence(plants, plants1));

        LinkedList<Integer> ages = new LinkedList<>();
        ages.add(3);
        ages.add(56);
        ages.add(27);
        System.out.println("ages: " + ages);
        LinkedList<Integer> ages1 = new LinkedList<>();
        ages1.add(56);
        ages1.add(3);
        ages1.add(56);
        ages1.add(56);

        System.out.println("ages1: " + ages1);
        System.out.println("Does ages contain ages1? : " + containsSubsequence(ages, ages1));

        LinkedList<String> flowers = new LinkedList<>();
        flowers.add("daisy");
        flowers.add("petunia");
        flowers.add("carnation");
        flowers.add("magnolia");

        LinkedList<String> flowers1 = new LinkedList<>();
        flowers1.add("carnation");
        flowers1.add("magnolia");
        System.out.println("flowers: " + flowers);
        System.out.println("flowers1: " + flowers1);
        System.out.println("Does flowers contain flowers1? : " + containsSubsequence(flowers, flowers1));
    }

    /**
     * This function inserts an inputted integer value into its sorted position in
     an Integer linked list, assuming that the inputted linked list is in order.
     If the list is null, nothing gets inserted and the function just terminates.
     * @param a Integer linked list to insert value into.
     * @param value the integer value to insert into the linked list.
     */

    public static void insertSorted(LinkedList<Integer> a, int value){
        int size = a.size();
        Integer current = a.peek();
        //if list is null
        if(a == null)
            return;
        // if list is empty
        else if(a.isEmpty()) {
            a.add(value);
            return;
        }
        // if list has one item
        else if(a.peekFirst() == a.peekLast()){
            if(value < current)
                a.add(0,value);
            else
                a.add(1, value);
            return;
        }
        //all other cases
        for(int i = 0; i < size-1; i++){
            if(value < current){
                a.add(i, Integer.valueOf(value));
                return;
            }
            current = a.get(i+1);
        }
        //the loop ends before checking the last value, so I just added this if statement in to check the last value.
        if(value >= current){
            a.add(size, Integer.valueOf(value));
        }
        else
            a.add(size-1, Integer.valueOf(value));
    }

    /**
     * This function removes the n largest unique (lexicographically) strings in a given
     linked list. If the string happens more than one time, it will delete all instances
     of the string (but still only count as one string). If the linked list is empty or n <= 0
     it will return nothing. If n exceeds the size of the list an IndexOutOfBoundsException will be thrown.
     * @param n the number of unique strings to remove.
     * @param a the linked list to remove from.
     */
    public static void removeMaximumValues(int n, LinkedList<String> a){
        if(a == null || n <=0 ||a.isEmpty())
            return;
        int size = a.size();

        if(n > size)
            throw new IndexOutOfBoundsException("N exceeds the size of the list!");
        String current = null;
        String largest = a.peek();
        boolean removeInstance = true;
        for(int i = 0; i < size-1; i++){
            current = a.get(i);
            if(current.compareTo(largest) > 0){
                largest = current;
            }

        }
        if(current != null && current.compareTo(largest) > 0)
            largest = current;
        while(removeInstance){
            removeInstance = a.removeFirstOccurrence(largest);
        }
        if(n > 1)
            removeMaximumValues(n-1, a);
    }

    /**
     * This function checks if an inputted linked list contains the other inputted
     linkedlist in exact order. It returns true if it does, false otherwise.
     * @param a the linked list to check if it contains the other.
     * @param b the linked list to check if it is contained in the first linked list.
     * @return true if a contains b, false if a does not contain b.
     */
    public static <E> boolean containsSubsequence(LinkedList<E> a, LinkedList<E> b){
        if(a == null||b == null || a.isEmpty()||b.isEmpty())
            return false;
        E headB = b.peek();
        E currentB = b.peek();
        int counter = b.size();
        int sizeA = a.size();
        int sizeB = b.size();

        if(a.size() < b.size())
            return false;

        for(int i = 0; i < sizeA; i++){
            if(a.get(i).equals(currentB)){
                if(counter == 1)
                    break;
                counter--;
                currentB = b.get(sizeB - counter);
            }
            else if(!currentB.equals(headB))
                return false;
        }
        if(sizeB != 1 && currentB.equals(headB))
            return false;
        else{
            return true;
        }
    }

}
