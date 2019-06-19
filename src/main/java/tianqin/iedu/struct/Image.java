package tianqin.iedu.struct;

public class Image implements Graphic {

	@Override
	public void Draw(Point point) {
		System.out.println(String.format("Draw point(%d, %d)", point.x, point.y));
	}

}
