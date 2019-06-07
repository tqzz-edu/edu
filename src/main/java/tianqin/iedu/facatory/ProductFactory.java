package tianqin.iedu.facatory;

public class ProductFactory implements Factory{
	
	class Food extends Product{
		public Food() {
			super("Rice",Product.FOOD, 10);
		}
			
		@Override
		public void show() {
			System.out.println(String.format("[%s] [%s] [%d] is food", 
						                        this.getName(), this.getType(),this.getWeight()));
		}	
	}
	
	
	class Meat extends Product{
		public Meat() {
			super("Prok",Product.MEAT, 10);
		}
			
		@Override
		public void show() {
			System.out.println(String.format("[%s] [%s] [%d] is meat", 
						                        this.getName(), this.getType(),this.getWeight()));
		}	
	}
	
	class Water extends Product{
		public Water() {
			super("spring",Product.WATER, 10);
		}
			
		@Override
		public void show() {
			System.out.println(String.format("[%s] [%s] [%d] is water", 
						                        this.getName(), this.getType(),this.getWeight()));
		}
	}
	

	@Override
	public Product CreateProduct() {
		return null;
	}

	@Override
	public Product CreateProduct(String type) {
		if(Product.FOOD.equals(type)) {
			return new Food();
		}else if(Product.MEAT.equals(type)) {
			return new Meat();
		}else if(Product.WATER.equals(type)) {
			return new Water();
		}
		
		return null;
	}



}
