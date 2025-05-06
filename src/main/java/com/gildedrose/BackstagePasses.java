package com.gildedrose;

public class BackstagePasses implements ItemInterface {

	@Override
	public void updateItem(Item item) {
		item.sellIn--;

		if (item.sellIn < 0) {
			item.quality = QualityValues.min_quality;
			return;
		}

		if (item.quality < QualityValues.max_quality) {
			item.quality++;
			if (item.sellIn < 10 && item.quality < QualityValues.max_quality) {
				item.quality++;
			}
			if (item.sellIn < 5 && item.quality < QualityValues.max_quality) {
				item.quality++;
			}
		}

	}

}
