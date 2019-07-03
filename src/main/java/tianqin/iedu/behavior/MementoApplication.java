package tianqin.iedu.behavior;

import java.util.LinkedList;
import java.util.Random;

public class MementoApplication {
	private static class State<T>{
		private T object;
		public State(T object) {
			super();
			this.object = object;
		}

		public T getObject() {
			return object;
		}		
	}
	
	private static class Mememto<T>{
		private State<T> state;
		public Mememto(State<T> state) {
			super();
			this.state = state;
		}
		
		public State<T> GetState(){
			return state;
		}
	}
	
	static class Originator{
		private Mememto<Integer> memmto;
		public Mememto<Integer> CreateMememto(){
			return memmto;
		}
		
		public void SetMemento(Mememto<Integer> m) {
			memmto = m;
		}
	}
	
	static class Caretaker{
		private LinkedList<Mememto<Integer>> mementos;
		private Originator originator;
		public Caretaker() {
			mementos = new LinkedList<>();
			originator = new Originator();
		}
		public void add(Mememto<Integer> m) {
			mementos.add(m);
		}
		
		public void run() {
			Mememto<Integer> start = new Mememto<>(new State<>(0));
			originator.SetMemento(start);
			int i = 0;
			Random rand=new Random();
			while(i < 100) {
				i++;
				int r = rand.nextInt(100);
				if((r % 2) == 0) {
					/**回退到上个状态**/
					if(mementos.isEmpty()) {
						System.out.println(i + ": Can not undo!!!!");
						continue;
					}else {
						/**回退：后进先出**/
						Mememto<Integer> old = mementos.removeFirst();
						int st = originator.CreateMememto().GetState().getObject();
						System.out.println(i + ": Can undo, back to: " + old.GetState().getObject() + " from :" + st);
						originator.SetMemento(old);
					}
				}else {
					/**产生新的状态，并保存老的状态**/
					Mememto<Integer> n = new Mememto<>(new State<>(r));
					/**保存老的状态**/
					mementos.addFirst(originator.CreateMememto());
					int st = originator.CreateMememto().GetState().getObject();
					System.out.println(i + ": Change to state: " + n.GetState().getObject() + " from :" + st);
					/**更新当前状态到新的状态**/
					originator.SetMemento(n);
					
				}
			}
		}
	}
	
	public static void run() {
		Caretaker caretaker = new Caretaker();
		caretaker.run();
	}

}
