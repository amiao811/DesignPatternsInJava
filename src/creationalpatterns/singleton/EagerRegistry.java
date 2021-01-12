package creationalpatterns.singleton;

/**
 * Singleton - Eager singleton
 * Create singleton as soon as class is loaded
 */
public class EagerRegistry {
    // 1. make constructor private to prevent someone from initiating instance by constructor
    private EagerRegistry() {}

    // 2. New EagerRegistry instance here and make it static so the instance are created as soon as the class are loaded.
    private static final EagerRegistry INSTANCE = new EagerRegistry();

    // 3. provide a public method to allow people get EagerRegistry instance
    public static EagerRegistry getInstance() {
        return INSTANCE;
    }
}
