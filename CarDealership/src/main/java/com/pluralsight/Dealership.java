package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private ArrayList<Vehicle> inventory;
    private String name;
    private String address;
    private String phoneNumber;

    public Dealership(String name, String address, String phoneNumber) {
        this.inventory = new ArrayList<>(); // ✅ FIXED: changed from vehicles to inventory
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }
    public ArrayList<Vehicle> getVehiclesByMakeAndModel(String make, String model) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory; // returns the list of all vehicles
    }
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle); // Adds the given vehicle to the inventory
    }

}

