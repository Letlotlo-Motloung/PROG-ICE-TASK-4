import javax.swing.JOptionPane;

class Student {
    private String studentName;
    private String studentSurname;
    private int studentNumber;

   
    public Student(String studentName, String studentSurname, int studentNumber) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentNumber = studentNumber;
    }

   
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
}

class Sales {
    private double studentBalance;
    private Student studentDetails;

   
    public Sales(int studentNumber, String studentName, String studentSurname, boolean isAlumni) {
        this.studentDetails = new Student(studentName, studentSurname, studentNumber);
        this.studentBalance = isAlumni ? 3500.0 : 5000.0;
    }

    // Method to display the main menu
    public void displayMenu() {
        int option;
        do {
            String input = JOptionPane.showInputDialog(null, "Select Option:\n1. Make a Purchase\n2. Recharge the Account\n3. Exit");
            option = input != null ? Integer.parseInt(input) : 3;
            switch (option) {
                case 1:
                    purchaseItem();
                    break;
                case 2:
                    rechargeAmount();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting. Thank you!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Incorrect input. Please choose a valid option.");
            }
        } while (option != 3);
    }

    // Method to handle item purchases
    public void purchaseItem() {
        String[] items = {"Cap", "T-shirt", "Laptop", "Jersey", "Bottle", "Jacket", "Power Bank"};
        double[] prices = {150.0, 200.0, 4500.0, 600.0, 25.0, 750.0, 450.0};
        StringBuilder itemsMenu = new StringBuilder("Items to buy:\n");
        for (int i = 0; i < items.length; i++) {
            itemsMenu.append(i + 1).append(". ").append(items[i]).append(" R").append(prices[i]).append("\n");
        }
        int itemNumber = Integer.parseInt(JOptionPane.showInputDialog(null, itemsMenu.toString()));
        if (itemNumber > 0 && itemNumber <= items.length) {
            double itemPrice = prices[itemNumber - 1];
            if (studentBalance >= itemPrice) {
                studentBalance -= itemPrice;
                JOptionPane.showMessageDialog(null, "Purchase successful! New balance: R" + studentBalance);
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient balance.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid item number.");
        }
    }

    // Method to handle account recharges
    public void rechargeAmount() {
        double rechargeAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to recharge: R"));
        studentBalance += rechargeAmount;
        JOptionPane.showMessageDialog(null, "Recharge successful! New balance: R" + studentBalance);
    }
}

public class UniversityShopMain {
    public static void main(String[] args) {
        String studentName = JOptionPane.showInputDialog(null, "Enter student name:");
        String studentSurname = JOptionPane.showInputDialog(null, "Enter student surname:");
        int studentNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter student number:"));
        int isAlumniResponse = JOptionPane.showConfirmDialog(null, "Are you an alumni?", "Alumni Confirmation", JOptionPane.YES_NO_OPTION);
        boolean isAlumni = (isAlumniResponse == JOptionPane.YES_OPTION);

        Sales sales = new Sales(studentNumber, studentName, studentSurname, isAlumni);
        sales.displayMenu();
    }
}
