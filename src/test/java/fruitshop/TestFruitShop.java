package fruitshop;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import fruitshop.discounts.BananaDiscount;
import fruitshop.discounts.CherryDiscount;


public class TestFruitShop {
	
	private static ProductCatalogue cata = new MapProductCatalogue();
	private static CartFactory cartFactory = new StandardCartFactory();
	private static InputParser inputParser = new CSVParser();
	private static Product productForName(String name) {
		return cata.productByName(name);
	}

	@Test
	public void testBasicCart() {
		Cart cart = cartFactory.createCart();
		cart.addItem(productForName("Pommes"));
		assertEquals(100, cart.computePrice());
		cart.addItem(productForName("Cerises"));
		assertEquals(175, cart.computePrice());
		cart.addItem(productForName("Cerises"));
		assertEquals(230, cart.computePrice());
	}

	@Test
	public void testCherryDiscount() {
		Cart cart = cartFactory.createCart();
		cart.addItem(productForName("Pommes"));
		assertEquals(cart.computePrice(), 100);
		cart.addItem(productForName("Cerises"));
		assertEquals(cart.computePrice(), 175);
		cart.addItem(productForName("Cerises"));
		assertEquals(cart.computePrice(), 230);
		cart.addItem(productForName("Cerises"));
		assertEquals(cart.computePrice(), 305);
		cart.addItem(productForName("Cerises"));
		assertEquals(cart.computePrice(), 160);
	}
	
	@Test
	public void testBananaDiscount() {
		Cart cart = cartFactory.createCart();
		cart.addItem(productForName("Pommes"));
		assertEquals(cart.computePrice(), 100);
	
		cart.addItem(productForName("Cerises"));
		assertEquals(cart.computePrice(), 175);
		cart.addItem(productForName("Bananes"));
		assertEquals(cart.computePrice(), 325);
		cart.addItem(productForName("Bananes"));
		assertEquals(cart.computePrice(), 325);
		cart.addItem(productForName("Cerises"));
		assertEquals(cart.computePrice(), 180);
	}
	
	@Test
	public void testI18n() {
		Cart cart = cartFactory.createCart();
		cart.addItem(productForName("Cerises"));
		assertEquals(75, cart.computePrice());
		cart.addItem(productForName("Apples"));
		assertEquals(175, cart.computePrice());
		cart.addItem(productForName("Cerises"));
		assertEquals(230, cart.computePrice());
		cart.addItem(productForName("Bananes"));
		assertEquals(380, cart.computePrice());
		cart.addItem(productForName("Bananes"));
		assertEquals(180, cart.computePrice());
	}

	@Test
	public void testCsvInput() {
		Cart cart = cartFactory.createCart();
		String input = "Pommes, Bananes, Cerises";
		for (String str : inputParser.readProductNames(input)) {
			cart.addItem(productForName(str));
		}
		assertEquals(325, cart.computePrice());
	}
	
	@Test
	public void testMultiReduc() {
		Cart cart = cartFactory.createCart();
		String input = "Mele, Apples, Apples, Mele";
		for (String str : inputParser.readProductNames(input)) {
			cart.addItem(productForName(str));
		}
		assertEquals(200, cart.computePrice());
		cart.addItem(productForName("Bananes"));
		assertEquals(150, cart.computePrice());
		input = "Mele, Apples, Apples, Pommes, Mele";
		for (String str : inputParser.readProductNames(input)) {
			cart.addItem(productForName(str));
		}
		assertEquals(150, cart.computePrice());
	}
	
	public static void main(String[] args) {
		Cart cart = cartFactory.createCart();
		Scanner s = new Scanner(System.in);
		while (true) {
			String input = s.next();
			for (String str : inputParser.readProductNames(input)) {

				cart.addItem(productForName(str));
			}
			System.out.println("Le prix total actuel est : " + cart.computePrice());
		}
	}
}
