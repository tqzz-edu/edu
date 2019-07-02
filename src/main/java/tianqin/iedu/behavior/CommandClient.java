package tianqin.iedu.behavior;

import java.util.HashMap;
import java.util.Map;

public class CommandClient {
	private interface Command{
		void execute();
	}
	
	private class Receiver{
		public void openAction() {
			System.out.println("Receiver open action");
		}
		
		public void closeAction() {
			System.out.println("Receiver close action");
		}
		
		public void saveAction() {
			System.out.println("Receiver save action");
		}
		
		public void deleteAction() {
			System.out.println("Receiver delete action");
		}
	}
	
	private class OpenCommand implements Command{
		Receiver receiver;
		
		public OpenCommand(Receiver receiver) {
			this.receiver = receiver;
		}

		@Override
		public void execute() {
			System.out.println("open command");
			receiver.openAction();
		}
	}
	
	private class CloseCommand implements Command{
		Receiver receiver;
		
		public CloseCommand(Receiver receiver) {
			this.receiver = receiver;
		}

		@Override
		public void execute() {
			System.out.println("close command");
			receiver.closeAction();
		}
	}
	
	private class SaveCommand implements Command{
		Receiver receiver;
		
		public SaveCommand(Receiver receiver) {
			this.receiver = receiver;
		}

		@Override
		public void execute() {
			System.out.println("save command");
			receiver.saveAction();
		}
	}
	
	private class DeleteCommand implements Command{
		Receiver receiver;
		
		public DeleteCommand(Receiver receiver) {
			this.receiver = receiver;
		}

		@Override
		public void execute() {
			System.out.println("delete command");
			receiver.deleteAction();
		}
	}
	
	private class Invoker{
		private Map<String, Command> commands;
		private Receiver receiver;
		public Invoker() {
			commands = new HashMap<>();
			receiver = new Receiver();
			commands.put("open", new OpenCommand(receiver));
			commands.put("close", new CloseCommand(receiver));
			commands.put("save", new SaveCommand(receiver));
			commands.put("delete", new DeleteCommand(receiver));
		}
		
		public void action(String commandName) {
			String lname = commandName.toLowerCase();
			Command command = commands.get(lname);
			if(command != null) {
				command.execute();
			}
		}
	}
	
	public void doInvoker() {
		Invoker invoker = new Invoker();
		invoker.action("open");
	}
}
