package tianqin.iedu.struct;

import java.util.HashMap;
import java.util.Map;

public class Facade {
	private interface Translater{
		public void compile(String method, String data);
	}
	
	private Map<String, Translater> funs;
	
	public Facade() {
		funs = new HashMap<>();
		/**采用匿名函数**/
		funs.put("java", new Translater() {
			@Override
			public void compile(String method, String data) {
				System.out.println(String.format("Compile: %s data:%s", method, data));
			}});
		/**JDK 1.8 以上, lamba**/
		funs.put("c++", (m, d)->{System.out.println(String.format("Compile: %s data:%s", m, d));});
		funs.put("php", (m, d)->{System.out.println(String.format("Compile: %s data:%s", m, d));});
		funs.put("go", (m, d)->{System.out.println(String.format("Compile: %s data:%s", m, d));});
		funs.put("python", (m, d)->{System.out.println(String.format("Compile: %s data:%s", m, d));});
	}
	
	public void compile(String method, String data) {
		Translater translater = funs.get(method);
		if(translater == null) {
			/**不建议字符串拼接**/
			System.out.println("Error: compile " + method + "Failed");
			return;
		}else {
			translater.compile(method, data);
		}
	}

}
