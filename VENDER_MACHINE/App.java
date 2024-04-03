import coin.Coin;
import VendingMachine.*;
import item.*;

public class App {
    public static void main(String[] args) throws Exception {
        VendingMachine vendingMachine = new VendingMachine();

        System.out.println("|fill the Inventory|");
        fillInventory(vendingMachine);

        System.out.println("|Display the Inventory|");
        displayInventory(vendingMachine);

        VendingMachineState vendingMachineState = vendingMachine.getVendingMachineState();

        vendingMachineState.insertCoin(vendingMachine, Coin.FIFTY);
        vendingMachineState.insertCoin(vendingMachine, Coin.TWENTY);

        vendingMachineState.chooseProduct(vendingMachine, 102);
        displayInventory(vendingMachine);

    }

    private static void fillInventory(VendingMachine vedingMachine) {
        ItemShelf[] itemShelfSlots = vedingMachine.getInventory().getInventory();
        for (int i = 0; i < itemShelfSlots.length; i++) {
            Item item = new Item();
            if (i == 0 || i == 8) {
                item.setItemType("OREO");
                item.setPrice(30);
            } else if (i == 1 || i == 9) {
                item.setItemType("JUICE");
                item.setPrice(20);
            } else if (i == 2) {
                item.setItemType("COKE");
                item.setPrice(35);
            } else if (i == 3) {

                item.setItemType("SODA");
                item.setPrice(15);
            } else if (i == 4) {
                item.setItemType("CHIPS");
                item.setPrice(25);
            } else if (i == 5) {
                item.setItemType("CHOCOLATE");
                item.setPrice(20);
            } else if (i == 6) {
                item.setItemType("CANDY");
                item.setPrice(10);
            } else if (i == 7) {
                item.setItemType("GUM");
                item.setPrice(5);
            }

            itemShelfSlots[i].setItem(item);
            itemShelfSlots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] itemShelfSlots = vendingMachine.getInventory().getInventory();
        for (ItemShelf shelf : itemShelfSlots) {
            System.out.println("item code: " + shelf.getItemCode() + " item: " + shelf.getItem().getType() + " price: "
                    + shelf.getItem().getPrice() +
                    " isAvailable: " + !shelf.isSoldOut());
        }
    }
}
