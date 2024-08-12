/*
About::
-------
In this project, you will build a program that automates cinema theatre management. You will utilize key Java concepts, including working with input/output operations, handling arrays, creating functions, and using loops and conditional statements.

Description
The theatre is getting popular, and the customers started complaining that it's not practical that the program stops after buying one ticket. Let's add a menu that will allow them to buy tickets and display the current state of the seating arrangement when needed.

Objectives
At the start, your program should read two positive integer numbers that represent the number of rows and seats in each row. Then, it should print a menu with the following three items:

Show the seats should print the current seating arrangement. The empty seats should be marked with an S symbol, and taken seats are marked with a B symbol.
Buy a ticket should read the seat coordinates from the input and print the ticket price like in the previous stage. After that, the chosen seat should be marked with a B when the item Show the seats is called.
Exit should stop the program.
Example
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Enter the number of rows:
> 7
Enter the number of seats in each row:
> 7

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S S S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 4
Enter a seat number in that row:
> 5
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 6
Enter a seat number in that row:
> 6
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S B S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 0
*/

package cinema;

import java.util.Scanner;

public class Cinema {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of rows:");
    int noOfRows = sc.nextInt();
    System.out.println("Enter the number of seats in each row:");
    int noOfSeatsInEachRow = sc.nextInt();

    String[][] seats = new String[noOfRows][noOfSeatsInEachRow];
    initializeSeats(seats);

    while (true) {
      System.out.println("\n1. Show the seats\n2. Buy a ticket\n0. Exit");
      int chosenOptionFromMenu = sc.nextInt();

      if (chosenOptionFromMenu == 1) {
        // Show the seats
        printSeatDetails(noOfSeatsInEachRow, noOfRows, seats);
      } else if (chosenOptionFromMenu == 2) {
        // Buy a ticket
        System.out.println("\nEnter a row number:");
        int rowNum = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = sc.nextInt();

        // Calculate ticket price
        int ticketPrice = calculateTicketPrice(noOfRows, noOfSeatsInEachRow, rowNum);
        System.out.println("Ticket price: $" + ticketPrice + "\n");

        // Mark the selected seat
        seats[rowNum - 1][seatNumber - 1] = "B";
      } else if (chosenOptionFromMenu == 0) {
        // Exit
        break;
      }
    }
  }

  private static void initializeSeats(String[][] seats) {
    for (int row = 0; row < seats.length; row++) {
      for (int seat = 0; seat < seats[row].length; seat++) {
        seats[row][seat] = "S";
      }
    }
  }

  private static void printSeatDetails(int noOfSeatsInEachRow, int noOfRows, String[][] seats) {
    System.out.println("\nCinema:");
    System.out.print("  ");
    for (int i = 1; i <= noOfSeatsInEachRow; i++) {
      System.out.print(i + " ");
    }
    System.out.println();

    for (int row = 0; row < noOfRows; row++) {
      System.out.print((row + 1) + " ");
      for (int seat = 0; seat < noOfSeatsInEachRow; seat++) {
        System.out.print(seats[row][seat] + " ");
      }
      System.out.println();
    }
  }

  private static int calculateTicketPrice(int noOfRows, int noOfSeatsInEachRow, int rowNum) {
    int totalSeats = noOfRows * noOfSeatsInEachRow;

    if (totalSeats <= 60) {
      return 10;
    } else {
      int frontHalf = noOfRows / 2;
      if (rowNum <= frontHalf) {
        return 10;
      } else {
        return 8;
      }
    }
  }
}

/* 2nd updated solution::
----------------------------
*/
package cinema;

import java.util.Scanner;

class CinemaHall {
  private int rows;
  private int seatsPerRow;
  private String[][] seats;

  public CinemaHall(int rows, int seatsPerRow) {
    this.rows = rows;
    this.seatsPerRow = seatsPerRow;
    this.seats = new String[rows][seatsPerRow];
    initializeSeats();
  }

  private void initializeSeats() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < seatsPerRow; j++) {
        seats[i][j] = "S";
      }
    }
  }

  public void showSeats() {
    System.out.println("\nCinema:");
    System.out.print("  ");
    for (int i = 1; i <= seatsPerRow; i++) {
      System.out.print(i + " ");
    }
    System.out.println();

    for (int i = 0; i < rows; i++) {
      System.out.print((i + 1) + " ");
      for (int j = 0; j < seatsPerRow; j++) {
        System.out.print(seats[i][j] + " ");
      }
      System.out.println();
    }
  }

  public int calculateTicketPrice(int rowNum) {
    int totalSeats = rows * seatsPerRow;
    if (totalSeats <= 60) {
      return 10;
    } else {
      int frontHalf = rows / 2;
      if (rowNum <= frontHalf) {
        return 10;
      } else {
        return 8;
      }
    }
  }

  public boolean bookSeat(int rowNum, int seatNum) {
    if (seats[rowNum - 1][seatNum - 1].equals("B")) {
      System.out.println("That ticket has already been purchased!");
      return false;
    } else {
      seats[rowNum - 1][seatNum - 1] = "B";
      return true;
    }
  }
}

class CinemaApp {
  private CinemaHall cinemaHall;
  private Scanner scanner;

  public CinemaApp(int rows, int seatsPerRow) {
    this.cinemaHall = new CinemaHall(rows, seatsPerRow);
    this.scanner = new Scanner(System.in);
  }

  public void start() {
    while (true) {
      showMenu();
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          cinemaHall.showSeats();
          break;
        case 2:
          buyTicket();
          break;
        case 0:
          System.out.println("Exiting...");
          return;
        default:
          System.out.println("Invalid option. Please try again.");
      }
    }
  }

  private void showMenu() {
    System.out.println("\n1. Show the seats\n2. Buy a ticket\n0. Exit");
  }

  private void buyTicket() {
    System.out.println("Enter a row number:");
    int rowNum = scanner.nextInt();
    System.out.println("Enter a seat number in that row:");
    int seatNum = scanner.nextInt();

    if (cinemaHall.bookSeat(rowNum, seatNum)) {
      int price = cinemaHall.calculateTicketPrice(rowNum);
      System.out.println("Ticket price: $" + price);
    }
  }
}

public class Cinema {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of rows:");
    int rows = sc.nextInt();
    System.out.println("Enter the number of seats in each row:");
    int seatsPerRow = sc.nextInt();

    CinemaApp cinemaApp = new CinemaApp(rows, seatsPerRow);
    cinemaApp.start();
  }
}







/*Problem description:::
Description
Running a cinema theatre is no easy business. To help our friends, let's add statistics to your program. The stats will show the current income, total income, the number of available seats, and the percentage of occupancy.

In addition, our friends asked you to take care of a small inconvenience: it's not good when a user can buy a ticket that has already been purchased by another user. Let's fix this!

Objectives
Now your menu should look like this:

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit

When the item Statistics is chosen, your program should print the following information:

The number of purchased tickets;
The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
Current income;
The total income that shows how much money the theatre will get if all the tickets are sold.
The rest of the menu items should work the same way as before, except the item Buy a ticket shouldn't allow a user to buy a ticket that has already been purchased.

If a user chooses an already taken seat, print That ticket has already been purchased! and ask them to enter different seat coordinates until they pick an available seat. Of course, you shouldn't allow coordinates that are out of bounds. If this happens, print Wrong input! and ask to enter different seat coordinates until the user picks an available seat.

Examples
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Enter the number of rows:
> 6
Enter the number of seats in each row:
> 6

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 0
Percentage: 0.00%
Current income: $0
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
> 1
Enter a seat number in that row:
> 1

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 1
Percentage: 2.78%
Current income: $10
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
> 1
Enter a seat number in that row:
> 1

That ticket has already been purchased!

Enter a row number:
> 10
Enter a seat number in that row:
> 20

Wrong input!

Enter a row number:
> 4
Enter a seat number in that row:
> 4

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 1

Cinema:
  1 2 3 4 5 6
1 B S S S S S
2 S S S S S S
3 S S S S S S
4 S S S B S S
5 S S S S S S
6 S S S S S S

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 2
Percentage: 5.56%
Current income: $20
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 0

*/

package cinema;

import java.util.Scanner;

class CinemaHall {
  private final int rows;
  private final int seatsPerRow;
  private final String[][] seats;
  private int numberOfPurchasedTickets = 0;
  private int currentIncome = 0;
  private final int totalIncome;

  public CinemaHall(int rows, int seatsPerRow) {
    this.rows = rows;
    this.seatsPerRow = seatsPerRow;
    this.seats = new String[rows][seatsPerRow];
    this.totalIncome = calculateTotalIncome();
    initializeSeats();
  }

  private void initializeSeats() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < seatsPerRow; j++) {
        seats[i][j] = "S";
      }
    }
  }

  public void showSeats() {
    System.out.println("\nCinema:");
    System.out.print("  ");
    for (int i = 1; i <= seatsPerRow; i++) {
      System.out.print(i + " ");
    }
    System.out.println();

    for (int i = 0; i < rows; i++) {
      System.out.print((i + 1) + " ");
      for (int j = 0; j < seatsPerRow; j++) {
        System.out.print(seats[i][j] + " ");
      }
      System.out.println();
    }
  }

  private int calculateTicketPrice(int rowNum) {
    int totalSeats = rows * seatsPerRow;
    if (totalSeats <= 60) {
      return 10;
    } else {
      int frontHalf = rows / 2;
      return rowNum <= frontHalf ? 10 : 8;
    }
  }

  private int calculateTotalIncome() {
    int income = 0;
    int totalSeats = rows * seatsPerRow;
    if (totalSeats <= 60) {
      income = totalSeats * 10;
    } else {
      int frontHalf = rows / 2;
      int backHalf = rows - frontHalf;
      income = (frontHalf * seatsPerRow * 10) + (backHalf * seatsPerRow * 8);
    }
    return income;
  }

  public void showStatistics() {
    double percentage = (double) numberOfPurchasedTickets / (rows * seatsPerRow) * 100;
    System.out.printf("Number of purchased tickets: %d%n", numberOfPurchasedTickets);
    System.out.printf("Percentage: %.2f%%%n", percentage);
    System.out.printf("Current income: $%d%n", currentIncome);
    System.out.printf("Total income: $%d%n", totalIncome);
  }

  public boolean bookSeat(int rowNum, int seatNum) {
    if (rowNum < 1 || rowNum > rows || seatNum < 1 || seatNum > seatsPerRow) {
      System.out.println("Wrong input!");
      return false;
    }
    if (seats[rowNum - 1][seatNum - 1].equals("B")) {
      System.out.println("That ticket has already been purchased!");
      return false;
    } else {
      seats[rowNum - 1][seatNum - 1] = "B";
      int price = calculateTicketPrice(rowNum);
      currentIncome += price;
      numberOfPurchasedTickets++;
      System.out.println("Ticket price: $" + price);
      return true;
    }
  }
}

class CinemaApp {
  private final CinemaHall cinemaHall;
  private final Scanner scanner;

  public CinemaApp(int rows, int seatsPerRow) {
    this.cinemaHall = new CinemaHall(rows, seatsPerRow);
    this.scanner = new Scanner(System.in);
  }

  public void start() {
    while (true) {
      showMenu();
      int choice = scanner.nextInt();
      switch (choice) {
        case 1 -> cinemaHall.showSeats();
        case 2 -> buyTicket();
        case 3 -> cinemaHall.showStatistics();
        case 0 -> {
          System.out.println("Exiting...");
          return;
        }
        default -> System.out.println("Invalid option. Please try again.");
      }
    }
  }

  private void showMenu() {
    System.out.println("\n1. Show the seats");
    System.out.println("2. Buy a ticket");
    System.out.println("3. Statistics");
    System.out.println("0. Exit");
  }

  private void buyTicket() {
    while (true) {
      System.out.println("Enter a row number:");
      int rowNum = scanner.nextInt();
      System.out.println("Enter a seat number in that row:");
      int seatNum = scanner.nextInt();
      if (cinemaHall.bookSeat(rowNum, seatNum)) {
        break;
      }
    }
  }
}

public class Cinema {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of rows:");
    int rows = sc.nextInt();
    System.out.println("Enter the number of seats in each row:");
    int seatsPerRow = sc.nextInt();

    CinemaApp cinemaApp = new CinemaApp(rows, seatsPerRow);
    cinemaApp.start();
  }
}
