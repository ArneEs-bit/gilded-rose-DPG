package com.gildedrose;

public class AgedBrie implements ItemInterface {

	@Override
	public void updateItem(Item item) {
		item.sellIn--;
		if(item.quality < QualityValues.max_quality) {
			item.quality++;
			if(item.sellIn < 0 && item.quality < QualityValues.max_quality) {
				item.quality++;
			}
		}
	}

}
