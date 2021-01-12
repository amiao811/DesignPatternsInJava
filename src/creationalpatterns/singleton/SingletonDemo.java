package creationalpatterns.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        EagerRegistry eagerRegistry1 = EagerRegistry.getInstance();
        EagerRegistry eagerRegistry2 = EagerRegistry.getInstance();
        System.out.println(eagerRegistry1 == eagerRegistry2); // true


    }
}
