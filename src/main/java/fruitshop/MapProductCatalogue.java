package fruitshop;

import java.util.HashMap;
import java.util.Map;

public class MapProductCatalogue implements ProductCatalogue {

	private Map<String, Product> map;
	
	public MapProductCatalogue() {
		map = new HashMap<>();
		map.put("Pommes", new Product("Pommes", 100));
		map.put("Mele", new Product("Mele", 100));
		map.put("Apples", new Product("Apples", 100));
		map.put("Cerises", new Product("Cerises", 75));
		map.put("Bananes", new Product("Bananes", 150));
	}

	public Product productByName(String name) {
		return map.get(name);
	}
	

}
