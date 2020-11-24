import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ClacRunner {
	public static void main (String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Queue<String>> state = new Stack<Queue<String>>();
		Map<String, Queue<String>> dict = new HashMap<String, Queue<String>>();


		if (args.length > 0) {
			Queue<String> fileQueue = parseClacFile(args[0]);
			boolean again = Clac.evaluate(fileQueue, stack, state, dict);
			printStack(stack);

			if (!again) return;
		}



		Scanner scanner = new Scanner(System.in);

		boolean again = false;
		do {
			System.out.print("clac>> ");
			String code = scanner.nextLine();
			again = Clac.evaluate(buildQueue(code), stack, state, dict);

			printStack(stack);
		}
		while (again);

		scanner.close();
	}


	private static void printStack(Stack<Integer> stack) {
		System.out.print("stack] ");

		for (int num : stack) {
			System.out.print(num + " ");
		}

		System.out.println();
	}

	private static Queue<String> buildQueue(String code) {
		Queue<String> tokenQueue = new LinkedList<String>();

		for (String tok : code.split(" ")) {
			tokenQueue.offer(tok);
		}

		return tokenQueue;
	}

	private static Queue<String> parseClacFile(String filename) {
		Queue<String> fileQueue = new LinkedList<String>();

		File file = new File(filename + ".clac");
		Scanner input;
		try {
			input = new Scanner(file);

			while(input.hasNext()) {
			    String nextToken = input.next();
			    fileQueue.offer(nextToken);
			}

			input.close();
		} catch (FileNotFoundException e) {
			System.err.println("The file with filename " + filename + " could not be found.");
		}


		return fileQueue;
	}
}
