package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int codeLength = userInput.nextInt();
        if (codeLength > 10) {
            System.out.println("Error: can't generate a secret number with " +
                    "a length of 11 because there aren't enough unique digits.");
        } else {
            System.out.print("The random secret number is ");
            displayArray(generateSecretCode(codeLength));
        }
    }

    private static int[] generateSecretCode(int codeLength) {
        int[] result = new int[codeLength];
        for (int i = 0; i < codeLength; i++) {
            int temp;
            do {
                temp = (int) (Math.random() * 10);
            } while (isInArray(result, temp) != -1);
            result[i] = temp;
        }
        return result;
    }

    private static int isInArray(int[] intArr, int number) {
        int result = -1;
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] == number) {
                result = i;
                break;
            }
        }
        return result;
    }

    private static void displayArray(int[] intArray) {
        for (int i : intArray) {
            System.out.print(i);
        }
    }
}
