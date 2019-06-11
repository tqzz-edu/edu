package tianqin.iedu.struct;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
	private List<Component> children;
	
	public Composite() {
		children = new ArrayList<>();
	}

	@Override
	public boolean filter(String condition) {
		for(Component com:children) {
			if(com.filter(condition)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(Component c) {
		for(Component com:children) {
			/**判断同引用是否被添加多次**/
			if(com == c) {
				return ;
			}
		}
		
		children.add(c);
	}

	@Override
	public void remove(Component c) {
		children.remove(c);
	}

	@Override
	public Component getChild(int d) {
		if(d >= children.size()) {
			return null;
		}
		
		return children.get(d);
	}

}
