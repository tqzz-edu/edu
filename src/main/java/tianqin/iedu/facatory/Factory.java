package tianqin.iedu.facatory;

public interface Factory {
	public Product CreateProduct();
	public Product CreateProduct(String type);
}
