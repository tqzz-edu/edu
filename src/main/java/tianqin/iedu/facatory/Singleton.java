package tianqin.iedu.facatory;

/***
 * Singleton
 * 
 * @author simon
 * @date 2019/07/26
 */
public class Singleton {
	/**lazy-load**/
	private static class LazyHolder{
		private final static Singleton INSTANCE = new Singleton();
	}
	
	private Singleton() {
		/**单例：将构造函数设置为私有，确保单利**/
	}
	
	/***
	 * 
	 * @return Singleton
	 */
	public static Singleton instance() {
	    /**通过lazy-load-holder方式 解决线程安全**/
		return LazyHolder.INSTANCE;
	}
	

}
