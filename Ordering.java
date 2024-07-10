
import java.util.Scanner;
public class Ordering {
    
    public static Scanner input = new Scanner(System.in);
    public static String again;
    public static int choose,quantity=1;
    public static double total=0,pay;
    public static void menu(){
    System.out.println("\t\t\t\t+===================================+");
    System.out.println("\t\t\t\t           TAPSIHAN MENU          ");
    System.out.println("\t\t\t\t   1. Tapsilog             Php. 45.00");
    System.out.println("\t\t\t\t   2. Tocilog              Php. 40.00");
    System.out.println("\t\t\t\t   3. Longsilog            Php. 35.00");
    System.out.println("\t\t\t\t   4. CANCEL                         ");
    System.out.println("\t\t\t\t+====================================+");
    }
    
    public static void order(){
    System.out.println("Press 1 to Tapsilog , Press 2 to Tocilog , Press 3 to Longsilog and Press 4 to Cancel");
    System.out.print("Press you want to buy? :");
    choose = input.nextInt();
    //conditions
    if(choose==1){
        System.out.println("You choose Tapsilog");
        System.out.print("How many Tapsilog you want to Buy? :");
        quantity =input.nextInt();
        total = total +(quantity*45);
        
        System.out.println("You want to buy again? ");
        System.out.println("Press Y for Yes and N for N : ");
        again = input.next();
        if(again.equalsIgnoreCase("Y")){
            order();
        }else{
            System.out.println("Enter a payment ");
            pay = input.nextDouble();
            if(pay <=total){
              System.out.println("Not enough payment");
            }else{
            System.out.println("Total price is " + total);
            total = pay-total;
            System.out.println("The change is " + total);
            }
        }
    }else if(choose==2){
        System.out.println("You choose Tocilog");
        System.out.print("How many Tocilog you want to Buy? :");
        quantity =input.nextInt();
        total = total +(quantity*40);
        
        System.out.println("You want to buy again? ");
        System.out.println("Press Y for Yes and N for N : ");
        again = input.next();
        if(again.equalsIgnoreCase("Y")){
            order();//call the method you to create 
        }else{
            System.out.println("Enter a payment ");
            pay = input.nextDouble();
            if(pay <=total){
              System.out.println("Not enough payment");
            }else{
            System.out.println("Total price is " + total);
            total = pay-total;
            System.out.println("The change is " + total);
            }
        }
      }else if(choose==3){
        System.out.println("You choose Longsilog");
        System.out.print("How many Longsilog you want to Buy? :");
        quantity =input.nextInt();
        total = total +(quantity*30);
        
        System.out.println("You want to buy again? ");
        System.out.println("Press Y for Yes and N for N : ");
        again = input.next();
        if(again.equalsIgnoreCase("Y")){
            order();//call the method you to create 
        }else{
            System.out.println("Enter a payment ");
            pay = input.nextDouble();
            if(pay <=total){
              System.out.println("Not enough payment");
            }else{
            System.out.println("Total price is " + total);
            total = pay-total;
            System.out.println("The change is " + total);
            }
        }
    }else if(choose==4){
        System.exit(0);//close program
    }else{
        System.out.println("Choose 1 to 4 only!");
        order();
    }
    }
    public static void main(String[] args) {
       menu();
       order();
    } 
}
