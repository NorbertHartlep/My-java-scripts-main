import java.util.Random;
//import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //Scanner input = new Scanner(System.in);

        System.out.println("program wylosuje 2 liczby i podzieli je przez siebie");
        Random rand = new Random();
        int num1 = rand.nextInt(100);
        System.out.println("1 liczba to"+ num1);
        Random rand1 = new Random();
        int num2 = rand1.nextInt(100);
        System.out.println("2 liczba to"+ num2);
        double dzielenie = num1 / num2;
        double reszta = num1 % num2;
        System.out.println("wynik to "+ dzielenie+" a reszta to " + reszta );
    }
}