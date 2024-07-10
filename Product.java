import javax.swing.JOptionPane;
import java.util.Scanner;
 class Product {

    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int age; 
     String o = "";
      System.out.print("Enter you age!");
      age = scan.nextInt();
    o = scan.nextLine();

    if(age<17){  
    
    System.out.println("Bata Drinks :");
    System.out.println("A.Milo                      B.Yakult");
   System.out.println("C.Chucky              D.Gatas");
   System.out.println("Pumi ka kaibigan :");
  o = scan.nextLine();
if(o.equalsIgnoreCase("a")){
 System.out.print("Milo Everyday!");
  }
  if(o.equalsIgnoreCase("b")){
 System.out.print("Cr bagsak mo nyan!");
  }
  if(o.equalsIgnoreCase("c")){
 System.out.print("Moooooooooooooooo!");
  }
  if(o.equalsIgnoreCase("d")){
 System.out.print("Pampatibay ng buto!");
  }
  else{
 System.out.print("Wala sa pagpipilian yang kinana mo!");
  }

 }



      else if(age>=18 && age<=30){

   System.out.println("TOMA NA ?");
   System.out.println("A.Alfonso               B.Emeprador");
   System.out.println("C.Ginebra              D.Shembot");
      System.out.println("Pumili ka kaibigan :");
    o = scan.nextLine();
  if(o.equalsIgnoreCase("a")){
 System.out.print("Alfonso coke ang mahusay!");
  }
  if(o.equalsIgnoreCase("b")){
 System.out.print("Mahirap isuka yan!");
  }
  if(o.equalsIgnoreCase("c")){
 System.out.print("Wag magsasagad masakit sa ulo yan!");
  }
  if(o.equalsIgnoreCase("d")){
 System.out.print("Tabang nyan!");
  }
  else{
 System.out.print("Wala sa pagpipilian yang kinana mo!");
  }

  }


else if(age>=31 && age<=100){
    
   System.out.println("Halthy Living na!");
   System.out.println("A.Lola Remedios             B.Tea");
   System.out.println("C.Gatas  ng Kalabaw            D.Soup");
      System.out.println("Pumili ka kaibigan :");
     o = scan.nextLine();
  if(o.equalsIgnoreCase("a")){
 System.out.print("BAKA LAMIG YAN!");
  }
  if(o.equalsIgnoreCase("b")){
 System.out.print("Mainit init pa!");
  }
  if(o.equalsIgnoreCase("c")){
 System.out.print("Pampalakas!");
  }
  if(o.equalsIgnoreCase("d")){
 System.out.print("higop mainit na sabaw!");
  }
  else{
 System.out.print("Wala sa pagpipilian yang kinana mo!");
  }

  }

  else{
     System.out.print("invalid!");

  }



    }
}
