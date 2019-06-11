package tianqin.iedu.struct;

public class RefinedBridge extends Bridge{

	public RefinedBridge(BridgeImpl impl) {
		super(impl);
	}

	@Override
	public void pay(String args) {
		// do some things 
		impl.pay(args);	
	}

}
