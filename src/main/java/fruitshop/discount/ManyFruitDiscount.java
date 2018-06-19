package fruitshop.discount;

import java.util.List;

import fruitshop.Discount;
import fruitshop.Product;


public class ManyFruitDiscount implements Discount {

	@Override
	public int computeDiscount(List<Product> cartContent) {
		int discount = cartContent.size() / 5;
		return discount * 200;
	}

}
