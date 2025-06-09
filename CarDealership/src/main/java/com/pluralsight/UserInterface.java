package com.pluralsight;

import model.Dealership;
import com.pluralsight.DealershipFileManager;
import model.Vehicle;

import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Dealership dealership;
    private final Scanner scanner;
    public UserInterface() {
        scanner = new Scanner(System.in);
    }
    // Step 1: Init method
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership("dataFiles/inventory.csv");

    }
    public void display() {
        init();  // Load the dealership

        boolean running = true;
        while (running) {
            displayMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    processAllVehiclesRequest();
                    break;
                case "2":
                    processFilterByRequest();
                    break;
                case "3":
                    addVehicleRequest();
                    break;
                case "4":
                    removeVehicleRequest();
                    break;
                case "0":

                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
    // Helper method to display the menu with UI enhancements
    private void displayMenu(){


    }
    private void displayVehicles(ArrayList<Vehicle> vehicles){

    }
}
