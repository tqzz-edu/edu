package tianqin.iedu.facatory;

public class SmallShopBuilder implements ShopBuilder{
	private Shop shop;
	public SmallShopBuilder() {
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
		// 其他可以参考
		
	}

	@Override
	public void buildWater() {
		
	}

	@Override
	public void buildMeate() {
		
	}

	@Override
	public Shop getShop() {
		return shop;
	}

}
