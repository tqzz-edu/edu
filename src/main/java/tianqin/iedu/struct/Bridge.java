package tianqin.iedu.struct;

public abstract class Bridge {
	public Bridge(BridgeImpl impl) {this.impl = impl; }
	public abstract void pay(String args);
	protected BridgeImpl impl;
}
