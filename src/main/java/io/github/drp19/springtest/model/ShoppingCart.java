package io.github.drp19.springtest.model;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ShoppingCart {

	private Map<String, ShoppingItem> items;

	public ShoppingCart() {
		items = new HashMap<>();
	}

	public void addItem(ShoppingItem item) {
		if (items.containsKey(item.getItemName())) {
			items.get(item.getItemName()).incrementQuantity();
		} else {
			items.put(item.getItemName(),item);
		}
	}

	public Collection<ShoppingItem> listItems() {
		return items.values();
	}

	public void deleteItem(long itemId) {
		items.remove(itemId);
	}
}