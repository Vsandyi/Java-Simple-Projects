import java.util.Scanner;

class Agasss {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	double rad;
	double n = 3.14159;
 	
	System.out.print("Enter the Radius : ");
	rad = scan.nextDouble();
	

 	double per = (2* rad) * n;
	double area = n * (rad *rad);

	System.out.println("The Perimiter of the numbers is : " + per );
	System.out.println("The Area of the numbers is : " + area );
}
}