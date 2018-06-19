package fruitshop.discounts;

import java.util.List;

import fruitshop.Discount;
import fruitshop.Product;

public class MelaDiscount implements Discount {

	@Override
	public int computeDiscount(List<Product> cartContent) {
		int meleCount = 0;
		for(Product item : cartContent) {
			if (item.getName().equals("Mele")) {
				meleCount++;
			}
		}
		int discount = meleCount / 2;
		return discount * 100;
	}

}
