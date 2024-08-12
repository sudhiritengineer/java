/*Requirements:
---------------
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
    int no_of_rows = sc.nextInt();
    System.out.println("Enter the number of seats in each row:");
    int no_of_seats_in_each_row = sc.nextInt();

    String[][] seats = new String[no_of_rows][no_of_seats_in_each_row];
    initialize_seats(seats);

    while (true) {
      System.out.println("\n1. Show the seats\n2. Buy a ticket\n0. Exit");
      int chosen_option_from_menu = sc.nextInt();

      switch (chosen_option_from_menu) {
        case 1:
          // Show the seats
          print_seat_details(no_of_seats_in_each_row, no_of_rows, seats);
          break;

        case 2:
          // Buy a ticket
          System.out.println("\nEnter a row number:");
          int row_num = sc.nextInt();
          System.out.println("Enter a seat number in that row:");
          int seat_number = sc.nextInt();

          // Calculate ticket price
          int ticket_price = calculate_ticket_price(no_of_rows, no_of_seats_in_each_row, row_num);
          System.out.println("Ticket price: $" + ticket_price + "\n");

          // Mark the selected seat
          seats[row_num - 1][seat_number - 1] = "B";
          break;

        case 0:
          // Exit
          return;

        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
    }
  }

  private static void initialize_seats(String[][] seats) {
    for (int row = 0; row < seats.length; row++) {
      for (int seat = 0; seat < seats[row].length; seat++) {
        seats[row][seat] = "S";
      }
    }
  }

  private static void print_seat_details(int no_of_seats_in_each_row, int no_of_rows, String[][] seats) {
    System.out.println("\nCinema:");
    System.out.print("  ");
    for (int i = 1; i <= no_of_seats_in_each_row; i++) {
      System.out.print(i + " ");
    }
    System.out.println();

    for (int row = 0; row < no_of_rows; row++) {
      System.out.print((row + 1) + " ");
      for (int seat = 0; seat < no_of_seats_in_each_row; seat++) {
        System.out.print(seats[row][seat] + " ");
      }
      System.out.println();
    }
  }

  private static int calculate_ticket_price(int no_of_rows, int no_of_seats_in_each_row, int row_num) {
    int total_seats = no_of_rows * no_of_seats_in_each_row;

    if (total_seats <= 60) {
      return 10;
    } else {
      int front_half = no_of_rows / 2;
      if (row_num <= front_half) {
        return 10;
      } else {
        return 8;
      }
    }
  }
}


/*
Above example by using Oops concept:
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
