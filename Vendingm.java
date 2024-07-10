import java.util.Scanner;
class Vendingm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int availableBalance = 0;
        int continueChoice;
        do {
            System.out.println("Welcome to the Vending Machine!");
            System.out.println("Please insert money: ");
            int insertedAmount = scanner.nextInt();

            availableBalance += insertedAmount;

            System.out.println("Your current balance is: $" + availableBalance);
            int selection;
            do {
                System.out.println("\nSelect your choice:");

                for (int i = 1; i <= 10; i++) {
                    String productName;
                    int productPrice;

                    switch (i) {
                        case 1:
                            productName = "Cola";
                            productPrice = 20;
                            break;
                        case 2:
                            productName = "Chips";
                            productPrice = 15;
                            break;
                        case 3:
                            productName = "Candy";
                            productPrice = 10;
                            break;
                        case 4:
                            productName = "Water";
                            productPrice = 15;
                            break;
			            case 5:
                            productName = "Energydrink";
                            productPrice = 25;
                            break;
			             case 6:
                            productName = "Chocolatebar";
                            productPrice = 15;
                            break;
			             case 7:
                            productName = "Tea";
                            productPrice = 30;
                            break;
			             case 8:
                            productName = "Gum";
                            productPrice = 2;
                            break;	
			             case 9:
                            productName = "Milk";
                            productPrice = 20;
                            break;
			             case 10:
                            productName = "Coffee";
                            productPrice = 15;
                            break;
                        default:
                            productName = "";
                            productPrice = 0;
                    }

                    System.out.println(i + ". " + productName + " - $" + productPrice);
                }

                 System.out.println("0. Exit");

              
                selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        if (availableBalance < 20) {
                            System.out.println("Insufficient funds, Your Current funds is " + availablebalance + " Please add more money.");
                        } else {
                            availableBalance -= 20;
                            System.out.println("You purchased Cola.");
			   System.out.println("Your current balance is: $" + availableBalance); 
                        }
                        break;
                    case 2:
                        if (availableBalance < 15) {
                              System.out.println("Insufficient funds, Your Current funds is" + availablebalance + " Please add more money.");
                        } else {
                            availableBalance -= 15;
                            System.out.println("You purchased Chips.") ;
			   System.out.println("Your current balance is: $" + availableBalance); 

                        }
                        break;
                    case 3:
                        if (availableBalance < 10) {
                              System.out.println("Insufficient funds, Your Current funds is" + availablebalance + " Please add more money.");
                        } else {
                            availableBalance -= 10;
                            System.out.println("You purchased Candy.");
			   System.out.println("Your current balance is: $" + availableBalance); 
                        }
                        break;
                    case 4:
                        if (availableBalance < 15) {
                             System.out.println("Insufficient funds, Your Current funds is" + availablebalance + " Please add more money.");
                        } else {
                            availableBalance -= 15;
                            System.out.println("You purchased Water.");
			   System.out.println("Your current balance is: $" + availableBalance); 
                        }
                        break;
		     case 5:
                        if (availableBalance < 25) {
                            System.out.println("Insufficient funds, Your Current funds is" + availablebalance + " Please add more money.");
                        } else {
                            availableBalance -= 25;
                            System.out.println("You purchased Energy Drink.");
			   System.out.println("Your current balance is: $" + availableBalance); 

                        }
                        break;
			 case 6:
                        if (availableBalance < 15) {
                          System.out.println("Insufficient funds, Your Current funds is" + availablebalance + " Please add more money.");
                        } else {
                            availableBalance -= 15;
                            System.out.println("You purchased Chocolate Bar.");
			   System.out.println("Your current balance is: $" + availableBalance); 

                      }
                        break;
			 case 7:
                        if (availableBalance < 30) {
                             System.out.println("Insufficient funds, Your Current funds is" + availablebalance + " Please add more money.");
                        } else {
                            availableBalance -= 30;
                            System.out.println("You purchased Tea.");
			   System.out.println("Your current balance is: $" + availableBalance); 

                        }
                        break;
			 case 8:
                        if (availableBalance < 2) {
                             System.out.println("Insufficient funds, Your Current funds is" + availablebalance + " Please add more money.");
                        } else {
                            availableBalance -= 2;
                            System.out.println("You purchased Gum.");
			   System.out.println("Your current balance is: $" + availableBalance); 

                        }
                        break;
			 case 9:
                        if (availableBalance < 20) {
                          System.out.println("Insufficient funds, Your Current funds is" + availablebalance + " Please add more money.");
                        } else {
                            availableBalance -= 20;
                            System.out.println("You purchased Milk.");
			   System.out.println("Your current balance is: $" + availableBalance); 
                        }
                        break;
			 case 10:
                        if (availableBalance < 15) {
                              System.out.println("Insufficient funds, Your Current funds is" + availablebalance + " Please add more money.");
                        } else {
                            availableBalance -= 15;
                            System.out.println("You purchased Coffee.");
			   System.out.println("Your current balance is: $" + availableBalance); 
                        }
                        break;
                    default:
                        System.out.println("Invalid selection. Please choose from the available options.");
                }
            } while (selection != 0);
            System.out.println("\nDo you want to continue shopping? (1 for yes, 0 for no): ");
            continueChoice = scanner.nextInt();        


        } while (continueChoice == 1);
         System.out.println("Thank you for using the Vending Machine!");
         System.out.println("Your refundable balance is: $" + availableBalance);
        
       
    }
}
