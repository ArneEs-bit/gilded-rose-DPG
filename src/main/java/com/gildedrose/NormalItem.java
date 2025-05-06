package com.gildedrose;

public class NormalItem implements ItemInterface {

	@Override
	public void updateItem(Item item) {
		item.sellIn--;
		if(item.quality > QualityValues.min_quality) {
			item.quality--;
			if(item.sellIn < 0 && item.quality > QualityValues.min_quality) {
				item.quality--;
			}
		}
	}
	
}
