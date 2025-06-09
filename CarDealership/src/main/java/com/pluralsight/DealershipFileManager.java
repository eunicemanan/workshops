package com.pluralsight;

import model.Dealership;
import model.Vehicle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DealershipFileManager
{

    // Update the method to use the passed file path
    public Dealership getDealership(String filePath) {
        Dealership dealership = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            reader.readLine();

            // First line = dealership info
            line = reader.readLine();
            if (line != null) {
                String[] dealerInfo = line.split("\\|");
                String name = dealerInfo[0];
                String address = dealerInfo[1];
                String phoneNumber = dealerInfo[2];
                dealership = new Dealership(name, address, phoneNumber);
            }
            reader.readLine();
            // Rest of the lines = vehicles
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String type = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);
            }

            reader.close();

        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }

        return dealership;
    }


    // Saving dealership (no change needed here)
    public void saveDealership(Dealership dealership) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("dataFiles/inventory.csv"));

            // Write dealership info (name, address, phone number)
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber());
            writer.newLine();

            // Write vehicle inventory
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String vehicleData = vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" + vehicle.getPrice();
                writer.write(vehicleData);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("An error has occurred while reading the file");
            throw new RuntimeException(e);
        }
    }
}
