package tianqin.iedu.facatory;

public abstract class Product {
	public final static String FRUIT = "Fruit";
	public final static String MEAT  = "Meat";
	public final static String FOOD  = "Food";
	public final static String WATER = "Water";
	private String name;
	private String type;
	private int weight;
	public Product(){
		
	}
	
	public Product(String name, String type, int weight) {
		super();
		this.name = name;
		this.type = type;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public abstract void show();
}
