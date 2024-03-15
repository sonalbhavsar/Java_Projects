package player;

import java.util.Scanner;

public class Player {

    String name;
    String address;
    String contactNumber;
    String emailId;
    int age;

    public void setPlayerDetails(String name, String address, String contactNumber, String emailId, int age) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.age = age;
    }

    public void getPlayerDetails() {
        System.out.println("Player Details: ");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Email: " + emailId);
        System.out.println("Age: " + age);
    }

    public void setPlayerName(String name) {
        this.name = name;

    }

    public String getPlayerName() {
        return this.name;

    }

    public void setPlayerDetailsFromUserInput(Player p) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = scn.nextLine();
        System.out.println("Enter the address: ");
        String address = scn.nextLine();
        System.out.println("Enter the contact number: ");
        String contactNumber = scn.nextLine();
        System.out.println("Enter the email id: ");
        String emailId = scn.nextLine();
        System.out.println("Enter the age: ");
        int age = scn.nextInt();

        p.setPlayerDetails(name, address, contactNumber, emailId, age);

    }

}
