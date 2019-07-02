package tianqin.iedu.behavior;

public class ChainClient {
	private abstract class Handler{
		private Handler successor;
		private String topic;
		public Handler(String topic) { this.topic = topic; }
		
		public void setSuccessor(Handler successor) {
			if(this.successor == successor) {
				/**防止死循环**/
				return ;
			}
			this.successor = successor;
		}

		public Handler getSuccessor() { return this.successor; }
		public void handle(String topic) {
			if(topic == null) {
				/******/
				return ;
			}
			
			if(topic.equals(this.topic)) {
				System.out.println("Handle topic:" + topic);
				this.doRequest();
			}else if(successor != null){
				successor.handle(topic);
			}else {
				System.out.println(String.format("Find none such topic %s handler", topic));
			}	
		}
		
		protected abstract void doRequest();
	}
	
	private class AHandler extends Handler {
		public AHandler() {
			super("A");
		}

		@Override
		protected void doRequest() {
			System.out.println("AHandler to something");
		}
		
	}
	
	private class BHandler extends Handler {
		public BHandler() {
			super("B");
		}

		@Override
		protected void doRequest() {
			System.out.println("BHandler to something");
		}
		
	}
	
	private class CHandler extends Handler {
		public CHandler() {
			super("C");
		}

		@Override
		protected void doRequest() {
			System.out.println("CHandler to something");
		}
		
	}
	
	public void invoker() {
		Handler handler = new AHandler();
		handler.setSuccessor(new BHandler());
		handler.getSuccessor().setSuccessor(new CHandler());
		
		handler.handle("ABC");
		handler.handle("C");
	}
	

}
