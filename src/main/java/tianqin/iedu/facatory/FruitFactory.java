package tianqin.iedu.facatory;

public class FruitFactory implements Factory{
	class FruitProduct extends Product{
		public FruitProduct() {
			super("Apple","fruit",10);
		}
		
		@Override
		public void show() {
			System.out.println(String.format("[%s] [%s] [%d] is fruit", 
					                        this.getName(), this.getType(),this.getWeight()));
		}
		
	}
	public Product CreateProduct() {
		return new FruitProduct();
	}
}
