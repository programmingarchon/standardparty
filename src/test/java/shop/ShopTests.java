package shop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShopTests {

    @Test
    public void shopShouldBeAbleToOfferItems() throws Exception {
        Shop shop = new Shop();
        Item stick = new Item().withPrice(20).withName("Stick");
        shop.addItem(stick);

        shop.buy(stick);

        assertFalse(shop.getInventory().contains(stick));
    }

    @Test(expected = NotInStock.class)
    public void shouldNotBeAbleToBuyNonExistingItem() throws Exception {
        Shop shop = new Shop();
        shop.buy(new Item().withName("Stick").withPrice(20));
    }

    @Test
    public void newShopShouldHaveZeroItems() throws Exception {
        Shop shop = new Shop();

        assertEquals(0, shop.getNumberOfItems());
    }

    @Test
    public void addedItemShouldBeInTheInventory() throws Exception {
        Shop shop = new Shop();
        Item stick = new Item().withPrice(20).withName("Stick");
        shop.addItem(stick);

        assertTrue(shop.getInventory().contains(stick));
    }
}
