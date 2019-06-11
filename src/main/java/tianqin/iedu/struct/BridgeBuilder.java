package tianqin.iedu.struct;

public class BridgeBuilder {
	/**这里不采用单例的Builder模式，而是采用工厂方法**/
	public static Bridge createBridge(String type) {
		if(type.equals("alipay")) {
			return new RefinedBridge(new AlipayBridgeImpl());
		}
		if(type.equals("wx")) {
			return new RefinedBridge(new WxpayBridgeImpl());
		}
		
		return null;
	}
}
