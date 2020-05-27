package io.github.drp19.springtest.model;

import org.springframework.lang.NonNull;

import java.util.Random;

public class ShoppingItem {

	private long id;
	private final String itemName;

	public ShoppingItem(@NonNull String itemName) {
		if (itemName == null) {
			throw new IllegalArgumentException("Must provide an item name.");
		}
		Random r = new Random();
		id = r.nextLong();
		this.itemName = itemName;
	}

	public long getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}
}