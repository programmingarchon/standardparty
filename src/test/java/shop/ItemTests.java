package shop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTests {

    public static final String ITEM_NAME = "Stick";

    @Test
    public void itemShouldHavePrice() throws Exception {
        Item stick = new Item().withPrice(10);

        assertEquals(10, stick.getPrice());
    }

    @Test
    public void itemShouldHaveName() throws Exception {
        Item stick = new Item().withName(ITEM_NAME);

        assertEquals(ITEM_NAME, stick.getName());
    }
}
