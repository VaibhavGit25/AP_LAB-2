import java.util.*;

class MatrixMismatchException extends Exception {
	public MatrixMismatchException(String message) {
		super(message);
	}
}

public class Problem2_MatrixMultiplication {

	public static int[][] multiplyMatrices(int[][] A, int[][] B) throws MatrixMismatchException {
		int rowsA = A.length;
		int colsA;
		if (rowsA > 0) {
			colsA = A[0].length;
		} else {
			colsA = 0;
		}

		int rowsB = B.length;
		int colsB;
		if (rowsB > 0) {
			colsB = B[0].length;
		} else {
			colsB = 0;
		}

		if (colsA != rowsB) {
			throw new MatrixMismatchException("Matrix mismatch: columns of A must equal rows of B.");
		}

		int[][] result = new int[rowsA][colsB];

		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < colsB; j++) {
				for (int k = 0; k < colsA; k++) {
					result[i][j] += A[i][k] * B[k][j];
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Enter rows and cols for Matrix A: ");
			int rowsA = sc.nextInt();
			int colsA = sc.nextInt();
			int[][] A = new int[rowsA][colsA];
			System.out.println("Enter elements for Matrix A:");
			for (int i = 0; i < rowsA; i++) {
				for (int j = 0; j < colsA; j++) {
					A[i][j] = sc.nextInt();
				}
			}

			System.out.print("Enter rows and cols for Matrix B: ");
			int rowsB = sc.nextInt();
			int colsB = sc.nextInt();
			int[][] B = new int[rowsB][colsB];
			System.out.println("Enter elements for Matrix B:");
			for (int i = 0; i < rowsB; i++) {
				for (int j = 0; j < colsB; j++) {
					B[i][j] = sc.nextInt();
				}
			}

			int[][] result = multiplyMatrices(A, B);

			System.out.println("Resulting Matrix:");
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[i].length; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}

		} catch (MatrixMismatchException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}
