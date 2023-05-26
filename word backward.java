import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Give the string");
        //nastepna wpisana linia to slowo
        String slowo = input.nextLine();
        // Creating array of string length
        // using length() method
        char[] ch = new char[slowo.length()];

        // Kopiowanie litera po literze do tablicy utworzonej powyzej
        // using for each loop

        for (int i = 0; i < slowo.length(); i++) {
            ch[i] = slowo.charAt(i);
        }

        //for przechodzacy przez kazdy element tablicy i wypisujacy go, wraz ze spacja

        System.out.println("Original Array printed in normal order:");
        for(int i = 0; i<ch.length; i++){
            System.out.print(ch[i] + "  ");
        }

        //to samo co wyzej tyle ze od konca
        //print array starting from last element

        System.out.println("Original Array printed in reverse order:");
        for(int i=ch.length-1;i>=0;i--)
            System.out.print(ch[i] + "  ");
    }
}