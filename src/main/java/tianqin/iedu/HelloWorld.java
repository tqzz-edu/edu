package tianqin.iedu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/****
 * 
 * @author simon
 *
 */
public class HelloWorld {
	/**静态变量：**/
	private static int RAND_SEQ;
	private static int sum;
	
	static {
		/**静态代码块，一般用于系统初始化，进行叫复杂的初始化**/
		Random rand = new Random();
		RAND_SEQ = rand.nextInt();
	}
	
	/**静态方法**/
	public static void sayHello() {
		System.out.println("Hello world:" + RAND_SEQ);
	}
	
	/**静态方法**/
	public static void main(String [] args) {
		/***匿名类**/
		/**匿名类实现：xx 线程执行体**/
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Some is running ........");
				/**调用外嵌类的方法**/
				sayHello();
			}}, "匿名类");
		th.start();
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**用于函数对象**/
		List<Integer> lst = new ArrayList<>();
		Random rand = new Random();
		for(int i = 0; i < 100; i++) {
			lst.add(Integer.valueOf(rand.nextInt()));
		}
		/**统计偶数个数**/
		sum = 0;
		/**匿名类：用于实现遍历链表的函数对象**/
		lst.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				if((t.intValue() % 2 == 0) && t.intValue() > 0) {
					/**访问静态变量**/
					sum = sum + 1;
				}
			}});
		System.out.println("Sum:" + sum);
		
		
	}

}
