package bai6_6;
import java.util.Scanner;
import java.util.Arrays;
public class Bai6_6 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row, col, i, j;
        System.out.print("rows: ");
        row = sc.nextInt();
        System.out.print("columns: ");
        col = sc.nextInt();
        double[][] arrMa1 = new double[row][col];
        double[][] arrMa2 = new double[row][col];
        System.out.println("first matrix: ");
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                arrMa1[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Enter the second matrix: ");
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                arrMa2[i][j] = sc.nextDouble();
            }
        }
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                arrMa2[i][j] += arrMa1[i][j];
            }
        }
        System.out.println();
        System.out.println("The array after sum:");
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.print("\t" + arrMa2[i][j] + " ");
            }
            System.out.println();
        }
    }

}
