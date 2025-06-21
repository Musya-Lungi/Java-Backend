// Java Console-Based Payroll System for Managing Employee Data
// --------------------------------------------------------------
// Core functionality:
// - Add new employees
// - View all registered employees
// - Calculate gross and net payroll after tax
// --------------------------------------------------------------
// Note: This is a basic prototype using Java fundamentals only (arrays, loops, conditionals)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // === Initialize Scanner for user input ===
        Scanner input = new Scanner(System.in);

        // === Declare fixed-size arrays to store employee records ===
        String[] employeeNames = new String[100];
        int[] employeeIds = new int[100];
        double[] employeeSalaries = new double[100];

        // === Employee counter to keep track of added employees ===
        int employeeCount = 0;

        // === Menu control variable ===
        int choice;

        // === Main menu loop ===
        do {
            System.out.println("\n========= ENTERPRISE PAYROLL SYSTEM =========");
            System.out.println("1. Add New Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Calculate Total Payroll");
            System.out.println("4. Exit System");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    // === Add New Employee ===
                    if (employeeCount < 100) {
                        input.nextLine(); // Consume the leftover newline

                        System.out.print("Enter employee name: ");
                        employeeNames[employeeCount] = input.nextLine();

                        System.out.print("Enter employee ID: ");
                        employeeIds[employeeCount] = input.nextInt();

                        System.out.print("Enter employee salary: ");
                        employeeSalaries[employeeCount] = input.nextDouble();

                        employeeCount++; // Increment employee count
                        System.out.println("✅ Employee added successfully.");
                    } else {
                        System.out.println("❌ Maximum limit of 100 employees reached.");
                    }
                    break;

                case 2:
                    // === View All Employees ===
                    if (employeeCount == 0) {
                        System.out.println("📭 No employee records found.");
                    } else {
                        System.out.println("\n=========== EMPLOYEE LIST ===========");
                        for (int i = 0; i < employeeCount; i++) {
                            System.out.println("Employee #" + (i + 1));
                            System.out.println("Name   : " + employeeNames[i]);
                            System.out.println("ID     : " + employeeIds[i]);
                            System.out.println("Salary : KES " + employeeSalaries[i]);
                            System.out.println("-------------------------------------");
                        }
                    }
                    break;

                case 3:
                    // === Calculate Total Payroll with 10% Tax Deduction ===
                    if (employeeCount == 0) {
                        System.out.println("📭 No employees available to calculate payroll.");
                    } else {
                        double grossPayroll = 0.0;
                        double taxRate = 0.10;
                        double totalTax = 0.0;

                        // Loop through all employees and compute payroll figures
                        for (int j = 0; j < employeeCount; j++) {
                            grossPayroll += employeeSalaries[j];
                            totalTax += employeeSalaries[j] * taxRate;
                        }

                        double netPayroll = grossPayroll - totalTax;

                        // Display payroll summary
                        System.out.println("\n=========== PAYROLL SUMMARY ===========");
                        System.out.println("Total Employees  : " + employeeCount);
                        System.out.println("Gross Payroll    : KES " + grossPayroll);
                        System.out.println("Total Tax (10%)  : KES " + totalTax);
                        System.out.println("Net Payroll Paid : KES " + netPayroll);
                        System.out.println("========================================");
                    }
                    break;

                case 4:
                    // === Exit System ===
                    System.out.println("🔚 Exiting Payroll System. Goodbye!");
                    break;

                default:
                    // === Invalid Menu Option ===
                    System.out.println("⚠️ Invalid choice. Please enter a number between 1 and 4.");
            }

        } while (choice != 4); // End menu loop when user chooses to exit

        // Close the scanner to avoid resource leaks
        input.close();
    }
}
