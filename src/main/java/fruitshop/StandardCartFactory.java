package fruitshop;

import fruitshop.discount.ManyFruitDiscount;
import fruitshop.discount.MultiApplesDiscount;
import fruitshop.discounts.AppleDiscount;
import fruitshop.discounts.BananaDiscount;
import fruitshop.discounts.CherryDiscount;
import fruitshop.discounts.MelaDiscount;

public class StandardCartFactory implements CartFactory {

	@Override
	public Cart createCart() {
		Cart cart = new Cart();
		cart.addDiscount(new BananaDiscount());
		cart.addDiscount(new MultiApplesDiscount());
		cart.addDiscount(new ManyFruitDiscount());
		cart.addDiscount(new AppleDiscount());
		cart.addDiscount(new MelaDiscount());
		cart.addDiscount(new CherryDiscount());
		return cart;
	}

}
