package tianqin.iedu.struct;

public interface Component {
	boolean filter(String condition);
	void add(Component c);
	void remove(Component c);
	Component getChild(int d);
}
