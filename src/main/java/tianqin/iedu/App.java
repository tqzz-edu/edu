package tianqin.iedu;

import tianqin.iedu.facatory.Factory;
import tianqin.iedu.facatory.FruitFactory;
import tianqin.iedu.facatory.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Factory factory = new FruitFactory();
        Product product = factory.CreateProduct();
        product.show();
    }
}
