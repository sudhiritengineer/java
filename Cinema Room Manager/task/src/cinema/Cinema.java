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
