

/* ITO AY GINAWA NG ISANG TAO LAMANG SANA HINDI SCORE-AN SI ATIENZA */




import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Font;
public class LoginUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    private static Map<String, String> registeredUsers = new HashMap<>();

    public LoginUI() {
        setTitle("Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);


       JLabel l = new JLabel("Login UI");
        l.setFont(new Font("Arial Black", Font.ITALIC, 30));
        l.setBounds(130, 10,200, 45);
        panel.add(l);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(70, 60, 80, 25);
        panel.add(userLabel);   

        usernameField = new JTextField(20);
        usernameField.setBounds(150, 60, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(70, 100, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 100, 165, 25);
        panel.add(passwordField);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 150, 80, 25);
        panel.add(loginButton);

        JLabel sign = new JLabel("No Account yet? Register now.");
        sign.setBounds(180, 180, 200, 25);
        panel.add(sign);
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(200, 150, 100, 25);
        panel.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1 = usernameField.getText();
                String pass1 = new String(passwordField.getPassword());

                if (isValidLogin(name1, pass1)) {
                    JOptionPane.showMessageDialog(null, "Welcome   " + name1 + "!");
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect credentials, Try again.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new RegisterUI(LoginUI.this); 
            }
        });
    }

    private boolean isValidLogin(String username, String password) {
        return registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginUI();
            }
        });
    }

    public static void addRegisteredUser(String username, String password) {
        registeredUsers.put(username, password);
    }

    public boolean isUsernameRegistered(String username) {
        return registeredUsers.containsKey(username);
    }
}

class RegisterUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    private LoginUI loginUI;

    public RegisterUI(LoginUI loginUI) {
        this.loginUI = loginUI; 

        setTitle("Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(70,50, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(150, 50, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(70, 100, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 100, 165, 25);
        panel.add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(70, 150, 120, 25);
        panel.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setBounds(180, 150, 135, 25);
        panel.add(confirmPasswordField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 200, 100, 25);
        panel.add(registerButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 200, 100, 25);
        panel.add(cancelButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = usernameField.getText();
                String pass = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (isValidRegistration(name, pass, confirmPassword)) {
                    LoginUI.addRegisteredUser(name, pass); 
                    JOptionPane.showMessageDialog(null, "Registration Successful" + "Welcome" + name + "!");
                    dispose(); 
                    loginUI.setVisible(true); 
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid registration details");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                loginUI.setVisible(true); 
            }
        });
    }

    private boolean isValidRegistration(String name, String pass, String pass2) {
        
        return !name.isEmpty() && !pass.isEmpty() && pass.equals(pass2) && !loginUI.isUsernameRegistered(name);
    }
}