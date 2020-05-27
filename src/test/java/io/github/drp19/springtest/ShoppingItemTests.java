package io.github.drp19.springtest;

import io.github.drp19.springtest.model.ShoppingItem;

import org.testng.annotations.Test;



public class ShoppingItemTests {

	@Test(expectedExceptions = IllegalArgumentException.class)
	void addNullItem_thenThrowIllegalArgument() {
		ShoppingItem item = new ShoppingItem(null);
	}


}