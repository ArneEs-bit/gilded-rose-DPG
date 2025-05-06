package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

class GildedRoseTest {
	private Item[] items;
	private GildedRose gildedRose;

	@BeforeEach
	public void setup() {
		items = new Item[] {
				new Item("Aged Brie", 2, 0), 
				new Item("Sulfuras", 0, 80),
				new Item("Normal Item", 10, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Conjured", 3, 6) };
		gildedRose = new GildedRose(items);
	}

    @Test
    public void testAgedBrieIncreasesQuality() {
        Item agedBrie = items[0];
        gildedRose.updateQuality();
        assertEquals(1, agedBrie.quality);
        assertEquals(1, agedBrie.sellIn);
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = items[1];
        int initialQuality = sulfuras.quality;
        int initialSellIn = sulfuras.sellIn;

        gildedRose.updateQuality();
        assertEquals(initialQuality, sulfuras.quality);
        assertEquals(initialSellIn, sulfuras.sellIn); 
    }

    @Test
    public void testNormalItemDegradesQuality() {
        Item normalItem = items[2];
        int initialQuality = normalItem.quality;
        int initialSellIn = normalItem.sellIn;

        gildedRose.updateQuality();
        assertEquals(initialQuality - 1, normalItem.quality);
        assertEquals(initialSellIn - 1, normalItem.sellIn);
    }

    @Test
    public void testBackstagePassesIncreaseQuality() {
        Item backstagePass = items[3];
        gildedRose.updateQuality();
        assertEquals(21, backstagePass.quality);
        assertEquals(14, backstagePass.sellIn);
    }

    @Test
    public void testBackstagePassesQualityIncreasesBy3WhenSellInBelow5() {
        Item backstagePass = items[3];
        backstagePass.sellIn = 4;
        gildedRose.updateQuality();
        assertEquals(23, backstagePass.quality);
        assertEquals(3, backstagePass.sellIn);
    }

    @Test
    public void testBackstagePassesQualityBecomesZeroAfterSellInBelow0() {
        Item backstagePass = items[3];
        backstagePass.sellIn = 0;
        gildedRose.updateQuality();
        assertEquals(0, backstagePass.quality);
        assertEquals(-1, backstagePass.sellIn);
    }

    @Test
    public void testConjuredItemDegradesTwiceAsFast() {
        Item conjuredItem = items[4];
        int initialQuality = conjuredItem.quality;
        int initialSellIn = conjuredItem.sellIn;

        gildedRose.updateQuality();
        assertEquals(initialQuality - 2, conjuredItem.quality);
        assertEquals(initialSellIn - 1, conjuredItem.sellIn);
    }

    @Test
    public void testConjuredItemDegradesFourTimesAfterSellInPasses() {
        Item conjuredItem = items[4];
        conjuredItem.sellIn = 0;
        int initialQuality = conjuredItem.quality;

        gildedRose.updateQuality();
        assertEquals(initialQuality - 4, conjuredItem.quality);
        assertEquals(-1, conjuredItem.sellIn);
    }

    @Test
    public void testNormalItemNeverNegativeQuality() {
        Item normalItem = items[2];
        normalItem.quality = 0;

        gildedRose.updateQuality();
        assertEquals(0, normalItem.quality);
    }

    @Test
    public void testAgedBrieNeverExceedsMaximumQuality() {
        Item agedBrie = items[0];
        agedBrie.quality = 50;

        gildedRose.updateQuality();
        assertEquals(50, agedBrie.quality);
    }

}
