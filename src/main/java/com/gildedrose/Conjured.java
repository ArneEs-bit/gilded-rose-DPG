package com.gildedrose;

public class Conjured implements ItemInterface {

	@Override
	public void updateItem(Item item) {
		item.sellIn--;

		int degrade = (item.sellIn < 0) ? 4 : 2;

		item.quality = Math.max(QualityValues.min_quality, item.quality - degrade);

	}

}
