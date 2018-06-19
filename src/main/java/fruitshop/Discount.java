package fruitshop;

import java.util.List;

public interface Discount {

	public int computeDiscount(List<Product> cartContent);
}
