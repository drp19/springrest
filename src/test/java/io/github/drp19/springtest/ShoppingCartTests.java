package io.github.drp19.springtest;

import io.github.drp19.springtest.model.ShoppingCart;
import io.github.drp19.springtest.model.ShoppingItem;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class ShoppingCartTests {

	@Test
	public void addDuplicateItems_bothAdded() {
		ShoppingCart testCart = new ShoppingCart();
		ShoppingItem itemA = new ShoppingItem("eggs"), itemB = new ShoppingItem("eggs");
		Collection<ShoppingItem> expected = new HashSet<>();
		expected.add(itemA);
		expected.add(itemB);

		testCart.addItem(itemA);
		testCart.addItem(itemB);
		Assert.assertEquals(expected,testCart.listItems());
	}

	@Test
	public void addIdenticalItems() {

	}


	@Test
	public void addVarious() {

	}
}
