package fruitshop.discounts;

import java.util.List;

import fruitshop.Discount;
import fruitshop.Product;

public class AppleDiscount implements Discount {

	@Override
	public int computeDiscount(List<Product> cartContent) {
		int appleCount = 0;
		for(Product item : cartContent) {
			if (item.getName().equals("Apples")) {
				appleCount++;
			}
		}
		int discount = appleCount / 3;
		return discount * 100;
	}

}
