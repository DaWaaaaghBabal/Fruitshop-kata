package fruitshop.discounts;

import java.util.List;

import fruitshop.Discount;
import fruitshop.Product;


public class BananaDiscount implements Discount {

	@Override
	public int computeDiscount(List<Product> cartContent) {
		int bananaCount = 0;
		for(Product item : cartContent) {
			if (item.getName().equals("Bananes")) {
				bananaCount++;
			}
		}
		int discount = bananaCount / 2;
		return discount * 150;
	}

}
