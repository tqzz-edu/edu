package tianqin.iedu.struct;

public class ConcreteDecoratorB extends Decorator{
	private int times;
	

	public ConcreteDecoratorB(Component com) {
		super(com);
		times = 0;
	}
	
	@Override
	public boolean filter(String condition) {
		boolean b = super.filter(condition);
		incTimes();
		return b;
	}

	@Override
	public void add(Component c) {
		super.add(c);
		incTimes();
	}

	@Override
	public void remove(Component c) {
		super.remove(c);
		incTimes();
	}

	@Override
	public Component getChild(int d) {
		Component com =  super.getChild(d);
		incTimes();
		return com;
	}
	
	
	private void incTimes() {
		times = times + 1;
	}

}
