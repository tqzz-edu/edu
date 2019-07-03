package tianqin.iedu.behavior;

import java.util.LinkedList;

public class ObserverApplication {
	interface Observer{
		void Update(int value);
	}
	
	interface Subject{
		void Attach(Observer o);
		void Detach(Observer o);
		void NotifyEvent(int value);
	}
	
	class ConcreteSubject implements Subject{
		private LinkedList<Observer> observers;
		
		public ConcreteSubject() {
			observers = new LinkedList<>();
		}
		
		@Override
		public void Attach(Observer o) {
			observers.add(o);
		}

		@Override
		public void Detach(Observer o) {
			observers.remove(o);
		}

		@Override
		public void NotifyEvent(int value) {
			/**广播通知**/
			for(Observer o : observers) {
				o.Update(value);
			}
		}
	}
	
	class ObserverA implements Observer{

		@Override
		public void Update(int value) {
			System.out.println("ObserverA get value:" + value);
			/**处理自己的逻辑**/
		}
	}
	
	
	class ObserverB implements Observer{

		@Override
		public void Update(int value) {
			System.out.println("ObserverB get value:" + value);
			/**处理自己的逻辑**/
		}
	}
	
	public void run() {
		Subject subject = new ConcreteSubject();
		subject.Attach(new ObserverA());
		subject.Attach(new ObserverB());
		for(int v = 0; v < 1000; v++) {
			subject.NotifyEvent(v);
		}
	}
	

}
