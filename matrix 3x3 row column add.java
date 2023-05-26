import java.util.*;
public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int[][] maciez = {
            {random.nextInt(0,11),random.nextInt(0,11),random.nextInt(0,11)},
            {random.nextInt(0,11),random.nextInt(0,11),random.nextInt(0,11)},
            {random.nextInt(0,11),random.nextInt(0,11),random.nextInt(0,11)}
    };
        //wiersz
        int sum1 = maciez[0][0] + maciez[0][1] + maciez[0][2];
        //kolumna
        int sum2 =  maciez[0][0] + maciez[1][0] + maciez[2][0];
        //ukos
        int sum3 = maciez[0][0] + maciez[1][1] + maciez[2][2];

        System.out.println("Rekordy w1 " + maciez[0][0] + " " + maciez[0][1] + " " + maciez[0][2]);
        System.out.println("Rekordy w2 " + maciez[1][0] + " " + maciez[1][1] + " " + maciez[1][2]);
        System.out.println("Rekordy w3 " + maciez[2][0] + " " + maciez[2][1] + " " + maciez[2][2]);
        System.out.println("Suma wylosowanych długości macierzy " + " wiersz " + sum1 + " kolumna " + sum2 + " ukos " + sum3);
    }
}