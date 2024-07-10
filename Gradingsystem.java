import javax.swing.JOptionPane;
import java.util.InputMismatchException;
import java.util.Scanner;

class Gradingsystem {
 
    public static void main(String[] args) {
         
        Scanner scan = new Scanner(System.in);
        String name;   
        float ave;

        try {
            System.out.println("Enter your name: ");
            name = scan.nextLine();

            System.out.println("Enter your Grades: ");
            ave = scan.nextFloat();

            if (ave >= 90) {
                JOptionPane.showMessageDialog(null, "Excellent Performance " + name + "!");
            } else if (ave >= 80 && ave <= 89) {
                JOptionPane.showMessageDialog(null, "Good Performance " + name + "!");
            } else if (ave >= 70 && ave <= 79) {
                JOptionPane.showMessageDialog(null, "Fair Performance " + name + "!");
            } else if (ave < 70) {
                JOptionPane.showMessageDialog(null, "Bad Performance You Failed " + name + "!");
            } else {
                JOptionPane.showMessageDialog(null, "Hi " + name + ", You entered a wrong option!");
            }
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "You entered a non-numeric value for grades!");
        }
    }
}
