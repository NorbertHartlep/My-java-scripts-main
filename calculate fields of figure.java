import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Pole jakiej figury chcesz obliczyć, zależnie wpisz trójkąt, kwadrat, prostokąt, okrag");
        float figura = input.nextFloat();
        if(figura == 1)
        {
            System.out.println("podaj wysokośc trójkąta");
            float wysokosc = input.nextFloat();
            System.out.println("podaj podstawe trójkąta");
            float bokpodst = input.nextFloat();
            float pole1 = wysokosc * bokpodst;
            float pole2 = pole1 / 2;
            System.out.println("pole trójkąta wynosi " + pole2);
        } else if (figura == 2) {
            System.out.println("jaki ma byc bok kwadratu");
            float bok = input.nextFloat();
            float pole1 = bok * bok;
            System.out.println("pole kwadratu wynosi " + pole1);

        } else if (figura == 3) {
            System.out.println("podaj pierwsza podstawę");
            float pierw = input.nextFloat();
            System.out.println("podaj drugą podstawę");
            float dru = input.nextFloat();
            float pole2 = pierw * dru;
            System.out.println("Pole wynosi " + pole2);
        } else if (figura == 4) {
            System.out.println("podaj promien(pi przyjmowane za 3,14");
            float prom = input.nextFloat();
            float prom2 = prom * prom;
            double pi = 3.14;
            double pole3 = prom2 * pi;
            System.out.println("pole okręgu wynosi" + pole3);
        }
    }
}