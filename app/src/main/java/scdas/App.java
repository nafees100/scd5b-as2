package scdas;

import java.util.*;

import stack.*;
import merger.*;

public class App {

	private static void stackTest(){
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

	public static void mergerTest(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of intervals: ");
		int count = scanner.nextInt();
		ArrayList<int[]> intervals = new ArrayList<>();
		for (int i = 0; i < count; i ++){
			int[] interval = new int[2];
			System.out.print("Enter start for interval " + (i + 1) + ": ");
			interval[0] = scanner.nextInt();
			System.out.print("Enter end for interval " + (i + 1) + ": ");
			interval[1] = scanner.nextInt();
			intervals.add(interval);
		}
		scanner.close();
		Merger.mergeIntervals(intervals);

		// print them
		for (int i = 0; i < intervals.size(); i ++){
			System.out.println("\t[" +
					intervals.get(i)[0] + ", " + intervals.get(i)[1] + "]");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select an option:\n0. Exit\n1. Stack Demo\n" +
				"2. Stream Demo\n3. Merger Demo");
		int choice = scanner.nextInt();

		switch (choice){
			case 0:
				break;
			case 1:
				stackTest();
				break;
			case 3:
				mergerTest();
				break;
			default:
				System.out.println("Invalid choice.");
				break;
		}

		scanner.close();
	}
}
