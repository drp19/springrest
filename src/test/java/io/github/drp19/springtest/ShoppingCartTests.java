package io.github.drp19.springtest;

import io.github.drp19.springtest.model.ShoppingCart;
import io.github.drp19.springtest.model.ShoppingItem;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;

public class ShoppingCartTests {

	@Test
	public void addDuplicateItems_updateQuantity() {
		ShoppingCart testCart = new ShoppingCart();
		ShoppingItem itemA = new ShoppingItem("eggs"), itemB = new ShoppingItem("eggs");
		ShoppingItem expectedItem = new ShoppingItem("eggs");
		expectedItem.setQuantity(2);

		Collection<ShoppingItem> expected = new ArrayList<>();
		expected.add(expectedItem);

		testCart.addItem(itemA);
		testCart.addItem(itemB);
		Collection<ShoppingItem> found = testCart.listItems();
		Assert.assertTrue(found.size() == expected.size() && found.containsAll(expected) && expected.containsAll(found));
	}

	@Test
	public void addIdenticalItems_noChange() {
		ShoppingCart testCart = new ShoppingCart();
		ShoppingItem dupItem = new ShoppingItem("bread");
		dupItem.setQuantity(2);
		Collection<ShoppingItem> expected = new ArrayList<>();
		expected.add(dupItem);

		testCart.addItem(dupItem);
		testCart.addItem(dupItem);
	}


	@Test(expectedExceptions = ArithmeticException.class)
	public void addTooMany_throwArithmetic() {
		ShoppingCart testCart = new ShoppingCart();
		ShoppingItem bigItem = new ShoppingItem("car"), smallItem = new ShoppingItem("car");
		bigItem.setQuantity(Integer.MAX_VALUE);
		testCart.addItem(bigItem);
		testCart.addItem(smallItem);
	}
}
