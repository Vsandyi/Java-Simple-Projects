import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Babe extends JFrame {
    private DefaultListModel<String> selectedItemsModel;

    public Babe() {
        setTitle("Food Ordering System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        selectedItemsModel = new DefaultListModel<>();
        JList<String> selectedItemsList = new JList<>(selectedItemsModel);
        JScrollPane selectedItemsScrollPane = new JScrollPane(selectedItemsList);

        JComboBox<String> menuComboBox = new JComboBox<>(new String[]{"Burger", "Pizza", "Pasta", "Salad"});
        JButton addButton = new JButton("Add to Order");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) menuComboBox.getSelectedItem();
                if (selectedItem != null) {
                    selectedItemsModel.addElement(selectedItem);
                }
            }
        });

        JButton confirmOrderButton = new JButton("Confirm Order");
        confirmOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder orderSummary = new StringBuilder("Your order:\n");
                for (int i = 0; i < selectedItemsModel.size(); i++) {
                    orderSummary.append(i + 1).append(". ").append(selectedItemsModel.getElementAt(i)).append("\n");
                }
                JOptionPane.showMessageDialog(Babe.this, orderSummary.toString(), "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(menuComboBox);
        panel.add(addButton);
        panel.add(confirmOrderButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);
        container.add(selectedItemsScrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FoodOrderingSystem();
            }
        });
    }
}
