package fruitshop;


public class Product {
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.price = price;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
