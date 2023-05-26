import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Give the number");
        //input number
        int numbers = input.nextInt();
        // check the last digit and increment the count for this digit
        int[] digits = new int[10];
        while (numbers > 0) {
            //digits[rest from numbers/10]
            digits[numbers % 10]++;
            //numbers = numbers / 10
            numbers /= 10;
        }

// find the digit with the highest count
        int maxCount = 0;
        //highest digit in entered number
        int maxIdx = 0;
        // go though every digits record
        for (int i = 0; i < digits.length; i++) {
            //if digit record is bigger than maxcount (initially 0)
            //set maxcount as this number
            if (digits[i] > maxCount) {
                maxCount = digits[i];
                //set max idx to i which is record of array
                maxIdx = i;
            }
        }
        System.out.printf("max digit: "+ maxIdx + " count: " + maxCount);
    }
}