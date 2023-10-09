package scdas;

import java.util.*;

import stack.*;

public class App {
	public String getGreeting() {
		return "Hello World!";
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
			default:
				System.out.println("Invalid choice.");
				break;
		}

		scanner.close();
	}
}
