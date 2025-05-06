package com.gildedrose;

import java.util.Map;

public class ItemFactory {
	
	private final static Map<String, ItemInterface> item_types = Map.ofEntries(
			Map.entry("Aged Brie", new AgedBrie()),
			Map.entry("Conjured", new Conjured()),
			Map.entry("Backstage passes to a TAFKAL80ETC concert", new BackstagePasses()),
			Map.entry("Sulfuras", new Sulfuras())
);
	
	public static ItemInterface getSpecificOrNormalItem(Item item) {
		return item_types.getOrDefault(item.name, new NormalItem());
		
	}

}
