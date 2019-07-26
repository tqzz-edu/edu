package tianqin.iedu;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Hello world!
 *
 */

public class App 
{
	//private static int sum = 0;
	//private static Lock lock = new ReentrantLock(); 
	private static AtomicInteger sum = new AtomicInteger(0);
	
	public static void multhreadProblem() {
		sum.set(0);
		Thread[] ths = new Thread[2];
		//System.out.println("Create thread ......");
		/**线程A: 采用匿名类**/
		ths[0] = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 1; i <= 10; i++) {
					sum.addAndGet(i);
					//synchronized(App.class) {
						//lock.lock();
						//sum = sum + i;
						//lock.unlock();
					    
					//}
				}
			}}, "A");
		
		ths[1] = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 11; i <= 20; i++) {
					sum.addAndGet(i);
					//synchronized(App.class) {
						//lock.lock();
						//sum = sum + i;
						//lock.unlock();
					//}
				}
			}}, "B");
		//System.out.println("Start thread ......");
		/**启动线程**/
		ths[0].start();
		ths[1].start();
		/**等待线程退出**/
		try{
			/**等线程过程中，会抛出检查异常**/
			ths[0].join();
			ths[1].join();
		}catch(Throwable t) {
			
		}
		//System.out.println("Wait for thread ......");
		if(sum.get() != 210) {
		    System.out.println("Sum is:" + sum.get());
		}
		
	}
	
	public static void threadPoolE() {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, /*最小线程数*/
				                                             Runtime.getRuntime().availableProcessors(), /*最大线程数*/
				                                             10, /*线程包活时长*/  
				                                             TimeUnit.SECONDS,
				                                             new LinkedBlockingDeque<>(1024),  /*最大队列*/
				                                             new ThreadPoolExecutor.DiscardOldestPolicy() /* 超过最大队列数，的除了*/);
		executor.execute(()->{ System.out.println("Hello");});
	}
	
	public static void main(String[] args ) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleWithFixedDelay(() -> { System.out.println("DDDDD");}, 5, 5, TimeUnit.SECONDS);
		try {
			Thread.sleep(30* 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testExceptions() {
		throw new RuntimeException("Test runtime exception");
	}
	
	public void testNonRuntimeExceptions() throws InterruptedException{
		if (Thread.interrupted())  // Clears interrupted status!
		      throw new InterruptedException();
	}
	
    public static void threadPool()
    {
        System.out.println( "Hello World!" );
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, /**corePoolSize:初始线程数**/
        		                                        Runtime.getRuntime().availableProcessors(), /**最大线程数**/
        		                                        5, /**线程最大空闲时***/
        		                                        TimeUnit.SECONDS, /***最大空闲5秒，超过5秒就被回收**/
        		                                        new LinkedBlockingDeque<Runnable>(256), /**控制任务队列大小，防止内存溢出**/
        		                                    	new ThreadPoolExecutor.DiscardOldestPolicy() /**超出队列大小，丢弃老的任务**/);
        for(int i = 0; i < 500; i++) {
        	int t = i;
        	tpe.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(t + ": is running.....");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(t + ": is over");
				}});
        }
        
        while((tpe.getActiveCount() > 0) || (!tpe.getQueue().isEmpty())) {
        	System.out.println("--->" + tpe.getActiveCount() + "," + tpe.getQueue().size());
        	/**等待线程池执行完毕，退出**/
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        System.out.println("Quit");
        tpe.shutdown();
        
    }
}
