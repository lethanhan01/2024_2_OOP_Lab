package bai6_3;

import java.util.Scanner;

public class Bai6_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-i; j++) {
				System.out.print(" ");
			}
			for(int x = 0; x < 2*i - 1; x++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
