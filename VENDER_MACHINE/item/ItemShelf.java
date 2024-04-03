package item;

public class ItemShelf {
    private int itemCode;
    private Item item;
    private boolean soldOut;

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemCode() {
        return this.itemCode;
    }

    public int setItemCode(int itemCode) {
        return this.itemCode = itemCode;
    }

    public boolean isSoldOut() {
        return this.soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

}
