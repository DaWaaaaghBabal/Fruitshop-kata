package fruitshop.discounts;

import java.util.List;

import fruitshop.Discount;
import fruitshop.Product;


public class CherryDiscount implements Discount {

	@Override
	public int computeDiscount(List<Product> cartContent) {
		int cherryCount = 0;
		for(Product item : cartContent) {
			if (item.getName().equals("Cerises")) {
				cherryCount++;
			}
		}
		int discount = cherryCount / 2;
		return discount * 20;
	}

}
