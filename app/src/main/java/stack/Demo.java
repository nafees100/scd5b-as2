package stack;

import java.util.*;

public class Demo{
	public static void stackMain(){
		GenericStack<Integer> stack = new GenericStack<>();
		Scanner scanner = new Scanner(System.in);

		while (true){
			System.out.println("Select an option:\n1. Push\n2. Pop\n3. Count" +
					"\n4. Empty?\n0. Exit");
			int input = scanner.nextInt();
			switch (input){
				case 0:
					scanner.close();
					return;
				case 1:
					System.out.print("Enter integer to push: ");
					input = scanner.nextInt();
					stack.push(input);
					break;
				case 2:
					try{
						System.out.println("Popped " + stack.pop());
					}catch (CustomException e){
						System.out.println("CustomException caught: " + e.getMessage());
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Count is " + stack.size());
					break;
				case 4:
					if (stack.isEmpty())
						System.out.println("Empty: Yes");
					else
						System.out.println("Empty: No");
			}
		}
	}
}
