import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;

    public class Aga extends JFrame implements ActionListener {

    JLabel l, db, l1, nl, l2, m1, lrice,lDrinks,lDessert,lTotalSales, cntLabel;
    JCheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18, cb19, cb20,cb21;
    JSpinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10, spinner11, spinner12, spinner13,    spinner14, spinner15, spinner16, spinner17, spinner18, spinner19, spinner20,spinner21;
    JButton b, c, withdrawButton;

    private int quantitySold1, quantitySold2, quantitySold3, quantitySold4, quantitySold5,
        quantitySold6, quantitySold7, quantitySold8, quantitySold9, quantitySold10,
        quantitySold11, quantitySold12, quantitySold13, quantitySold14, quantitySold15,
        quantitySold16, quantitySold17, quantitySold18, quantitySold19, quantitySold20, quantitySold21;

    int cnt = 0;
    float totalAmount = 0;
    float totalSales = 0;

    Aga() {
        l = new JLabel("Karinderya Ordering System");
        l.setFont(new Font("Arial Black", Font.PLAIN, 20));
        l.setBounds(115, 15,440, 25);
        add(l);
        l1 = new JLabel(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _  _ _  _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        l1.setBounds(0, 40, 500, 20);
        add(l1);
       

        m1 = new JLabel("Food Menu Along with its price:");
        m1.setFont(new Font("Arial Black", Font.PLAIN, 12));
        m1.setBounds(10, 60, 300, 20);
        add(m1);

        cb1 = new JCheckBox("Pork Menudo(₱50.00)");
        cb1.setBounds(15, 90, 160, 20);
        add(cb1);

        spinner1 = new JSpinner();
        spinner1.setBounds(195, 90, 50, 20);
        add(spinner1);

        cb2 = new JCheckBox("Fried Chicken(₱30.00)");

        cb2.setBounds(15, 120, 160, 20);
        add(cb2);

        spinner2 = new JSpinner();
        spinner2.setBounds(195, 120, 50, 20);
        add(spinner2);

        cb3 = new JCheckBox("Chicken Adobo(₱50.00)");
        cb3.setBounds(15, 150, 160, 20);
        add(cb3);
        spinner3 = new JSpinner();
        spinner3.setBounds(195, 150, 50, 20);
        add(spinner3);

        cb4 = new JCheckBox("Dinuguan (₱50.00)");
        cb4.setBounds(15, 180, 160, 20);
        add(cb4);
        spinner4 = new JSpinner();
        spinner4.setBounds(195, 180, 50, 20);
        add(spinner4);

        cb5 = new JCheckBox("BistekTagalog(₱60.00)");
        cb5.setBounds(15, 210, 160, 20);
        add(cb5);
        spinner5 = new JSpinner();
        spinner5.setBounds(195, 210, 50, 20);
        add(spinner5);

        cb6 = new JCheckBox("TinolangManok(₱50.00)");
        cb6.setBounds(15, 240, 160, 20);
        add(cb6);
        spinner6 = new JSpinner();
        spinner6.setBounds(195, 240, 50, 20);
        add(spinner6);

        cb7 = new JCheckBox("LechonPaksiw(₱75.00)");
        cb7.setBounds(15, 270, 160, 20);
        add(cb7);
        spinner7 = new JSpinner();
        spinner7.setBounds(195, 270, 50, 20);
        add(spinner7);

        cb8 = new JCheckBox("Pork Sinigang (₱60.00)");
        cb8.setBounds(15, 300, 160, 20);
        add(cb8);
        spinner8 = new JSpinner();
        spinner8.setBounds(195, 300, 50, 20);
        add(spinner8);

        cb9 = new JCheckBox("Pinakbet (₱40.00)");
        cb9.setBounds(15, 330, 160, 20);
        add(cb9);
        spinner9 = new JSpinner();
        spinner9.setBounds(195, 330, 50, 20);
        add(spinner9);

        cb10 = new JCheckBox("Bicol Express (₱40.00)");
        cb10.setBounds(15, 360, 160, 20);
        add(cb10);
        spinner10 = new JSpinner();
        spinner10.setBounds(195, 360, 50, 20);
        add(spinner10);


        lDessert = new JLabel("Dessert Menu Along with its price:");
        lDessert.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lDessert.setBounds(280, 60, 500, 20);
        add(lDessert);

        cb11 = new JCheckBox("Halo-Halo (₱25.00)");
        cb11.setBounds(290, 80, 150, 20);
        add(cb11);
        spinner11 = new JSpinner();
        spinner11.setBounds(450, 80, 50, 20);
        add(spinner11);

        cb12 = new JCheckBox("Leche Flan (₱40.00)");
        cb12.setBounds(290, 100, 150, 20);
        add(cb12);
        spinner12 = new JSpinner();
        spinner12.setBounds(450, 100, 50, 20);
        add(spinner12);

        cb13 = new JCheckBox("Mango Float (₱50.00)");
        cb13.setBounds(290, 120, 150, 20);
        add(cb13);
        spinner13 = new JSpinner();
        spinner13.setBounds(450, 120, 50, 20);
        add(spinner13);

        lDrinks = new JLabel("Drinks Menu Along with its price:");
        lDrinks.setFont(new Font("Arial Black", Font.PLAIN, 12));;
        lDrinks.setBounds(280, 250, 250, 20);
        add(lDrinks);


        cb14 = new JCheckBox("Coke (₱20.00)");
        cb14.setBounds(290, 270, 160, 20);
        add(cb14);
 
        spinner14 = new JSpinner();
        spinner14.setBounds(450, 270, 50, 20);
        add(spinner14);

        cb15 = new JCheckBox("Iced Tea (₱15.00)");
        cb15.setBounds(290, 290, 160, 20);
        add(cb15);

        spinner15 = new JSpinner();
        spinner15.setBounds(450, 290, 50, 20);
        add(spinner15);

        cb16 = new JCheckBox("Royal (₱20.00)");
        cb16.setBounds(290, 310, 160, 20);
        add(cb16);

        spinner16 = new JSpinner();
        spinner16.setBounds(450, 310, 50, 20);
        add(spinner16);

        cb17 = new JCheckBox("Mountain Dew (₱20.00)");
        cb17.setBounds(290, 330, 160, 20);
        add(cb17);

        spinner17 = new JSpinner();
        spinner17.setBounds(450, 330, 50, 20);
        add(spinner17);

        cb18 = new JCheckBox("Mineral Water (₱10.00)");
        cb18.setBounds(290, 350, 160, 20);
        add(cb18);

        spinner18 = new JSpinner();
        spinner18.setBounds(450, 350, 50, 20);
        add(spinner18);

        lrice = new JLabel("Rice Menu Along with its price:");
        lrice.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lrice.setBounds(280, 150, 250, 20);
        add(lrice);
 
        cb19 = new JCheckBox("Plain Rice (₱10.00)");
        cb19.setBounds(290, 170, 160, 20);
        add(cb19);

        spinner19 = new JSpinner();
        spinner19.setBounds(450, 170, 50, 20);
        add(spinner19);

        cb20 = new JCheckBox("Java Rice (₱10.00)");
        cb20.setBounds(290, 190, 150, 20);
        add(cb20);

        spinner20 = new JSpinner();
        spinner20.setBounds(450, 190, 50, 20);
        add(spinner20);

        cb21 = new JCheckBox("Garlic Rice (₱15.00)");
        cb21.setBounds(290, 210, 150, 20);
        add(cb21);

        spinner21 = new JSpinner();
        spinner21.setBounds(450, 210, 50, 20);
        add(spinner21);


        withdrawButton = new JButton("Sales");
        withdrawButton.setBounds(5, 440, 70, 25);
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withdrawTotalSales();
            }
        });
        add(withdrawButton);
 

       b = new JButton("Submit Order");
        b.setBounds(200, 400, 120, 30);
        b.addActionListener(this);
        add(b);

        c = new JButton("Exit");
        c.setBounds(390, 440, 120, 25);
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });
        add(c);

        cntLabel = new JLabel("Orders Completed: " + cnt);
        cntLabel.setBounds(15, 410, 150, 20);
        add(cntLabel);

         lTotalSales = new JLabel();
        add(lTotalSales);

        l2 = new JLabel("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        l2.setBounds(0, 420, 800, 20); 
        add(l2);
        setSize(600, 550);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
    public void actionPerformed(ActionEvent e) {
        float amount = 0;
        String msg = "";

           
        if (spinner1.getValue().equals(0) && spinner2.getValue().equals(0) && spinner3.getValue().equals(0) &&
                spinner4.getValue().equals(0) && spinner5.getValue().equals(0) && spinner6.getValue().equals(0) &&
                spinner7.getValue().equals(0) && spinner8.getValue().equals(0) && spinner9.getValue().equals(0) &&
                spinner10.getValue().equals(0) && spinner11.getValue().equals(0) && spinner12.getValue().equals(0) &&
                spinner13.getValue().equals(0) && spinner14.getValue().equals(0) && spinner15.getValue().equals(0) &&
                spinner16.getValue().equals(0) && spinner17.getValue().equals(0) && spinner18.getValue().equals(0) && spinner19.getValue().equals(0) && spinner20.getValue().equals(0) && spinner21.getValue().equals(0)) {

            JOptionPane.showMessageDialog(this, "Invalid choice. Please choose at least one quantity.", "Invalid Choice", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if ((int) spinner1.getValue() < 0 || (int) spinner2.getValue() < 0 || (int) spinner3.getValue() < 0 ||
        (int) spinner4.getValue() < 0 || (int) spinner5.getValue() < 0 || (int) spinner6.getValue() < 0 ||
        (int) spinner7.getValue() < 0 || (int) spinner8.getValue() < 0 || (int) spinner9.getValue() < 0 ||
        (int) spinner10.getValue() < 0 || (int) spinner11.getValue() < 0 || (int) spinner12.getValue() < 0 ||
        (int) spinner13.getValue() < 0 || (int) spinner14.getValue() < 0 || (int) spinner15.getValue() < 0 ||
        (int) spinner16.getValue() < 0 || (int) spinner17.getValue() < 0 || (int) spinner18.getValue() < 0 ||
        (int) spinner19.getValue() < 0 || (int) spinner20.getValue() < 0 || (int) spinner21.getValue() < 0) {

        JOptionPane.showMessageDialog(this, "Invalid choice. Quantity cannot be negative.", "Invalid Choice", JOptionPane.WARNING_MESSAGE);
        return;
    }
     if (!cb1.isSelected() && !cb2.isSelected() && !cb3.isSelected() && !cb4.isSelected() && !cb5.isSelected() &&
        !cb6.isSelected() && !cb7.isSelected() && !cb8.isSelected() && !cb9.isSelected() && !cb10.isSelected() &&
        !cb11.isSelected() && !cb12.isSelected() && !cb13.isSelected() && !cb14.isSelected() && !cb15.isSelected() &&
        !cb16.isSelected() && !cb17.isSelected() && !cb18.isSelected() && !cb19.isSelected() && !cb20.isSelected() && !cb21.isSelected()) {

        JOptionPane.showMessageDialog(this, "Please select at least one item before proceeding to payment.", "No Item Selected", JOptionPane.WARNING_MESSAGE);
        return;
    }

        if (cb1.isSelected()) {
            int quantity = (int) spinner1.getValue();
            amount += 50 * quantity;
            msg += "Pork Menudo: ₱50  x  Qty." + quantity + "  =  ₱ " + (50 * quantity) + "\n";
            quantitySold1 += quantity;
            msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";

        }

        if (cb2.isSelected()) {
            int quantity = (int) spinner2.getValue();
            amount += 30 * quantity;
            msg += "Fried Chicken: ₱30  x  Qty." + quantity + "  =  ₱ " + (30 * quantity) + "\n";
            quantitySold2 += quantity;
            msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
        }

        if (cb3.isSelected()) {
            int quantity = (int) spinner3.getValue();
             amount += 50 * quantity;
             msg += "Chicken Adobo: ₱50 x Qty." + quantity + " =  ₱ " + (50 * quantity) + "\n";
             quantitySold3 += quantity;
              msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}

        if (cb4.isSelected()) {
              int quantity = (int) spinner4.getValue();
              amount += 50 * quantity;
              msg += "Dinuguan: ₱50 x Qty." + quantity + " = ₱" + (50 * quantity) + "\n";
              quantitySold4 += quantity;
              msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}

        if (cb5.isSelected()) {
              int quantity = (int) spinner5.getValue();
              amount += 60 * quantity;
              quantitySold5 += quantity;
              msg += "Bistek Tagalog: ₱60 x Qty." + quantity + " = ₱" + (60 * quantity) + "\n";
               msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}

        if (cb6.isSelected()) {
             int quantity = (int) spinner6.getValue();
             amount += 50 * quantity;
             quantitySold6 += quantity;
             msg += "Tinolang Manok: ₱50 x Qty." + quantity + " = ₱" + (50 * quantity) + "\n";
             msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}

        if (cb7.isSelected()) {
             int quantity = (int) spinner7.getValue();
             amount += 75 * quantity;
             quantitySold7 += quantity;
             msg += "Lechon Paksiw: ₱75 x Qty." + quantity + " = ₱" + (75 * quantity) + "\n";
              msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}

        if (cb8.isSelected()) {
             int quantity = (int) spinner8.getValue();
             amount += 60 * quantity;
             quantitySold8 += quantity;
             msg += "Pork Sinigang: ₱60 x Qty." + quantity + " = ₱" + (60 * quantity) + "\n";
             msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}

        if (cb9.isSelected()) {
             int quantity = (int) spinner9.getValue();
            amount += 40 * quantity;
            quantitySold9 += quantity;
             msg += "Pinakbet: ₱40 x Qty." + quantity + " = ₱" + (40 * quantity) + "\n";
             msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}

        if (cb10.isSelected()) {
            int quantity = (int) spinner10.getValue();
             amount += 60 * quantity;
             quantitySold10 += quantity;
            msg += "Bicol Express : ₱60 x Qty." + quantity + " = ₱" + (60 * quantity) + "\n";
             msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}

        if (cb11.isSelected()) {
         int quantity = (int) spinner11.getValue();
             amount += 50 * quantity;
             quantitySold11 += quantity;
             msg += "Halo-Halo: ₱50 x Qty." + quantity + " = ₱" + (50 * quantity) + "\n";
              msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
          }

         if (cb12.isSelected()) {
          int quantity = (int) spinner12.getValue();
             amount += 40 * quantity;
             quantitySold12 += quantity;
             msg += "Leche Flan: ₱40 x Qty." + quantity + " = ₱" + (40 * quantity) + "\n";
              msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}


         if (cb13.isSelected()) {
          int quantity = (int) spinner13.getValue();
          amount += 50 * quantity;
          quantitySold13 += quantity;
          msg += "Mango Float: ₱50 x Qty." + quantity + " = ₱" + (50 * quantity) + "\n";
           msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}

        if (cb14.isSelected()) {
         int quantity = (int) spinner14.getValue();
         amount += 20 * quantity;
         quantitySold14 += quantity;
         msg += "Coke: ₱20 x Qty." + quantity + " = ₱" + (20 * quantity) + "\n";
          msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}


        if (cb15.isSelected()) {
         int quantity = (int) spinner15.getValue();
         amount += 15 * quantity;
         quantitySold15 += quantity;
         msg += "Iced Tea: ₱15 x Qty." + quantity + " = ₱" + (15 * quantity) + "\n";
          msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";}

       if (cb16.isSelected()) {
         int quantity = (int) spinner16.getValue();
         amount += 20 * quantity;
         quantitySold16 += quantity;
         msg += "Royal: ₱20 x Qty." + quantity + " = ₱" + (20 * quantity) + "\n";
          msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";}

       if (cb17.isSelected()) {
        int quantity = (int) spinner17.getValue();
        amount += 20 * quantity;
        quantitySold17 += quantity;
        msg += "MountainDew: ₱20 x Qty." + quantity + " = ₱" + (20 * quantity) + "\n";
         msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}
       if (cb18.isSelected()) {
        int quantity = (int) spinner18.getValue();
        amount += 10 * quantity;
        quantitySold18 += quantity;
        msg += "Water: ₱10 x Qty." + quantity + " = ₱" + (10 * quantity) + "\n";
         msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}
      if (cb19.isSelected()) {
        int quantity = (int) spinner19.getValue();
        amount += 10 * quantity;
        quantitySold19 += quantity;
        msg += "Plain Rice: ₱10  x  Qty." + quantity + "  =  ₱ "  + (10 * quantity) + "\n";
         msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
    }

     if (cb20.isSelected()) {
        int quantity = (int) spinner20.getValue();
        amount += 15 * quantity;
        quantitySold20 += quantity;
        msg += "Java Rice: ₱15 x  Qty." + quantity + "  =  ₱ " + (15 * quantity) + "\n";
            msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
 }
      if (cb21.isSelected()) {
        int quantity = (int) spinner21.getValue();
        amount += 15 * quantity;
        quantitySold21 += quantity;
        msg += "Garlic Rice: ₱15 x  Qty." + quantity + "  =  ₱ " + (15 * quantity) + "\n";
        msg += "- - - - - - - - - - - - - - - - - - - - - - - - \n";
}

    
    int dineInOption = JOptionPane.showConfirmDialog(this, "Dine-in or Takeout?", "  Yes if Dine in No if Tak eout. ", JOptionPane.YES_NO_OPTION);
    int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to submit the order?\nTotal Amount: ₱" + amount, "Confirmation", JOptionPane.YES_NO_OPTION);

    


    if (confirmation == JOptionPane.YES_OPTION) {
        
       
        
        msg += "Total: ₱" + amount + "\n";
          msg += "- - - - - - - - - - - - - - - - -\n";
         if (dineInOption == JOptionPane.YES_OPTION) {
        msg += "Dine-in\n";
    } else {
        msg += "Takeout\n";
    }
             msg += "-  -  -  -  -  -  -  -  -\n";
        String paymentInput = JOptionPane.showInputDialog(this, msg + "Enter payment:");

        if (paymentInput != null && !paymentInput.isEmpty()) {
            try {
                float payment = Float.parseFloat(paymentInput);

                if (payment >= amount) {
                    float change = payment - amount;
                    msg += "-  -  -  -  -  -  -  -  -\n";
                    msg += "Payment: ₱" + payment + "\n";
                    msg += "- - - - - - - - - - - - - - - \n";
                    msg += "Change: ₱" + change + "\n";

                   
                    totalAmount += amount;
                    totalSales += amount;

                   
                    cnt++;
                    cntLabel.setText("Orders Completed: " + cnt);

                  
                    JTextArea textArea = new JTextArea(msg);
                    textArea.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(textArea);

                    JOptionPane.showMessageDialog(this, scrollPane, "Your Order Summary", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient funds. Add more.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number for payment.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Order canceled.");
        }
    }
}



     private static void exitSystem() {
        JOptionPane.showMessageDialog(null, "         System Shutdown.\n        Have a Great Day!");
        System.exit(0);
    }

 private void withdrawTotalSales() {
      String user = "admin";
            String pass = "password";
                
                JPanel panel = new JPanel();
                JLabel labelUsername = new JLabel("Username:");
                JTextField usernameField = new JTextField(10);
                JLabel labelPassword = new JLabel("Password:");
                JPasswordField passwordField = new JPasswordField(10);

            panel.add(labelUsername);
            panel.add(usernameField);
            panel.add(labelPassword);
            panel.add(passwordField);

            int option = JOptionPane.showConfirmDialog(this, panel, "Admin Login", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                String enteredUsername = usernameField.getText();
                String enteredPassword = new String(passwordField.getPassword());
        if (enteredUsername.equals(user) && enteredPassword.equals(pass)) 
  {
            

            String soldItemsDisplay = "Items Sold:\n";
    soldItemsDisplay += "Pork Menudo: " + quantitySold1 + "Qty\n";
    soldItemsDisplay += "Fried Chicken: " + quantitySold2 + "Qty\n";
    soldItemsDisplay += "Chicken Adobo: " + quantitySold3 + "Qty\n";
    soldItemsDisplay += "Dinuguan: " + quantitySold4 + "Qty\n";
    soldItemsDisplay += "BistekTagalog: " + quantitySold5 + "Qty\n";
    soldItemsDisplay += "Tinolang Manok: " + quantitySold6 + "Qty\n";
    soldItemsDisplay += "Lechon Paksiw: " + quantitySold7 + "Qty\n";
    soldItemsDisplay += "Pork Sinigang: " + quantitySold8 + "Qty\n";
    soldItemsDisplay += "Pinakbet: " + quantitySold9 + "Qty\n";
    soldItemsDisplay += "Bicol Express: " + quantitySold10 + "Qty\n";
    soldItemsDisplay += "Halo-Halo: " + quantitySold11 + "Qty\n";
    soldItemsDisplay += "Leche Plan: " + quantitySold12 + "Qty\n";
    soldItemsDisplay += "Mango Float: " + quantitySold13 + "Qty\n";
    soldItemsDisplay += "Coke: " + quantitySold14 + "Qty\n";
    soldItemsDisplay += "Iced Tea: " + quantitySold15 + "Qty\n";
    soldItemsDisplay += "MountainDew: " + quantitySold16 + "Qty\n";
    soldItemsDisplay += "Royal: " + quantitySold17 + "Qty\n";
    soldItemsDisplay += "Water: " + quantitySold18 + "Qty\n";
    soldItemsDisplay += "Plain Rice: " + quantitySold19 + "Qty\n";
    soldItemsDisplay += "Java Rice: " + quantitySold20 + "Qty\n";
    soldItemsDisplay += "GarlicRice: " + quantitySold21 + "Qty\n";


    JOptionPane.showMessageDialog(this, "Total Sales: ₱" + totalSales + "\n\n" + soldItemsDisplay);

        } 
        else {
            JOptionPane.showMessageDialog(this, "Invalid username or password. Access denied.");
        }

    }

}



  public static void main(String[] args) {
 
JOptionPane.showMessageDialog(null, "Welcome to the future of convenient dining with the Karinderya Ordering System!\n");
  new Aga();

 
   }

}