package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numberOfPencils = 0;

    // Input validation for the number of pencils
    System.out.println("How many pencils would you like to use:");
    while (true) {
      String pencilsInput = sc.nextLine();
      try {
        numberOfPencils = Integer.parseInt(pencilsInput);
        if (numberOfPencils > 0) {
          break;
        } else {
          System.out.println("The number of pencils should be positive");
        }
      } catch (NumberFormatException e) {
        System.out.println("The number of pencils should be numeric");
      }
    }

    // Input validation for the first player
    String currentPlayer;
    System.out.println("Who will be the first (John, Jack):");
    while (true) {
      currentPlayer = sc.nextLine();
      if (currentPlayer.equals("John") || currentPlayer.equals("Jack")) {
        break;
      } else {
        System.out.println("Choose between 'John' and 'Jack'");
      }
    }

    // Main game loop
    while (numberOfPencils > 0) {
      // Print the current state of pencils
      System.out.println("|".repeat(numberOfPencils));

      // Print whose turn it is
      System.out.printf("%s's turn!\n", currentPlayer);

      int pencilsToRemove = 0;
      if (currentPlayer.equals("John")) {
        // Read the number of pencils to remove
        while (true) {
          String removeInput = sc.nextLine();
          try {
            pencilsToRemove = Integer.parseInt(removeInput);
            if (pencilsToRemove >= 1 && pencilsToRemove <= 3) {
              if (pencilsToRemove <= numberOfPencils) {
                break;
              } else {
                System.out.println("Too many pencils were taken");

              }
            } else {
              System.out.println("Possible values: '1', '2' or '3'");

            }
          } catch (NumberFormatException e) {
            System.out.println("Possible values: '1', '2' or '3'");

          }
        }
      } else {
        // Bot's turn
        pencilsToRemove = botMove(numberOfPencils);
        System.out.println(pencilsToRemove);
        System.out.println();
      }

      // Update the number of remaining pencils
      numberOfPencils -= pencilsToRemove;

      // Check if the game is over
      if (numberOfPencils == 0) {
        System.out.printf("%s won!\n", currentPlayer.equals("John") ? "Jack" : "John");
        break;
      }

      // Switch player for the next turn
      currentPlayer = currentPlayer.equals("John") ? "Jack" : "John";
    }
  }

  public static int botMove(int numberOfPencils) {
    if (numberOfPencils % 4 == 0) {
      return 3;
    } else if (numberOfPencils % 4 == 3) {
      return 2;
    } else if (numberOfPencils % 4 == 2) {
      return 1;
    } else {
      Random rand = new Random();
      return rand.nextInt(3) + 1; // Returns a random number between 1 and 3
    }
  }
}


/*
Project requirements:
-----------------------
Description
The game was interesting, but it went sour. No one was playing a fair game! You've taken 10 pencils, your friend decided that it is unfair and somehow took a negative number! Moreover, you both can't decide which of you won. Maybe, it's time to add new rules to the game.

Objectives
In this stage, your task is to add a new level of control over the game. Check the input. If it's incorrect, print the reason why. Also, limit the possible amount of pencils taken. Let's say that players can remove not more than 3 pencils at a time.

Here are possible errors and their feedback:

The initial number of pencils is not a numeric string, so it can't be converted to an integer — The number of pencils should be numeric;

The initial number of pencils is equal to 0 — The number of pencils should be positive;

If the input is a negative amount, apply condition (1), as the minus sign is not a numeric;

If the chosen first player is not *Name1* or *Name2* — Choose between *Name1* and *Name2*;

One of the players has taken the number of pencils that differs from 1, 2, or 3 — Possible values: '1', '2' or '3';

One of the players has taken more pencils than there are on the table — Too many pencils were taken.

If one of the errors occurs, ask for input once again. Please note that when an error occurs, you don't need to print whose turn it is. Just output the error feedback (see the examples below).

Don't forget to help determine the winner of the game. The player who takes the last pencil loses the game. Print out the result at the end of the game with the line *Winner-name* won!

Examples
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Example 1: the initial number of pencils is not numeric

How many pencils would you like to use:
> a
The number of pencils should be numeric
> 5
Who will be the first (John, Jack):
>
Example 2: the initial number of pencils equals 0

How many pencils would you like to use:
> 0
The number of pencils should be positive
> 20
Who will be the first (John, Jack):
>
Example 3: the chosen first player is not in the list

How many pencils would you like to use:
> 5
Who will be the first (John, Jack):
> JohnJack
Choose between 'John' and 'Jack'
> John
|||||
John's turn!
>
Example 4: one of the players has taken the number of pencils that differs from 1, 2, or 3

How many pencils would you like to use:
> 5
Who will be the first (John, Jack):
> John
|||||
John's turn!
> 4
Possible values: '1', '2' or '3'
> 1
||||
Jack's turn!
>
Example 5: the chosen number of pencils is not numeric

How many pencils would you like to use:
> 5
Who will be the first (John, Jack):
> John
|||||
John's turn!
> a
Possible values: '1', '2' or '3'
> 1
||||
Jack's turn!
>

*/