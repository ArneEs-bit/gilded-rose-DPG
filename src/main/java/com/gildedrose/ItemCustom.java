package com.gildedrose;

public class ItemCustom implements ItemInterface {

	private final Item item;
	
	public ItemCustom(Item item) {
		this.item = item;
	}

	@Override
	public void updateItem() {
		// TODO Auto-generated method stub
		
	}
	
	private void reduceSellInValue() {
		item.sellIn -= 1;
	}

}
