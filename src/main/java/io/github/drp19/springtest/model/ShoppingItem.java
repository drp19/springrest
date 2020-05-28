package io.github.drp19.springtest.model;

import org.springframework.lang.NonNull;

import java.security.InvalidParameterException;
import java.util.Random;

public class ShoppingItem {

	private long id;
	private final String itemName;
	private int quantity;

	public ShoppingItem(@NonNull String itemName) {
		if (itemName == null) {
			throw new IllegalArgumentException("Must provide an item name.");
		}
		Random r = new Random();
		id = r.nextLong();
		this.itemName = itemName;
		this.quantity = 1;
	}

	public long getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setQuantity(int i) {
		if (i < 0) {
			throw new IllegalArgumentException("Cannot set to a negative quantity");
		} else if (i == 0) {
			throw new IllegalArgumentException("Must remove item instead of setting to 0 quantity");
		}
		quantity = i;
	}

	public void incrementQuantity() {
		if (quantity == Integer.MAX_VALUE) {
			throw new ArithmeticException("Quantity overflow");
		}
		quantity++;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ShoppingItem)) {
			return false;
		}
		ShoppingItem item = (ShoppingItem)obj;
		return itemName.equals(item.itemName) && quantity == item.quantity;
	}
}