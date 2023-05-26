import java.util.*;

public class App {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        // initialize matrix values
        System.out.print("Podaj liczbę wierszy pierwszej macierzy: ");
        int rows1 = input.nextInt();
        System.out.print("Podaj liczbę kolumn pierwszej macierzy: ");
        int columns1 = input.nextInt();
        System.out.print("Podaj liczbę wierszy drugiej macierzy: ");
        int rows2 = input.nextInt();
        System.out.print("Podaj liczbę kolumn drugiej macierzy: ");
        int columns2 = input.nextInt();
        System.out.print("Podaj skalar: ");
        int scalar = input.nextInt();
        // creating two empty matrixes, and the modified for equations
        int[][] matrix1 = new int[rows1][columns1];
        int[][] matrix2 = new int[rows2][columns2];
        int[][] sum = new int[rows1][columns1];
        int[][] sub = new int[rows1][columns1];
        int[][] multiplyByMatrix = new int[rows1][columns2];
        int[][] multiplyByScalar = new int[rows1][columns1];
        int[][] transposedMatrix = new int[rows1][columns1];
        // filling first matrix with numbers
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {

                matrix1[i][j] = random.nextInt(0, 11);
            }
        }
        // showing the first matrix
        System.out.println("Twoja pierwsza macierz:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        // filling second matrix with numbers
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < columns2; j++) {

                matrix2[i][j] = random.nextInt(0, 11);
            }
        }
        // showing second matrix
        System.out.println("Twoja druga macierz:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < columns2; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        // check if we can multiply, add or substract the matrix
        if (columns1 == rows2) {
            // multiply matrixes
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns2; j++) {
                    for (int k = 0; k < columns1; k++) {
                        multiplyByMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            // show multiplyed matrix
            System.out.println("Twoja macierz przemnozona przez drugą macierz:");
            for (int i = 0; i < rows2; i++) {
                for (int j = 0; j < columns2; j++) {
                    System.out.print(multiplyByMatrix[i][j] + " ");
                }
                System.out.println();
            }
            // add matrixes
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    sum[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            // show added matrixes
            System.out.println("Twoja macierz po dodawaniu drugiej macierzy:");
            for (int i = 0; i < rows2; i++) {
                for (int j = 0; j < columns2; j++) {
                    System.out.print(sum[i][j] + " ");
                }
                System.out.println();
            }
            // substract matrixes
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    sub[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
            // show substracted matrixes
            System.out.println("Twoja macierz po odjęciu drugiej macierzy:");
            for (int i = 0; i < rows2; i++) {
                for (int j = 0; j < columns2; j++) {
                    System.out.print(sub[i][j] + " ");
                }
                System.out.println();
            }
        }
        // multiplying by scalar
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < columns2; j++) {
                multiplyByScalar[i][j] = matrix1[i][j] * scalar;
            }
        }
        System.out.println("Twoja macierz po odjęciu drugiej macierzy:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < columns2; j++) {
                System.out.print(multiplyByScalar[i][j] + " ");
            }
            System.out.println();
        }
        // transpozycja
        transpose(matrix1, transposedMatrix);
        input.close();

    }

    public static void transpose(int[][] matrix, int[][] transposedmatrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                transposedmatrix[j][i] = matrix[i][j];
            }
        }
        System.out.println("Twoja macierz po transpozycji:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(transposedmatrix[j][i] + " ");
            }
            System.out.println();
        }
    }
}
