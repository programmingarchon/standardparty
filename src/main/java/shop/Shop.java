package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Item> inventory = new ArrayList<Item>();

    public void addItem(Item item) {
        inventory.add(item);
    }

    public int getNumberOfItems() {
        return inventory.size();
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void buy(Item item) throws NotInStock {
        if(inventory.contains(item))
            inventory.remove(item);
        else
            throw new NotInStock();
    }
}
