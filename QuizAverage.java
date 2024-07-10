import java.util.Scanner;
class QuizAverage{
	public static void main(String[] args){

	Scanner scan = new Scanner (System.in);

	int q1=0,q2=0,q3=0,q4=0,q5=0;
	double ave=0, sum = 0, perfect = 250;




	System.out.print("Enter your Score in Quiz # 1: ");
	q1 = scan.nextInt();
	if(q1 > 50){
		System.out.println("You Entered the Score limit quiz 1 score will be 50");
		q1 = 50;
	}
	System.out.print("Enter your Score in Quiz # 2: ");
	q2 = scan.nextInt();
	if(q2 > 50){
		System.out.println("You Entered the Score limit quiz 2 score will be 50");
		q2 = 50;
	}
	System.out.print("Enter your Score in Quiz # 3: ");
	q3 = scan.nextInt();
	if(q3 > 50){
		System.out.println("You Entered the Score limit quiz 3 score will be 50");
		q3 = 50;
	}
	System.out.print("Enter your Score in Quiz # 4: ");
	q4 = scan.nextInt();
	if(q4 > 50){
		System.out.println("You Entered the Score limit quiz 4 score will be 50");
		q4 = 50;
	}
	System.out.print("Enter your Score in Quiz # 5: ");
	q5 = scan.nextInt();
	if(q5 > 50){
		System.out.println("You Entered the Score limit quiz 5 score will be 50");
		q5 = 50;
	}


	sum = q1+q2+q3+q4+q5;
	ave = (sum / perfect) * 100;

	if(ave < 75){
		System.out.println("Your Average is: " + ave + "- Failed");
	}else if(ave >= 75 && ave <=80){
		System.out.println("Your Average is: " + ave + "- Fair");
	}else if(ave >= 81 && ave <=90){
		System.out.println("Your Average is: " + ave + "- Good");
	}else if(ave >= 91 && ave <=100){
		System.out.println("Your Average is: " + ave + "- Excellent");
	}

	}
}