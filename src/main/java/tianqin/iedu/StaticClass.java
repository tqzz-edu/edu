package tianqin.iedu;

/**
 * StaticClass
 * 
 * @author gorging
 * @date 2019/07/26
 */
public class StaticClass {
    /**
     * InnerClass
     * 
     * @author gorging
     * @date 2019/07/26
     */
    class InnerClass {
        public void sayHello() {
            System.out.println("Hello world");
        }
    }

    public static void main(String[] args) {
        InnerClass inner = new StaticClass().new InnerClass();
        inner.sayHello();
    }

}
