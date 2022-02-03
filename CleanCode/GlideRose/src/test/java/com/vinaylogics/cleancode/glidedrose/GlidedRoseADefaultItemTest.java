package com.vinaylogics.cleancode.glidedrose;

import com.vinaylogics.cleancode.glidedrose.models.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlidedRoseADefaultItemTest {

    /**
     * Method to test the variation in quality of the item for the non expired
     * Item.
     *
     * The quality should decrease by 1 when the item is not expired
     * and sell in should decrease by 1.
     *
     */
    @Test
    public void testUpdateQualityDefault1(){
        Item item = new Item("DEFAULT_ITEM",15,3);
        Item[] items = new Item[]{item};
        GlidedRose app = new GlidedRose(items);
        app.updateQuality();
        assertEquals("DEFAULT_ITEM", app.items[0].name);
        assertEquals(14,app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }


    /**
     * Method to test the variation in quality of the item for the non expired
     * Item.
     *
     * The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.
     *
     */
    @Test
    public void testUpdateQualityDefaultForExpiredItem(){
        Item item = new Item("DEFAULT_ITEM",-1,3);
        Item[] items = new Item[]{item};
        GlidedRose app = new GlidedRose(items);
        app.updateQuality();
        assertEquals("DEFAULT_ITEM", app.items[0].name);
        assertEquals(-2,app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }




}