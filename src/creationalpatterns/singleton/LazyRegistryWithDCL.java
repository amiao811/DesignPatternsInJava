package creationalpatterns.singleton;
/**
 * Classic singleton demonstration
 * A lazy initializing singleton
 * Use double lock & volatile to make sure multi-thread issue would not happen.
 */
public class LazyRegistryWithDCL {
    // 1. make constructor private to prevent someone from initiating instance by constructor
    private LazyRegistryWithDCL(){}

    private static volatile LazyRegistryWithDCL INSTANCE;

    public LazyRegistryWithDCL getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyRegistryWithDCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyRegistryWithDCL();
                }
            }
        }
        return INSTANCE;
    }

}
