import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelManagementSystem {

    private static final String ADMIN_PASSWORD = "jello123";
    private static final double[] RATES_PER_HOUR = {10.0, 15.0, 5.0};
    private static final double[] RATES_PER_DAY = {80.0, 120.0, 50.0};
    private static final int NUM_ROOMS_PER_TYPE = 10;

    private static Map<Integer, String> roomTypes = new HashMap<>();
    private static Map<Integer, List<Boolean>> roomAvailability = new HashMap<>();
    private static Map<Integer, List<GuestInfo>> checkInInfo = new HashMap<>();

    private static JFrame frame;
    private static JTextArea adminTextArea;

    public static void main(String[] args) {
 	JOptionPane.showMessageDialog(null, "Welcome to Hotel Management System!");
        initializeRoomData();

        frame = new JFrame("Hotel Management System");

        JButton checkInButton = new JButton("Check-in");
	    JButton checkOutButton = new JButton("Check-out");
        JButton displayRoomTypesButton = new JButton("Display Room Types");
        JButton checkRoomAvailabilityButton = new JButton("Check Room Availability");
        JButton adminLoginButton = new JButton("Admin Login");
        JButton exitButton = new JButton("Exit");
        

        adminTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(adminTextArea);

        checkInButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                checkIn();
            }
        });

        displayRoomTypesButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                displayRoomTypes();
		
            }
        });

        checkRoomAvailabilityButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                checkRoomAvailability();
            }
        });

        adminLoginButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                adminLogin();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });

        checkOutButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
		checkOut();
               
            }
        });

        JPanel panel = new JPanel();
        panel.add(checkInButton);
	    panel.add(checkOutButton);
 	    panel.add(adminLoginButton);
        panel.add(displayRoomTypesButton);
        panel.add(checkRoomAvailabilityButton);
        panel.add(exitButton);
        

        frame.add(panel);
        frame.add(scrollPane);
        frame.setSize(400, 300);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void initializeRoomData() {
        roomTypes.put(1, " VIP");
        roomTypes.put(2, " Deluxe");
        roomTypes.put(3, " Simple");

        for (int i = 1; i <= roomTypes.size(); i++) {
            List<Boolean> rooms = new ArrayList<>(Collections.nCopies(NUM_ROOMS_PER_TYPE, true));
            roomAvailability.put(i, rooms);
            checkInInfo.put(i, new ArrayList<>());
        }
    }

    private static void checkIn() {
	JOptionPane.showMessageDialog(null, "     Hi, Ma'm/Sir!");
	JOptionPane.showMessageDialog(null, "Thank you for Choosing our Hotel!");
        boolean roomSelected = false;

        while (!roomSelected) {
           
            int roomType = Integer.parseInt(JOptionPane.showInputDialog("Select room type:\n 1. VIP\n 2. Deluxe\n 3. Simple"));

            List<Boolean> rooms = roomAvailability.get(roomType);

            String[] roomOptions = new String[NUM_ROOMS_PER_TYPE];
            for (int i = 0; i < NUM_ROOMS_PER_TYPE; i++) {
                roomOptions[i] = "Room " + (i + 1) + (rooms.get(i) ? " (Available)" : " (Occupied)");
            }

            String selectedRoom = (String) JOptionPane.showInputDialog(null, "Choose a room:",
                    "Room Selection", JOptionPane.QUESTION_MESSAGE, null, roomOptions, roomOptions[0]);

            if (selectedRoom != null) {
                int roomIndex = Integer.parseInt(selectedRoom.split(" ")[1]) - 1;

                if (rooms.get(roomIndex)) {
                    String guestName = JOptionPane.showInputDialog("Enter your name:");
                    int guestAge = Integer.parseInt(JOptionPane.showInputDialog("Enter your age:"));

                    if (guestAge < 18 ) {
                        JOptionPane.showMessageDialog(null, "Sorry, guests below 18 years old are not allowed to check in.");
                        return;
                    }
                    else if (guestAge >= 90){
                        JOptionPane.showMessageDialog(null, "Matanda kana para magcheck in!");
                    }

                    int days = Integer.parseInt(JOptionPane.showInputDialog("Enter duration of stay(days) :"));

                    double ratePerDays;
                    if (roomType == 1) {  // VIP
                        ratePerDays = 2999.0;
                    } else if (roomType == 2) {  // Deluxe
                        ratePerDays = 1999.0;
                    } else {  // Simple
                        ratePerDays = 999.0;
                    }

                    double totalCost = ratePerDays * days;

                    // Loop for payment
                    boolean paymentSuccess = false;
                    while (!paymentSuccess) {
                        double amountPaid = Double.parseDouble(JOptionPane.showInputDialog("Enter payment amount (PHP):"));

                        if (amountPaid < totalCost) {
                            JOptionPane.showMessageDialog(null, "Insufficient payment. Please provide the correct amount.");
                        } else {
                            double change = amountPaid - totalCost;
                            JOptionPane.showMessageDialog(null, "Change: PHP " + change);
                            paymentSuccess = true;
                        }
                    }

                    rooms.set(roomIndex, false);
                    Date checkInTime = new Date();
                    checkInInfo.get(roomType).add(new GuestInfo(guestName, guestAge, roomIndex + 1, checkInTime));

                    JOptionPane.showMessageDialog(null, "Check-in successful, " + guestName +
                            "! Enjoy your stay in Room " + (roomIndex + 1) + "!");
                    roomSelected = true;  // Break out of the loop
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, the selected room is occupied. Please choose another room.");
                }
            } else {
                // User canceled the room selection
                return;
            }
        }
    }

    private static void displayRoomTypes() {
        StringBuilder roomInfo = new StringBuilder("Room Types:\n");
        roomTypes.forEach((key, value) -> roomInfo.append(key).append(". ").append(value).append("\n"));
        JOptionPane.showMessageDialog(null, roomInfo.toString());
    }

    private static void checkRoomAvailability() {
        StringBuilder availabilityInfo = new StringBuilder("Room Availability:\n");

        for (Map.Entry<Integer, String> entry : roomTypes.entrySet()) {
            int roomType = entry.getKey();
            List<Boolean> rooms = roomAvailability.get(roomType);

            availabilityInfo.append(entry.getValue()).append(":\n");
            for (int i = 0; i < rooms.size(); i++) {
                availabilityInfo.append("   Room ").append(i + 1).append(": ").append(rooms.get(i) ? "Available" : "Occupied").append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, availabilityInfo.toString());
    }

    private static void adminLogin() {
        String password = JOptionPane.showInputDialog("Enter admin password:");
        if (password != null && password.equals(ADMIN_PASSWORD)) {
            showCheckInInformation();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect password. Access denied.");
        }
    }

    private static void showCheckInInformation() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder checkInInfoText = new StringBuilder("Check-in Information:\n");

        for (Map.Entry<Integer, List<GuestInfo>> entry : checkInInfo.entrySet()) {
            int roomType = entry.getKey();
            List<GuestInfo> guests = entry.getValue();

            checkInInfoText.append(roomTypes.get(roomType)).append(":\n");
            for (GuestInfo guestInfo : guests) {
                checkInInfoText.append("   Room Number: ").append(guestInfo.roomNumber).append("\n")
                        .append("   Guest Name: ").append(guestInfo.name).append("\n")
                        .append("   Guest Age: ").append(guestInfo.age).append("\n")
                        .append("   Check-in Time: ").append(dateFormat.format(guestInfo.checkInTime)).append("\n\n");
            }
        }

        adminTextArea.setText(checkInInfoText.toString());
    }

    private static void checkOut() {
	
        int roomType = Integer.parseInt(JOptionPane.showInputDialog("Select room type:\n 1. VIP\n 2. Deluxe\n 3. Simple"));

        List<GuestInfo> guests = checkInInfo.get(roomType);

        if (guests.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No guests currently checked in for the selected room type.");
            return;
        }

        // Display the list of guests and their room numbers
        StringBuilder guestInfoText = new StringBuilder("Guests Checked In:\n");
        for (int i = 0; i < guests.size(); i++) {
            guestInfoText.append(i + 1).append("\n Room Number - ").append(guests.get(i).roomNumber)
                    .append("\n Guest Name : ").append(guests.get(i).name).append("\n\n");
        }

        int roomNumberToCheckOut = Integer.parseInt(JOptionPane.showInputDialog(null, guestInfoText.toString()
                + "Enter the room number to check out:"));

        boolean foundGuest = false;
        for (GuestInfo guest : guests) {
            if (guest.roomNumber == roomNumberToCheckOut) {
                foundGuest = true;
                guests.remove(guest);

                // Update room availability
                roomAvailability.get(roomType).set(roomNumberToCheckOut - 1, true);

                JOptionPane.showMessageDialog(null, "Thank you for choosing Hotel Management System. Please come again.");
                break;
            }
        }

        if (!foundGuest) {
            JOptionPane.showMessageDialog(null, "No guest found with the specified room number.");
        }
    }

    private static void exitSystem() {
        JOptionPane.showMessageDialog(null, "Thank you for using Hotel Management System.\n                            Goodbye!");
        System.exit(0);
    }

    private static class GuestInfo {
        String name;
        int age;
        int roomNumber;
        Date checkInTime;
        Date checkOutTime;  // New field for checkout time

        GuestInfo(String name, int age, int roomNumber, Date checkInTime) {
            this.name = name;
            this.age = age;
            this.roomNumber = roomNumber;
            this.checkInTime = checkInTime;
        }
    }
}
