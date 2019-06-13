package tianqin.iedu.struct;

public class Decorator implements Component{
	private Component component;
	public Decorator(Component com) {
		this.component = com;
	}

	@Override
	public boolean filter(String condition) {
		return component.filter(condition);
	}

	@Override
	public void add(Component c) {
		component.add(c);
	}

	@Override
	public void remove(Component c) {
		component.remove(c);
	}

	@Override
	public Component getChild(int d) {
		return component.getChild(d);
	}

}
