import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeParseException; // Add this import

class Guest {
    String name;
    int roomNumber;
    LocalDate checkInDate;
    LocalDate checkOutDate;

    public Guest(String name, int roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getStayDuration() {
        return (int) checkInDate.until(checkOutDate).getDays();
    }
}

public class HotelManagementSystem extends JFrame {

    private static ArrayList<Guest> guestList = new ArrayList<>();
    private static boolean[] roomAvailability = new boolean[10]; // Assuming there are 10 rooms

    public HotelManagementSystem() {
        super("Hotel Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        displayRoomAvailability();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JButton checkInButton = new JButton("Check-In");
        JButton displayGuestInfoButton = new JButton("Display Guest Information");
        JButton checkRoomAvailabilityButton = new JButton("Check Room Availability");
        JButton exitButton = new JButton("Exit");

        panel.add(checkInButton);
        panel.add(displayGuestInfoButton);
        panel.add(checkRoomAvailabilityButton);
        panel.add(exitButton);

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIn();
            }
        });

        displayGuestInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayGuestInfo();
            }
        });

        checkRoomAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRoomAvailability();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(panel);
    }

    private void checkIn() {
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField checkInDateField = new JTextField();

        Object[] fields = {
                "Name:", nameField,
                "Age:", ageField,
                "Choose a room number", checkInDateField,
                "Check-In Date (yyyy-MM-dd):",
        };

        JComboBox<Integer> roomNumberComboBox = new JComboBox<>();
        for (int i = 1; i <= 10; i++) {
            if (!roomAvailability[i - 1]) {
                roomNumberComboBox.addItem(i);
            }
        }

        fields[4] = roomNumberComboBox;

        int option = JOptionPane.showConfirmDialog(null, fields, "Check-In", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            int age;
            LocalDate checkInDate;

            try {
                age = Integer.parseInt(ageField.getText());
                checkInDate = LocalDate.parse(checkInDateField.getText());
            } catch (NumberFormatException | DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid date format. Please enter valid date.");
                return;
            }

            if (age < 18) {
                JOptionPane.showMessageDialog(null, "Guests below 18 years old cannot check in.");
                return;
            }

            int selectedRoom = (int) roomNumberComboBox.getSelectedItem();

            // Now you can use the 'name', 'age', 'checkInDate', and 'selectedRoom' variables to create the Guest object
            Guest newGuest = new Guest(name, selectedRoom, checkInDate, checkInDate.plusDays(1));
            guestList.add(newGuest);
            roomAvailability[selectedRoom - 1] = true;

            // Example:
            JOptionPane.showMessageDialog(HotelManagementSystem.this, "Guest checked in successfully to Room " + selectedRoom);
            displayRoomAvailability();
        } else {
            JOptionPane.showMessageDialog(null, "Check-in canceled.");
        }
    }

    private void displayGuestInfo() {
        JTextField roomNumberField = new JTextField();

        Object[] fields = {
                "Room Number:", roomNumberField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Display Guest Information", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            int roomNumber;

            try {
                roomNumber = Integer.parseInt(roomNumberField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid room number. Please enter a valid number.");
                return;
            }

            boolean guestFound = false;

            StringBuilder guestInfo = new StringBuilder();

            for (Guest guest : guestList) {
                if (guest.roomNumber == roomNumber) {
                    guestInfo.append("Guest Name: ").append(guest.name).append("\n");
                    guestInfo.append("Room Number: ").append(guest.roomNumber).append("\n");
                    guestInfo.append("Check-In Date: ").append(guest.checkInDate).append("\n");
                    guestInfo.append("Check-Out Date: ").append(guest.checkOutDate).append("\n");
                    guestInfo.append("Stay Duration: ").append(guest.getStayDuration()).append(" days").append("\n\n");
                    guestFound = true;
                }
            }

            if (guestFound) {
                JOptionPane.showMessageDialog(null, guestInfo.toString(), "Guest Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Guest not found for room number " + roomNumber, "Guest Information", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Guest information display canceled.");
        }
    }

    private void displayRoomAvailability() {
        StringBuilder availabilityInfo = new StringBuilder("Room Availability:\n");

        for (int i = 0; i < roomAvailability.length; i++) {
            availabilityInfo.append("Room ").append(i + 1).append(": ");
            if (roomAvailability[i]) {
                availabilityInfo.append("Occupied");
            } else {
                availabilityInfo.append("Available");
            }
            availabilityInfo.append("\n");
        }

        JOptionPane.showMessageDialog(null, availabilityInfo.toString(), "Room Availability", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HotelManagementSystem().setVisible(true);
            }
        });
    }
}