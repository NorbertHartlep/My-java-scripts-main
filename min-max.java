import java.util.*;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

            int attempts = 5;
            //System.out.println("Choose your number from 0 to 10");
            //int computerChoice = random.nextInt(0,11);
            //int yourChoice = input.nextInt();

            while (attempts > 0) {
                System.out.println("Choose your number from 0 to 10");
                int computerChoice = random.nextInt(0,11);
                int yourChoice = input.nextInt();
                if (yourChoice < 0 || yourChoice < 10) {
                    if (yourChoice == computerChoice) {
                        System.out.println("You won!");
                        attempts = 0;
                    } else if (yourChoice != computerChoice) {
                        System.out.println("Not today," + "computer picked" + computerChoice + " and you picked"
                                + yourChoice + "try again, you have " + attempts  + " more atempts");
                        --attempts;
                    }
                } else
                    System.out.println("Choose your number from 0 to 10, NOT other");
            }


        }

    }