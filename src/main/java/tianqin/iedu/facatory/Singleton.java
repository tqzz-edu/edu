package tianqin.iedu.facatory;

public class Singleton {
	/**lazy-load**/
	private static class LazyHolder{
		private final static Singleton INSTANCE = new Singleton();
	}
	
	private Singleton() {
		/**单例：将构造函数设置为私有，确保单利**/
	}
	
	public static Singleton instance() {
		return LazyHolder.INSTANCE;
	}
	

}
