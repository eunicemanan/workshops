package model;

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
}
