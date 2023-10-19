import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int row1, col1, row2, col2;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the order of matrix1");
        row1 = scan.nextInt();
        col1 = scan.nextInt();
        System.out.println("Enter the order of matrix2");
        row2 = scan.nextInt();
        col2 = scan.nextInt();

        if (col1 != row2) {
            System.out.println("Matrix multiplication is not possible.");
        } else {
            int[][] matrix1 = new int[row1][col1];
            int[][] matrix2 = new int[row2][col2];

            System.out.println("Enter the values of matrix1");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    matrix1[i][j] = scan.nextInt();
                }
            }

            System.out.println("Enter the values of matrix2");
            for (int i = 0; i < row2; i++) {
                for (int j = 0; j < col2; j++) {
                    matrix2[i][j] = scan.nextInt();
                }
            }

            if (col1 == row2) {
                int[][] matrixProduct = new int[row1][col2];

                for (int i = 0; i < row1; i++) {
                    for (int j = 0; j < col2; j++) {
                        matrixProduct[i][j] = 0;
                        for (int k = 0; k < col1; k++) {
                            matrixProduct[i][j] += (matrix1[i][k] * matrix2[k][j]);
                        }
                    }
                }

                System.out.println("The product is:");
                for (int i = 0; i < row1; i++) {
                    for (int j = 0; j < col2; j++) {
                        System.out.print(matrixProduct[i][j] + "\t");
                    }
                    System.out.println();
                }
            }
        }
    }
}
