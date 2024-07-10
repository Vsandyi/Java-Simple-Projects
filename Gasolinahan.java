
import java.util.Scanner;

class Gasolinahan {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Select your fuel:");
    System.out.println("1. Premium (Big Bike)");
    System.out.println("2. Unleaded");
    System.out.println("3. Diesel");
    System.out.println("4. Exit");
    System.out.print("Enter your choice: ");

    int choice = scanner.nextInt();

    double capacity = 0.0;
    double fuelLevel = 0.0;
    double pricePerLiter = 0.0;
    int choice2 = 0;

    boolean exitProgram = false;

    switch (choice) {
      // =============PREMIUM================================================================//
      case 1:
        pricePerLiter = 61.50;
        capacity = 12.0;

        while (!exitProgram) {
          System.out.println("Gasoline System Menu:");
          System.out.println("1. Fill Gasoline");
          System.out.println("2. Check fuel level");
          System.out.println("3. Exit");
          System.out.print("Enter your choice: ");
          choice2 = scanner.nextInt();
          switch (choice2) {
            case 1:
              System.out.print("Enter the amount: ");
              double amount1 = scanner.nextDouble();
              double liter1 = amount1 / pricePerLiter;
              if (amount1 <= 0) {
                System.out.println("\nInvalid input.\n");
              } else if (fuelLevel + liter1 > capacity) {
                System.out.println("\nTank capacity exceeded. Cannot fill beyond " + capacity + " liters\n");
              } else {
                fuelLevel += liter1;
                System.out.println("\nGasoline filled: " + liter1 + " liters\n");
              }
              break;

            case 2:
              System.out.println("\nCurrent Fuel Level: " + fuelLevel + " liters\n");
              break;

            case 3:
              System.out.println("\nExiting Gasoline System. Goodbye!\n");
              exitProgram = true;
              break;

            default:
              System.out.println("\nInvalid choice. Please enter a valid option.\n");
          }
        }
        break;

      // =============UNLEADED================================================================//
      case 2:
        pricePerLiter = 61.00;
        capacity = 4.0;

        while (!exitProgram) {
          System.out.println("Gasoline System Menu:");
          System.out.println("1. Fill Gasoline");
          System.out.println("2. Check fuel level");
          System.out.println("3. Exit");
          System.out.print("Enter your choice: ");
          choice2 = scanner.nextInt();
          switch (choice2) {
            case 1:
              System.out.print("Enter the amount of gasoline to fill: ");
              double amount2 = scanner.nextDouble();
              double liter2 = amount2 / pricePerLiter;
              if (amount2 <= 0) {
                System.out.println("\nInvalid input.\n");
              } else if (fuelLevel + liter2 > capacity) {
                System.out.println("\nTank capacity exceeded. Cannot fill beyond " + capacity + " liters\n");
              } else {
                fuelLevel += liter2;
                System.out.println("\nGasoline filled: " + liter2 + " liters\n");
              }
              break;

            case 2:
              System.out.println("\nCurrent Fuel Level: " + fuelLevel + " liters\n");
              break;

            case 3:
              System.out.println("\nExiting Gasoline System. Goodbye!\n");
              exitProgram = true;
              break;

            default:
              System.out.println("\nInvalid choice. Please enter a valid option.\n");
          }
        }
        break;

      // =============DIESEL================================================================//
      case 3:
        pricePerLiter = 58.90;
        capacity = 100.0;

        while (!exitProgram) {
          System.out.println("Gasoline System Menu:");
          System.out.println("1. Fill Gasoline");
          System.out.println("2. Check fuel level");
          System.out.println("3. Exit");
	System.out.print("Enter your choice: ");
          choice2 = scanner.nextInt();
          switch (choice2) {
            case 1:
              System.out.print("Enter the amount of gasoline to fill: ");
              double amount3 = scanner.nextDouble();
              double liter3 = amount3 / pricePerLiter;
              if (amount3 <= 0) {
                System.out.println("Invalid input.");
              } else if (amount3 < 300) {
                System.out.println("\nAno ka motor?\nGasoline filled " + capacity + " liters\n");
              }else if (fuelLevel + liter3 > capacity) {
                System.out.println("\nTank capacity exceeded. Cannot fill beyond " + capacity + " liters\n");
              } else {
                fuelLevel += liter3;
                System.out.println("\nGasoline filled: " + liter3 + " liters\n");
              }
              break;

            case 2:
              System.out.println("\nCurrent Fuel Level: " + fuelLevel + " liters\n");
              break;

            case 3:
              System.out.println("\nExiting Gasoline System. Goodbye!\n");
              exitProgram = true;
              break;

            default:
              System.out.println("\nInvalid choice. Please enter a valid option.\n");
          }
        }
        break;

}}}