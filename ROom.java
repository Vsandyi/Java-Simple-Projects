import java.util.ArrayList;
import java.util.List;

class Room {
    private int roomNumber;
    private String type;
    private boolean isBooked;

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom() {
        isBooked = true;
    }

    public void unbookRoom() {
        isBooked = false;
    }
}

class Hotel {
    private List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
        // Initialize rooms
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
        // Add more rooms as needed
    }

    public boolean bookRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isBooked()) {
                room.bookRoom();
                return true;
            }
        }
        return false;
    }

    public boolean unbookRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isBooked()) {
                room.unbookRoom();
                return true;
            }
        }
        return false;
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println("Room Number: " + room.getRoomNumber() + " - Type: " + room.getType());
            }
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        hotel.displayAvailableRooms();

        int roomNumberToBook = 101;
        if (hotel.bookRoom(roomNumberToBook)) {
            System.out.println("Room " + roomNumberToBook + " booked successfully.");
        } else {
            System.out.println("Room " + roomNumberToBook + " is not available.");
        }

        hotel.displayAvailableRooms();

        int roomNumberToUnbook = 101;
        if (hotel.unbookRoom(roomNumberToUnbook)) {
            System.out.println("Room " + roomNumberToUnbook + " unbooked successfully.");
        } else {
            System.out.println("Room " + roomNumberToUnbook + " is not booked.");
        }

        hotel.displayAvailableRooms();
    }
}
