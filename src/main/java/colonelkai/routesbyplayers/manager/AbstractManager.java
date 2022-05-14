package colonelkai.routesbyplayers.manager;

import colonelkai.routesbyplayers.util.identity.Identifiable;

import java.io.IOException;
import java.util.*;

public abstract class AbstractManager<V, T extends Identifiable.Serializable<V>> implements Manager<V, T> {

    private final Collection<T> elements = new HashSet<>();

    @Override
    public Collection<T> getElements() {
        return Collections.unmodifiableCollection(this.elements);
    }

    @Override
    public boolean add(T element) throws IOException {
        if(Arrays.stream(element.getClass().getDeclaredFields()).anyMatch(Objects::isNull)) {
            throw new IOException("Tried to add element to manager with null field.");
        }
        return this.elements.add(element);
    }

    @Override
    public boolean addAll(Collection<? extends T> elements) {
        return this.elements.addAll(elements);
    }

    @Override
    public boolean remove(T element) {
        return this.elements.remove(element);
    }

    @Override
    public Optional<T> getBy(V value) {
        return this.elements.parallelStream().filter(ident -> ident.getIdentifier().equals(value)).findFirst();
    }

}
