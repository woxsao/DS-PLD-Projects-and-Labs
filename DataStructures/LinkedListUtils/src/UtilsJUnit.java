/**
 * LinkedListUtils JUNIT
 * @author Monica Chan
 * @version 1.0
 */

import java.util.EmptyStackException;
import java.util.LinkedList;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class UtilsJUnit {
    LinkedList<Integer> nums;
    LinkedList<Integer> testNums;
    LinkedList<String> str;
    LinkedList<String> testStr;

    /**
     * This function runs before every @Test, sets up four Linked lists, nums and testNums
     * (duplicate of each other) and str and testStr (duplicates of each other)
     */
    @Before
    public void setup(){
        nums = new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        testNums = new LinkedList<>(nums);

        str = new LinkedList<>();
        str.add("mint");
        str.add("chocolate");
        str.add("ice cream");
        testStr = new LinkedList<>(str);
    }

    /**
     * inserts the number 2 into the nums, and makes sure the expected out put is [1, 2,2, 3]
     */
    @Test
    public void insertSorted1(){
        testNums.add(2,2);
        LinkedListUtils.insertSorted(nums,2);
        assertEquals(testNums, nums);
    }

    /**
     * clears nums and tries inserting into nums, makes sure expected output is [2]
     */
    @Test
    public void insertSorted2(){
        nums.clear();
        testNums.clear();
        testNums.add(2);
        LinkedListUtils.insertSorted(nums,2);
        assertEquals(testNums, nums);
    }

    /**
     * adds a new item that is the biggest in the list. makes sure output is [1,2,3,4]
     */
    @Test
    public void insertSorted3(){
        testNums.add(4);
        LinkedListUtils.insertSorted(nums,4);
        assertEquals(testNums, nums);
    }

    /**
     * adds a new item that is the smallest in the list. makes sure output is [1,2,3,4]
     */
    @Test
    public void insertSorted4(){
        testNums.add(0,-1);
        LinkedListUtils.insertSorted(nums,-1);
        assertEquals(testNums, nums);
    }

    /**
     * makes sure that the function throws an exception of the input n is greater than the size of the list.
     */
    @Test
    public void removeMaximumValuesException1(){
        try{
            LinkedListUtils.removeMaximumValues(4, str);
            assertTrue("Exception expected, none thrown", false);
        }
        catch(IndexOutOfBoundsException x){
            assertTrue(true);
        }
    }

    /**
     * Checks to make sure the code will work if the input linked list is null.
     */
    @Test
    public void removeMaximumValuesCondition1(){
        LinkedList<String> x = null;
        LinkedListUtils.removeMaximumValues(1,x);
        assertEquals(null,x);
    }

    /**
     * Checks to make sure the code will work if the input linked list is empty.
     */
    @Test
    public void removeMaximumValuesCondition2(){
        str.clear();
        testStr.clear();
        LinkedListUtils.removeMaximumValues(1,str);
        assertEquals(testStr,str);
    }

    /**
     * Checks to make sure that the code will work if the input n is non-positive.
     */
    @Test
    public void removeMaximumValuesCondition3(){
        LinkedListUtils.removeMaximumValues(-1,str);
        assertEquals(testStr,str);
    }

    /**
     * Checks to make sure that the function will work properly if removing the two largest strings.
     */
    @Test
    public void removeMaximumValues1(){
        str.add("chocolate");
        testStr.add("chocolate");
        LinkedListUtils.removeMaximumValues(2,str);
        testStr.remove("mint");
        testStr.remove("ice cream");
        assertEquals(testStr,str);
    }

    /**
     * Checks to make sure that the function will work properly if removing all of the items in the list.
     */
    @Test
    public void removeMaximumValues2(){
        LinkedListUtils.removeMaximumValues(3,str);
        assertThat(str.isEmpty(), is(true));
    }

    /**
     * Checks to make sure that containsSubsequence will work if the input linked list is empty.
     */
    @Test
    public void containsSubsequenceCondition1(){
        str.clear();
        assertThat(LinkedListUtils.containsSubsequence(str,testStr), is(false));
    }

    /**
     * Checks to make sure containsSubsequence will work if the input linked list is null.
     */
    @Test
    public void containsSubsequenceCondition2(){
        LinkedList<String> x = null;
        assertThat(LinkedListUtils.containsSubsequence(x,str), is(false));
    }

    /**
     * Checks to make sure function will work if the two linked lists are the same
     */
    @Test
    public void containsSubsequence1(){
        assertThat(LinkedListUtils.containsSubsequence(str,testStr), is(true));

    }

    /**
     * Checks to make sure that function will work if list 2 is contained within list 1.
     */
    @Test
    public void containsSubsequence2(){
        testStr.remove(0);
        assertThat(LinkedListUtils.containsSubsequence(str,testStr), is(true));
    }

    /**
     * Makes sure that the function returns false if list 1 does not contain list 2.
     */
    @Test
    public void containsSubsequence3(){
        testStr.add("chocolate");
        assertThat(LinkedListUtils.containsSubsequence(str,testStr), is(false));
    }







}
