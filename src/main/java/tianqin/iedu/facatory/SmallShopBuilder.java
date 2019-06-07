package tianqin.iedu.facatory;

public class SmallShopBuilder implements ShopBuilder{
	private ProductFactory productFactory;
	private Shop shop;
	public SmallShopBuilder() {
		productFactory = new ProductFactory();
		shop = new Shop();
	}

	@Override
	public void buildFruit() {
		// 采用工厂模式
		Factory factory = new FruitFactory();
		for(int i = 0; i < 20; i++) {
			shop.addProduct(factory.CreateProduct());
		}
	}

	@Override
	public void buildFood() {
		// 采用工厂方法——虚拟构造函数
		for(int j = 0; j < 30; j++) {
			shop.addProduct(productFactory.CreateProduct(Product.FOOD));
		}
	}

	@Override
	public void buildWater() {
		// 采用工厂方法——虚拟构造函数
		for(int j = 0; j < 30; j++) {
			shop.addProduct(productFactory.CreateProduct(Product.WATER));
		}
	}

	@Override
	public void buildMeate() {
		// 采用工厂方法——虚拟构造函数
		for(int j = 0; j < 30; j++) {
			shop.addProduct(productFactory.CreateProduct(Product.MEAT));
		}
	}

	@Override
	public Shop getShop() {
		return shop;
	}

}
