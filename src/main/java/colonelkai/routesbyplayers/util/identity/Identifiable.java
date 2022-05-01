package colonelkai.routesbyplayers.util.identity;

public interface Identifiable<T> {

    public T getIdentifier();
    public void setIdentifier(T element);
}
