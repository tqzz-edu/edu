package tianqin.iedu;

import java.util.Iterator;
import java.util.LinkedList;

public class ProducerConsumer {
	private static int MAX_TIMES = 1000;
	private LinkedList<Integer> items;
	private Thread[] ths;
	/**volatile: 具有更新线程可见性、有序性，不具备原子性**/
	private volatile int times;
	
	public ProducerConsumer() {
		/**共享队列**/
		items = new LinkedList<>();
		/**保存线程对象**/
		ths = new Thread[2];
		/**共享数次**/
		times = 0;
		
		/**采用实现Runnable 的Lambada表达式**/
		ths[0] = new Thread(()->{ produce();}, "Name.Producer");
		/**采用start 启动**/
		ths[0].start();
		
		ths[1] = new Thread(()->{ consume();}, "Name.Consume");
		ths[1].start();
	}
	
	public void waitThread() {
		for(Thread th: ths) {
			try {
				/**等待线程退出**/
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private void produce() {
		/***生产者线程***/
		while((times < MAX_TIMES)) {
			/**模拟根据不同的速度进行产品生产**/
			int sum = (int)(Math.random() * 10);
			/**由于：items 是共享数据，并且是非线程安全，则需要进行同步保护**/
			for(int i = 0; i < sum; i++) {
				Integer v = Integer.valueOf((int)(Math.random() * 10000));
				synchronized (this) {
					/**放入队列**/
					items.add(v);
					/**唤醒消费者**/
					this.notify();
				}
			}
			try{
				Thread.sleep(sum * 100 + 20);
			}catch(Throwable t) {
				
			}
			
			times = times + sum;
		}
	}
	
	private void consume() {
		/***消费者线程**/
		LinkedList<Integer> curList = new LinkedList<>();
		while((times < MAX_TIMES)) {
			synchronized (this) {
				if(items.isEmpty()) {
					/**队列为空，消费者进行休息**/
					try{
						this.wait();
					}catch(Throwable t) {
					}
				}
				/**如果消费 是一个耗时的过程，则建议先用队列缓存，减少同步块的时间**/
				Iterator<Integer> it = items.iterator();
				while(it.hasNext()) {
					curList.add(it.next());
					it.remove();
				}	
			}
			
			Iterator<Integer> it = curList.iterator();
			while(it.hasNext()) {
				System.out.println("Consume:" + it.next());
				it.remove();
			}
			
			try{
				Thread.sleep((int)(Math.random() * 10) * 100 + 20);
			}catch(Throwable t) {
				
			}
		}
	}
}
