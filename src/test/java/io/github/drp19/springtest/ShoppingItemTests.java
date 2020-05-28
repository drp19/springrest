package io.github.drp19.springtest;

import io.github.drp19.springtest.model.ShoppingItem;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;


public class ShoppingItemTests {

	@Test(expectedExceptions = IllegalArgumentException.class)
	void addNullItem_throwIllegalArgument() {
		ShoppingItem item = new ShoppingItem(null);
	}

}