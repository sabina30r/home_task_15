package nix.edu.factory;

public interface ObjectFactory {
    <T> T getObjectInstance(Class<T> type);
}
