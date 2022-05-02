package colonelkai.routesbyplayers.manager;

import colonelkai.routesbyplayers.util.identity.Identifiable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

public abstract class AbstractManager<V, T extends Identifiable.Serializable<V>> implements Manager<V, T> {

    private final Collection<T> elements = new HashSet<>();

    @Override
    public Collection<T> getElements() {
        return Collections.unmodifiableCollection(this.elements);
    }

    @Override
    public boolean add(T element) {
        return this.elements.add(element);
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
