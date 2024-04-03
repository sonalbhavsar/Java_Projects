package VendingMachine;

import coin.Coin;
import java.util.*;
import inventory.Inventory;
import item.ItemShelf;
import item.Item;

public class VendingMachineState {
   public VendingMachineState() {
      System.out.println("VendingMachineState is in Idle State");
   }

   public void clickOnStartProductSelectionButton() {
      System.out.println("VendingMachineState is in HasMoneyState");
   }

   public void insertCoin(VendingMachine vendingMachine, Coin coin) {
      System.out.println("VendingMachineState is in HasMoneyState");
      System.out.println("Accepted the coin");
      vendingMachine.getCoinList().add(coin);

   }

   public void chooseProduct(VendingMachine vendingMachine, int itemCodeNumber) {
      // get item for itemcodenumber
      // total amount paid by user
      // compare the product and amount paid by user
      // dispense theproduct

      Item item = vendingMachine.getInventory().getItem(itemCodeNumber);
      int paidByUser = 0;
      for (Coin coin : vendingMachine.getCoinList()) {
         paidByUser += coin.getValue();
      }

      if (item.getPrice() > paidByUser) {
         refundFullMoney(vendingMachine);
         return;
      } else {
         getChange(item.getPrice(), paidByUser);
         dispenseProduct(vendingMachine, itemCodeNumber);
         return;
      }

   }

   public void getChange(int itemPrice, int paidByUser) {
      System.out.println("returning the change to the user :" + (paidByUser - itemPrice));
   }

   public List<Coin> refundFullMoney(VendingMachine vendingMachine) {
      System.out.println("returned the full amount back in the coi dispense tray");
      vendingMachine.setVendingMachineState(new VendingMachineState());
      return vendingMachine.getCoinList();
   }

   public void updateInventory(VendingMachine vendingMachine, Item item, int itemCodeNumber) {
      vendingMachine.getInventory().addItem(item, itemCodeNumber);

   }

   public void dispenseProduct(VendingMachine vendingMachine, int itemCodeNumber) {

      System.out.println("vending machine is in dispense state");
      System.out.println("product has been dispense");
      vendingMachine.getInventory().updateSoldOutItem(itemCodeNumber);
      vendingMachine.setVendingMachineState(new VendingMachineState());

   }

}
