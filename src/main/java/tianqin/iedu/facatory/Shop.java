package tianqin.iedu.facatory;

import java.util.LinkedList;
import java.util.List;

public class Shop {
	private List<Product> fruitList;
	private List<Product> foodList;
	private List<Product> meatList;
	private List<Product> waterList;
	
	public Shop() {
		fruitList = new LinkedList<>();
		foodList  = new LinkedList<>();
		meatList  = new LinkedList<>();
		waterList = new LinkedList<>();
	}
	
	public Product shellFruit() {
		if(fruitList.isEmpty()) {
			return null;
		}
		return fruitList.remove(0);
	}
	
	public Product shellFood() {
		if(foodList.isEmpty()) {
			return null;
		}
		return foodList.remove(0);
	}
	
	public Product shellMeat() {
		if(meatList.isEmpty()) {
			return null;
		}
		return meatList.remove(0);
	}
	
	public Product shellWater() {
		if(waterList.isEmpty()) {
			return null;
		}
		return waterList.remove(0);
	}
	
	public void addProduct(Product product) {
		if(Product.FRUIT.equals(product.getType())) {
			fruitList.add(product);
		}else if(Product.FOOD.equals(product.getType())) {
			foodList.add(product);
		}else if(Product.MEAT.equals(product.getType())) {
			meatList.add(product);
		}else if(Product.WATER.equals(product.getType())) {
			waterList.add(product);
		}
	}
}
