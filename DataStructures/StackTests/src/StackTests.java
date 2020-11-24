import java.util.EmptyStackException;
import java.util.Stack;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class StackTests{
    Stack<Integer> stack;

    @Before
    public void setup(){
        stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

    }

    @Test
    public void isEmptyTest0(){
        assertThat(stack.isEmpty(), is(false));
    }
    //make sure that value stack.isEmpty() == false

    @Test
    public void isEmptyTest1(){
        stack.pop();
        stack.pop();
        stack.pop();
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void outOfBoundsTest(){
        stack.pop();
        stack.pop();
        stack.pop();
        try{
            stack.pop();
            assertTrue("Exception expected, none thrown", false);
        }
        catch(EmptyStackException e){
            assertTrue(true);
        }
    }
}
