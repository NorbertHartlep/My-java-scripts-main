import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Lokata");
        System.out.println("Podaj oprocentowanie lokaty");
        float oprocent = input.nextFloat();
        System.out.println("Podaj całkowity depozyt");
        int iloscDni = input.nextInt();
        System.out.println("Ile dni pracowała lokata?");
        double depo = input.nextInt();
        System.out.println("Ile podatku musisz odprowadzić od zysków(w %)?");
        float podatek = input.nextFloat();
        var odsetki1 = depo * iloscDni * oprocent;
        //wlasciwe odsetki
                var odsetki2 = odsetki1 / 365;
        double podatekProc = podatek / 100;
               double podatekZOdsetek = odsetki2 * podatekProc;
               double zysk = odsetki2 - podatekZOdsetek;

        System.out.println("Będziesz musiał odprowadzić " + podatekZOdsetek +" podatku, i zarobisz " +
                + zysk);
    }
}