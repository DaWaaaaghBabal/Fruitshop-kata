package fruitshop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart {
	
	List<Product> content;
	Set<Discount> discounts;
	
	public Cart() {
		super();
		content = new ArrayList<>();
		discounts = new HashSet<>();
	}

	public void addItem(Product item) {
		content.add(item);
	}

	public int computePrice() {
		int sum = 0;
		for(Product product : content) {
			sum += product.getPrice();
		}
		for(Discount discount : discounts) {
			sum -= discount.computeDiscount(content);
		}
		return sum;
	}

	public void addDiscount(Discount discount) {
		discounts.add(discount);
	}

}
