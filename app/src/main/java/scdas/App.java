package scdas;

import java.util.*;

import stack.*;
import stream.*;

public class App {

	private static void streamTest(){
		FirstNonRepeatingStream stream = new FirstNonRepeatingStream();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a line full of characrters:");
		String line = scanner.next();
		byte[] bytes = line.getBytes();
		for (int i = 0; i < bytes.length; i ++)
			stream.add((char)bytes[i]);
		System.out.println("first non repeating character: " +
				stream.getFirstNonRepeating());
		scanner.close();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select an option:\n0. Exit\n1. Stack Demo");
		int choice = scanner.nextInt();

		switch (choice){
			case 0:
				break;
			case 1:
				stack.Demo.stackMain();
				break;
			case 2:
				streamTest();
				break;
			default:
				System.out.println("Invalid choice.");
				break;
		}

		scanner.close();
	}
}
