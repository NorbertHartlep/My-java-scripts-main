import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rok = 2023;
        System.out.println("rok " + rok + " to rok nie przestępny");
        if((rok % 4) != 0) {
            rok++;
            if ((rok % 4) == 0) {
                for (int i = 0; i < 22; i++) {
                    int przestepny = rok + 4 * i;
                    int nrRoku = i+1;
                    if((przestepny % 2100) == 0){
                        continue;
                    }


                    System.out.println("Rok przestępny nr " + nrRoku + " to rok " + przestepny);
                }
            }
        }
    }
}