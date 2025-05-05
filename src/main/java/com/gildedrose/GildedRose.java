package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
		for (Item item : items) {
			if (!item.name.equals("Aged Brie")
					&& !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (isLowestValueReached(item)) {
					if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
						item.quality = item.quality - 1;
					}
				}
			} else {
				if (isHighestValueReached(item)) {
					item.quality = item.quality + 1;

					if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (item.sellIn < 11) {
							if (isHighestValueReached(item)) {
								item.quality = item.quality + 1;
							}
						}

						if (item.sellIn < 6) {
							if (isHighestValueReached(item)) {
								item.quality = item.quality + 1;
							}
						}
					}
				}
			}

			if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
				item.sellIn = item.sellIn - 1;
			}

			if (item.sellIn < 0) {
				if (!item.name.equals("Aged Brie")) {
					if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (isLowestValueReached(item)) {
							if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
								item.quality = item.quality - 1;
							}
						}
					} else {
						item.quality = item.quality - item.quality;
					}
				} else {
					if (isHighestValueReached(item)) {
						item.quality = item.quality + 1;
					}
				}
			}
		}

	}
    private boolean isLowestValueReached(Item item) {
    	return item.quality < QualityValues.lowestPossibleValue;
    }
    private boolean isHighestValueReached(Item item) {
    	return item.quality > QualityValues.highestPossibleValue;
    }
}
