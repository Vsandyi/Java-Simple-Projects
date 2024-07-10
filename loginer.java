import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginer extends JFrame implements ActionListener {

    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;

    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create labels
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        // Create text fields
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        // Create buttons
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");

        // Add action listeners to buttons
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Add components to frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(cancelButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Validate user credentials and perform actions
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Here, you can validate the username and password against a database or other source
            if (username.equals("user") && password.equals("password")) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Perform desired actions after successful login
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            }
        } else if (e.getSource() == cancelButton) {
            System.exit(0);
        }
    }
}
public static void main(String[] args) {
    new LoginForm();
}

