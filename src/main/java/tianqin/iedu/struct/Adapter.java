package tianqin.iedu.struct;

import java.util.Map;

public class Adapter implements Target{
	private AliAdaptee alipay;
	private WxAdaptee  wxpay;
	
	public Adapter() {
		alipay = new AliAdaptee();
		wxpay  = new WxAdaptee();
		
	}

	@Override
	public void pay(Map<String, Object> args) {
		Object type = args.get("payType");
		if(type == null) {
			/**返回错误：抛异常**/
			return ;
		}
		
		if(type.equals("alipay")) {
			/***组装参数**/
			String s = "";
			alipay.pay(s);
			return ;
		}
		
		if(type.equals("wx")) {
			wxpay.pay(args);
			return ;
		}
		
		/***抛异常**/
	}

}
