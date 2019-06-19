package tianqin.iedu.struct;

public class ImageProxy implements Graphic{
	private Image image;
	public ImageProxy() {
		image = new Image();
	}

	@Override
	public void Draw(Point point) {
		image.Draw(point);
	}

}
