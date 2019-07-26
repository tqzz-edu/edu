package tianqin.iedu.behavior;

import java.util.Random;

public class StateApplication {
	interface State{
		void Handle();
	}
	
	/**防御状态**/
	class DefenseState implements State{
		@Override
		public void Handle() {
			System.out.println("Hero is defending");
		}
		
	}
	
	/**攻击状态**/
	class AttackState implements State{
		@Override
		public void Handle() {
			System.out.println("Hero is attacking");
		}
		
	}
	
	/**隐身状态**/
	class StealthState implements State{
		@Override
		public void Handle() {
			System.out.println("Hero is in stealth");
		}
		
	}
	
	class RunState implements State{
		@Override
		public void Handle() {
			System.out.println("Hero is running");
		}
	}
	
	class QuietState implements State{
		@Override
		public void Handle() {
			System.out.println("Hero is still");
		}
	}
	
	class Context{
		private String curAction;
		private State state;
		public Context() {
			curAction = "quiet";
			state = new QuietState();
			state.Handle();
		}
		public void Request(String action) {
			String act = action.toLowerCase();
			if(act.equals(curAction)) {
				state.Handle();
				return ;
			}
			
			curAction = act;
			switch(act) {
			case "quiet":
				state = new QuietState();
				break;
			case "attack":
				state = new AttackState();
				break;
			case "defense":
				state = new DefenseState();
				break;
			case "stealth":
				state = new StealthState();
				break;
			case "run":
				state = new RunState();
				break;
			default:
				System.out.println("Invalid operation");
				break;
			}
			state.Handle();
			
		}
	}
		
	public void run() {
		Context context = new Context();
		String[] actions = new String[] {"quiet", "attack", "defense", "stealth", "run"};
		Random rand = new Random();
		for(int i = 0; i < 20; i++) {
			int v = rand.nextInt(actions.length);
			System.out.println("Times:" + i);
			context.Request(actions[v]);
		}
	}
	
	 

}
