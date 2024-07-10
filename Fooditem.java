import java.util.Scanner;

class FoodItem {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private FoodItem[] items;
    private int itemCount;

    public Order() {
        items = new FoodItem[10];  // Adjust the size based on the maximum items per order
        itemCount = 0;
    }

    public void addItem(FoodItem item) {
        items[itemCount++] = item;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Your Order:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i].getName() + "\t$" + items[i].getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

class FoodOrderingSystem {
    private FoodItem[] breakfastMenu;
    private FoodItem[] dinnerMenu;
    private FoodItem[] appetizerMenu;
    private FoodItem[] drinksMenu;
    private Order currentOrder;

    public FoodOrderingSystem() {
        breakfastMenu = new FoodItem[]{
                new FoodItem("Pandesal", 2.99),
                new FoodItem("Tapsilog", 8.99),
                // Add more breakfast items as needed
        };
        dinnerMenu = new FoodItem[]{
                new FoodItem("Adobo", 9.99),
                new FoodItem("Sinigang", 8.99),
                // Add more dinner items as needed
        };
        appetizerMenu = new FoodItem[]{
                new FoodItem("Calamari", 6.99),
                new FoodItem("Cheese Sticks", 4.99),
                // Add more appetizers as needed
        };
        drinksMenu = new FoodItem[]{
                new FoodItem("Mango Shake", 3.99),
                new FoodItem("Buko Juice", 2.99),
                // Add more drinks as needed
        };

        currentOrder = new Order();
    }

    public void displayMenu(FoodItem[] menu, String category) {
        System.out.println("\n" + category + " Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i].getName() + "\t$" + menu[i].getPrice());
        }
    }

    public void displayOptions() {
        System.out.println("\nOptions:");
        System.out.println("1. Breakfast Menu");
        System.out.println("2. Dinner Menu");
        System.out.println("3. Appetizer Menu");
        System.out.println("4. Drinks Menu");
        System.out.println("5. Place Order");
        System.out.println("6. Exit");
    }

    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            displayOptions();
            System.out.println("Select an option:");

            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        displayMenu(breakfastMenu, "Breakfast");
                        break;
                    case 2:
                        displayMenu(dinnerMenu, "Dinner");
                        break;
                    case 3:
                        displayMenu(appetizerMenu, "Appetizer");
                        break;
                    case 4:
                        displayMenu(drinksMenu, "Drinks");
                        break;
                    case 5:
                        takeOrder();
                        break;
                    case 6:
                        System.out.println("Exiting. Thank you!");
                        return;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid option.");
            }
        } while (true);
    }

    private void takeOrder() {
        System.out.println("Enter the item number you want to order (or type 'done' to finish):");
        displayEntireMenu();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int itemNumber = Integer.parseInt(input) - 1;

                if (itemNumber >= 0 && itemNumber < getTotalMenuSize()) {
                    FoodItem selectedItem = getFoodItemByNumber(itemNumber);
                    currentOrder.addItem(selectedItem);
                    System.out.println(selectedItem.getName() + " added to your order.");
                } else {
                    System.out.println("Invalid item number. Please choose a valid item from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid item number.");
            }
        }

        System.out.println("Order placed successfully!");
        currentOrder.displayOrder();
    }

    private void displayEntireMenu() {
        System.out.println("\nEntire Menu:");
        displayMenu(breakfastMenu, "Breakfast");
        displayMenu(dinnerMenu, "Dinner");
        displayMenu(appetizerMenu, "Appetizer");
        displayMenu(drinksMenu, "Drinks");
    }

    private int getTotalMenuSize() {
        return breakfastMenu.length + dinnerMenu.length + appetizerMenu.length + drinksMenu.length;
    }

    private FoodItem getFoodItemByNumber(int itemNumber) {
        if (itemNumber < breakfastMenu.length) {
            return breakfastMenu[itemNumber];
        } else if (itemNumber < breakfastMenu.length + dinnerMenu.length) {
            return dinnerMenu[itemNumber - breakfastMenu.length];
        } else if (itemNumber < breakfastMenu.length + dinnerMenu.length + appetizerMenu.length) {
            return appetizerMenu[itemNumber - breakfastMenu.length - dinnerMenu.length];
        } else {
            return drinksMenu[itemNumber - breakfastMenu.length - dinnerMenu.length - appetizerMenu.length];
        }
    }

    public static void main(String[] args) {
        FoodOrderingSystem orderingSystem = new FoodOrderingSystem();
        orderingSystem.placeOrder();
    }
}
