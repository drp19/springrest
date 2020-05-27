package io.github.drp19.springtest;

import io.github.drp19.springtest.model.ShoppingItem;
import io.github.drp19.springtest.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class ShoppingController {

	@Autowired
	private ShoppingCart cart;

	@GetMapping("/")
	public Collection<ShoppingItem> listItems() {
		return cart.listItems();
	}

	@PostMapping("/add")
	public void addItem(@RequestParam(value="name") ShoppingItem item) {
		cart.addItem(item);
	}

	@DeleteMapping("/delete")
	public void delete(@PathVariable long id) {
		cart.deleteItem(id);
	}
}