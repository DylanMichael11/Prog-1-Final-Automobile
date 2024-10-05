package automobile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomobileInventory {
    private List<Automobile> inventory;

    // Constructor to initialize the inventory
    public AutomobileInventory() {
        this.inventory = new ArrayList<>();
    }

    // Method to gather vehicle details from user input
    private Automobile gatherVehicleDetails(Scanner scanner) {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter VIN number: ");
        String vinNumber = scanner.nextLine();

        System.out.print("Enter mileage: ");
        int mileage = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter status (NEW, USED, SOLD): ");
        String statusInput = scanner.nextLine().toUpperCase();
        Automobile.Status status = Automobile.Status.valueOf(statusInput);

        System.out.print("Enter transmission (automatic, manual): ");
        String transmission = scanner.nextLine();

        return new Automobile(make, model, year, color, vinNumber, mileage, price, status, transmission);
    }

    // Method to add a new vehicle based on user input
    public String addVehicleFromInput(Scanner scanner) throws NumberFormatException {
        try {
            Automobile vehicle = gatherVehicleDetails(scanner);
            inventory.add(vehicle);
            return "Vehicle added successfully.";
        } catch (IllegalArgumentException e) {
            return "Failed to add vehicle: Invalid status.";
        } catch (Exception e) {
            return "Failed to add vehicle: " + e.getMessage();
        }
    }

    // Method to remove a vehicle by index
    public String removeVehicle(int index) {
        try {
            if (index < 0 || index >= inventory.size()) {
                return "Invalid index.";
            }
            inventory.remove(index);
            return "Vehicle removed successfully.";
        } catch (Exception e) {
            return "Failed to remove vehicle: " + e.getMessage();
        }
    }

    // Method to list all vehicles in the inventory
    public void listVehicles() {
        if (inventory.isEmpty()) {
            System.out.println("No vehicles in the inventory.");
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println("Index " + i + ": " + inventory.get(i));
            }
        }
    }

    // Method to update a vehicle by index using user input
    public void updateVehicleFromInput(Scanner scanner, int index) throws NumberFormatException {
        if (index < 0 || index >= inventory.size()) {
            System.out.println("Invalid index.");
            return;
        }
        try {
            System.out.print("Enter new make: ");
            String make = scanner.nextLine();

            System.out.print("Enter new model: ");
            String model = scanner.nextLine();

            System.out.print("Enter new year: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter new color: ");
            String color = scanner.nextLine();

            System.out.print("Enter new VIN number: ");
            String vinNumber = scanner.nextLine();

            System.out.print("Enter new mileage: ");
            int mileage = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter new price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter new status (NEW, USED, SOLD): ");
            String statusInput = scanner.nextLine().toUpperCase();
            Automobile.Status status = Automobile.Status.valueOf(statusInput);

            System.out.print("Enter new transmission (automatic, manual): ");
            String transmission = scanner.nextLine();

            // Update the vehicle at the given index
            inventory.get(index).setMake(make);
            inventory.get(index).setModel(model);
            inventory.get(index).setYear(year);
            inventory.get(index).setColor(color);
            inventory.get(index).setVinNumber(vinNumber);
            inventory.get(index).setMileage(mileage);
            inventory.get(index).setPrice(price);
            inventory.get(index).setStatus(status);
            inventory.get(index).setTransmission(transmission);

            System.out.println("Vehicle updated successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to update vehicle: Invalid status.");
        } catch (Exception e) {
            System.out.println("Failed to update vehicle: " + e.getMessage());
        }
    }

    // Method to print vehicle inventory to a file
    public void printToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Automobile vehicle : inventory) {
                writer.write(vehicle.toString());
                writer.newLine();
            }
            System.out.println("Vehicle information printed to " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to print to file: " + e.getMessage());
        }
    }

    // Main method to interact with the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutomobileInventory inventory = new AutomobileInventory();

        try {
            boolean continueRunning = true;

            while (continueRunning) {
                System.out.println("\nInventory Management Menu:");
                System.out.println("1. Add a Vehicle");
                System.out.println("2. List All Vehicles");
                System.out.println("3. Remove a Vehicle");
                System.out.println("4. Update a Vehicle");
                System.out.println("5. Print to File");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println(inventory.addVehicleFromInput(scanner));
                        break;
                    case 2:
                        inventory.listVehicles();
                        break;
                    case 3:
                        System.out.print("Enter the index of the vehicle to remove: ");
                        int removeIndex = Integer.parseInt(scanner.nextLine());
                        System.out.println(inventory.removeVehicle(removeIndex));
                        break;
                    case 4:
                        System.out.print("Enter the index of the vehicle to update: ");
                        int updateIndex = Integer.parseInt(scanner.nextLine());
                        inventory.updateVehicleFromInput(scanner, updateIndex);
                        break;
                    case 5:
                        System.out.print("Enter file path (e.g., C:\\Temp\\Autos.txt): ");
                        String filePath = scanner.nextLine();
                        inventory.printToFile(filePath);
                        break;
                    case 6:
                        continueRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
