package bai6_5;
import java.util.Scanner;
import java.util.Arrays;
public class Bai6_5 {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the number of elements: ");
		 int n = sc.nextInt();
		 int[] arr = new int[n];
		 double sum = 0;
		 for (int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
			 sum += arr[i];
		 }
		 Arrays.sort(arr);
		 System.out.print("Arrays after sort: ");
		 for (int i = 0; i < n; i++) {
			 System.out.print(arr[i] + " ");
		 }
		 System.out.println();
		 System.out.println("The sum: " + sum);
		 System.out.print("The average: " + (sum/n));
	 }
}
