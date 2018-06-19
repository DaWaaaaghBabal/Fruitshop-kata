package fruitshop.discount;

import java.util.List;

import fruitshop.Discount;
import fruitshop.Product;


public class MultiApplesDiscount implements Discount {

	@Override
	public int computeDiscount(List<Product> cartContent) {
		int count = 0;
		for(Product item : cartContent) {
			if(item.getName().equals("Pommes") || item.getName().equals("Mele") || item.getName().equals("Apples")) {
				count++;
			}
		}
		int discount = count / 4;
		return discount * 100;
	}

}
