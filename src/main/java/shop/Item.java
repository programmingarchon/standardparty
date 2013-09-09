package shop;

public class Item {
    private int price;
    private String name;

    public Item withPrice(int price) {
        this.price = price;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Item withName(String itemName) {
        this.name = itemName;
        return this;
    }

    public String getName() {
        return name;
    }
}
