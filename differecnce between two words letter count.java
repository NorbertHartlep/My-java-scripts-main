import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("podaj pierwsze slowo!");
        String slowo1 = input.nextLine();
        System.out.println("podaj drugie slowo!");
        int roznica = 0;
        String slowo2 = input.nextLine();
        int slowo1len = slowo1.length();
        int slowo2len = slowo2.length();
        if(slowo1len > slowo2len) {
             roznica = slowo1len - slowo2len;
        }
        else{
             roznica = slowo2len -slowo1len;
        }
        System.out.println("roznica miedzy slowami wynosi " + roznica);
    }
}