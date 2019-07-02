package tianqin.iedu;

import tianqin.iedu.behavior.ChainClient;
import tianqin.iedu.facatory.Factory;
import tianqin.iedu.facatory.FruitFactory;
import tianqin.iedu.facatory.NutritionFacts;
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
        
        // 采用构建器 初始化
        NutritionFacts cocaCola = new NutritionFacts.Builder().setServingSize(240)
        		.setServings(8).setCalories(100).setSodium(35).setCarbohydrate(27).build();
        
        ChainClient ccl = new ChainClient();
        ccl.invoker();
    }
}
