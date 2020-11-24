/**
* Clac
* @author Monica Chan
* @version 1.0
*/

import java.util.*;
import java.lang.NumberFormatException;

public class Clac {

	/**
	* Main method that evaluates the command line and handles what calculations to execute.
	* @param tokenQueue is the queue (user input)
	* @param stack is the stack of the output calculations
	* @param state is the stack that stores the data that comes after a function declaration.
	* @param dict is the Map that stores function names and their definition.
	* @return boolean value, true.
	*/
	public static boolean evaluate(Queue<String> tokenQueue, Stack<Integer> stack, Stack<Queue<String>> state, Map<String, Queue<String>> dict) {
		while(tokenQueue.size()>0 || !state.isEmpty()){
			String i = tokenQueue.poll();
			try{
				stack.push(Integer.parseInt(i));
			}
			catch(NumberFormatException e){
				if(i.equals("quit"))
					return false;
				else if(i.equals("+"))
					add(stack);
				else if(i.equals("*"))
					multiply(stack);
				else if(i.equals("/"))
					divide(stack);
				else if(i.equals("-"))
					subtract(stack);
				else if(i.equals("%"))
					mod(stack);
				else if(i.equals("**"))
					pow(stack);
				else if(i.equals("<"))
					lessThan(stack);
				else if(i.equals("="))
					equalTo(stack);
				else if(i.equals("drop"))
					drop(stack);
				else if(i.equals("swap"))
					swap(stack);
				else if(i.equals("rot"))
					rot(stack);
				else if(i.equals("if"))
					stackIf(stack, tokenQueue);
				else if(i.equals("pick"))
					pick(stack);
				else if(i.equals("skip"))
					skip(stack, tokenQueue);
				else if(i.equals(":")){
					funcPut(tokenQueue, dict);
				}
				else{
					try {
						Queue<String> polled = new LinkedList<String>();
						while (!tokenQueue.isEmpty()) {
							polled.add(tokenQueue.poll());
						}
						state.push(polled);
						Queue<String> def = deepCopy(dict.get(i));
						tokenQueue = def;
						pushStateStackToQueue(state, tokenQueue);
					}
					catch(NullPointerException x){
						System.out.println("I have nothing to do for you :( try defining a method)");
					}
				}


			}

		}


		return true;

	}

	/**
	* Method adds the two integers at the top of the stack.
	* @param stack is the stack where the integers are.
	*/
	public static void add(Stack<Integer> stack){
		Integer y = stack.pop();
		Integer x = stack.pop();
		stack.push(x+y);
	}

	/**
	* Method mulitiplies two integers at the top of the stack.
	* @param stack is the stack where the integers are.
	*/
	public static void multiply(Stack<Integer> stack){
		Integer y = stack.pop();
		Integer x = stack.pop();
		stack.push(x*y);
	}

	/**
	* Method divides two integers at the top of the stack. (second to top / top)
	* @param stack is the stack where the integers are.
	*/
	public static void divide(Stack<Integer> stack){
		Integer y = stack.pop();
		Integer x = stack.pop();
		stack.push(x/y);
	}

	/**
	* Method subtracts the two integers at the top of the stack. (second to top - top)
	* @param stack is the stack where the integers are.
	*/
	public static void subtract(Stack<Integer> stack){
		Integer y = stack.pop();
		Integer x =  stack.pop();
		stack.push(x-y);
	}

	/**
	* Method mods two integers at the top of the stack. (Second to top % top)
	* @param stack is the stack where the integers are.
	*/
	public static void mod(Stack<Integer> stack){
		Integer y = stack.pop();
		Integer x = stack.pop();
		stack.push(x % y);
	}

	/**
	* Method raises two integers to the power of the other at the top of the stack. (second to top to the power of the top)
	* @param stack is the stack where the integers are.
	*/
	public static void pow(Stack<Integer> stack){
		Integer y = stack.pop();
		Integer x = stack.pop();
		stack.push((int)Math.pow(x,y));
	}

	/**
	* Method returns whether or not the second to top item of the stack is less than the top.
	If it is, it will push 1 to the stack, otherwise it will push 0 if the second to top integer is greater than or equal to the top.
	* @param stack is the stack where the integers are.
	*/
	public static void lessThan(Stack<Integer> stack){
		Integer y = stack.pop();
		Integer x = stack.pop();
		if(x < y){
			stack.push(1);
		}
		else{
			stack.push(0);
		}
	}

	/**
	* Method evaluates whether the top two items of the stack are equal to each other,
	if they are it will push one, otherwise it will push 0.
	* @param stack is the stack where the integers are.
	*/
	public static void equalTo(Stack<Integer> stack){
		Integer y = stack.pop();
		Integer x = stack.pop();
		if(x == y){
			stack.push(1);
		}
		else{
			stack.push(0);
		}
	}

	/**
	* Method removes the top item of the stack.
	* @param stack is the stack where the integers are.
	*/
	public static void drop(Stack<Integer> stack){
		stack.pop();
	}

	/**
	* Method switches the two top items of the stack.
	* @param stack is the stack where the integers are.
	*/
	public static void swap(Stack<Integer> stack){
		Integer y = stack.pop();
		Integer x = stack.pop();
		stack.push(y);
		stack.push(x);
	}

	/**
	* Method rotates the third to top item of the stack to the top of the stack.
	* @param stack is the stack where the integers are.
	*/
	public static void rot(Stack<Integer> stack){
		Integer z = stack.pop();
		Integer y = stack.pop();
		Integer x = stack.pop();
		stack.push(y);
		stack.push(z);
		stack.push(x);
	}

	/**
	* Method evaluates whether the top item of the stack is 0, if it is, the next three
	commands on the queue will be removed.
	* @param stack is the stack where the integers are.
	* @param queue is the token queue where the commands are.
	*/
	public static void stackIf(Stack<Integer> stack, Queue<String> queue){
		if(stack.peek().equals(0)){
			queue.poll();
			queue.poll();
			queue.poll();
			stack.pop();
		}
		else{
			stack.pop();
		}
	}

	/**
	* Integer n is the item at the top of the stack. Method looks at the value of n, removes it, and copies
	the nth item from the top of the stack to the top of the stack. For instance, if the stack is
	1 2 3 4 2 where the right is the head of the stack, the pick function should turn the stack into
	1 2 3 4 3.
	* @param stack is the stack where the integers are.
	*/
	public static void pick(Stack<Integer> stack){
		Integer n = stack.pop();
		if (n <= 0)
			throw new IndexOutOfBoundsException("exceeds length of the queue");
		else{
			Integer x = stack.get(stack.size()-n);
			stack.push(x);
		}
	}

	/**
	* Integer n is the item at the top of the stack. Method looks at the value of n, removes it, and ignores
	n number of commands following skip. For instance, if the stack is: 1 2 3 1, where the right is the
	head of the stack, and the queue is: skip + -, the stack should turn into 1 -1.
	* @param stack is the stack where the integers are.
	*/
	public static void skip(Stack<Integer> stack, Queue<String> queue){
		Integer n = stack.pop();
		if(n<0)
			throw new IndexOutOfBoundsException("exceeds length of queue");
		else{
			while(n > 0){
				queue.poll();
				n--;
			}
		}
	}

	/**
	* This function puts a function definition into the map of function names and definitions.
	* @param queue is the queue of commands (user input)
	* @param dict is the map to map the function name and definition to.
	*/
	public static void funcPut(Queue<String> queue, Map<String, Queue<String>> dict){
		Queue<String> functionDef = new LinkedList<String>();
		String functionName = queue.poll();
		String i = queue.poll();
			while(!i.equals(";")){
				functionDef.add(i);
				i = queue.poll();
			}
		dict.put(functionName, functionDef);
	}

	/**
	* This function pushes the state stack to the queue.
	* @param state is the state stack.
	* @param tokenQueue is the queue of calculations.
	*/
	public static void pushStateStackToQueue(Stack<Queue<String>> state, Queue<String> tokenQueue){
		Queue<String> x = null;
		while(!state.isEmpty()){
			x = state.pop();
			while(!x.isEmpty()){
				tokenQueue.add(x.poll());
			}
		}
	}

	/**
	* This function makes a deep copy of the value in the map so that it does not affect
	the map.
	* @param value is the queue that we are trying to copy.
	* @return a copy of the queue.
	*/
	public static Queue<String> deepCopy(Queue<String> value){
		int size = value.size();
		Queue<String> returnQueue = new LinkedList<String>();
		while(size > 0){
			String valueTemp = value.poll();
			String temp = new String(valueTemp);
			value.offer(valueTemp);
			returnQueue.offer(temp);
			size --;

		}
		return returnQueue;
	}






}
