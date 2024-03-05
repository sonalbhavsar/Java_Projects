package player;

public class Player {
    private String name;
    private char symbol;
    private String address;
    private String contactNumber;
    private String emailId;
    private int age;

    public void setPlayerDetails(String name, char symbol, String address, String contactNumber, String emailId,
            int age) {
        this.name = name;
        this.symbol = symbol;
        this.address = address;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.age = age;
    }

    public void setPlayerNameandSymbol(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void getPlayerNameandSymbol() {
        System.out.println("Player Name: " + name);
        System.out.println("Player Symbol: " + symbol);
    }

    public void changeSymbol(char newSymbol) {
        this.symbol = newSymbol;
    }

    public String getPlayerName() {
        return name;
    }

    public char getPlayerSymbol() {
        return symbol;
    }

    public void getPlayerDetails() {
        System.out.println("Player Name: " + name);
        System.out.println("Player Symbol: " + symbol);
        System.out.println("Player Address: " + address);
        System.out.println("Player Contact Number: " + contactNumber);
        System.out.println("Player Email Id: " + emailId);
        System.out.println("Player Age: " + age);
    }
}
