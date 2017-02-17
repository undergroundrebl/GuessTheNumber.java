import java.util.Random;
import java.util.Scanner;

 /**
 * Created by Dylan.H on 2/9/17 on student D01.
 */

public class GuessNumberGame {

    public static void main(String[] args) {
        int howManyG = 3;
        String checkStr;
        int theGuess;
        Random randGenerator = new Random();
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("do you want to play Guess The number? y/n:");
        String playAgain = userInputScanner.nextLine();

        while (playAgain.equals("y")) {

            int numberToGuess = randGenerator.nextInt(10) + 1;
            while (howManyG > 0) {

                if (howManyG == 1) {
                    System.out.println("you have " + howManyG + " guess left");
                } else {
                    System.out.println("you have " + howManyG + " guesses left");
                }

                System.out.println("Guess a number between 1-10: ");
                checkStr = userInputScanner.nextLine();

                try {
                    theGuess = Integer.parseInt(checkStr);

                    String result = EvaluateGuess(theGuess, numberToGuess);

                    System.out.println(result);

                    if (result.contains("correct")) {
                        break;
                    } else if (result.contains("high")) {
                        howManyG--;

                    } else if (result.contains("low")) {
                        howManyG--;
                    }

                } catch (NumberFormatException nfe) {
                    System.out.println("Guess a NUMBER between 1-10: ");
                }

            }

            if (howManyG == 0) {
                System.out.println("you're out of guesses.");
            }

            System.out.println("Do you want to play Guess The Number, again y/n");
            playAgain = userInputScanner.nextLine();
            howManyG = 3;

            if (playAgain.equals("n")) {
                System.out.println("Good bye, loser!");
            }
        }

    }

    public static String EvaluateGuess(int theGuess, int numberToGuess){

        String message;

        if(theGuess > numberToGuess) {

            message = "That's too high!!";


        }
        else if(theGuess < numberToGuess){

            message = "That's too low!!";


        }
        else {
            message = "you guessed correctly.";

        }

        return message;
    }
 }





