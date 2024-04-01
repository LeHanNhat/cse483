package view;

import java.util.Scanner;

public class HomeView {
	public static Scanner sc = new Scanner(System.in);
	
	public int displayServiceMenu() {
		System.out.println("Please input the number of the service you want:");
		System.out.println("1. Show transactions.");
		System.out.println("2. Deposit.");
		System.out.println("3. Withdraw.");
		System.out.println("4. Logout.");
		return sc.nextInt();
	}
	
	public void errorInputNotify(int choice) {
		System.out.println("Unexpected value: " + choice);
	}
	
	public double depositView() {
		System.out.println("Please input the amount:");
		return sc.nextDouble();
	}
	
	public double withdrawView() {
		System.out.println("Please input the amount:");
		return sc.nextDouble();
	}
}
