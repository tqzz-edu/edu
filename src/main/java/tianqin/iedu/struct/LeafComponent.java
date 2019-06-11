package tianqin.iedu.struct;

public class LeafComponent implements Component{

	@Override
	public boolean filter(String condition) {
		/**匹配规则**/
		return condition.endsWith("Hilhhh");
	}

	@Override
	public void add(Component c) {
		
	}

	@Override
	public void remove(Component c) {
		
	}

	@Override
	public Component getChild(int d) {
		return null;
	}

}
