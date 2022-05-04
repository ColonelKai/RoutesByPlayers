package colonelkai.routesbyplayers.manager;

import colonelkai.routesbyplayers.util.identity.Identifiable;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public interface Manager<V, T extends Identifiable.Serializable<V>> {

    Collection<T> getElements();

    T load(File file);

    void save(T value) throws IOException;

    boolean add(T element);

    boolean addAll(Collection<? extends T> elements);

    boolean remove(T element);

    Optional<T> getBy(V value);

    default void saveAll() {
        for (T element : this.getElements()) {
            try {
                this.save(element);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    default Collection<T> reloadAll() {
        Collection<T> loaded = this.loadAll();
        this.addAll(loaded);
        return loaded;
    }

    default Collection<T> loadAll() {
        return this.loadAll(this.getParentFolder());
    }

    default Collection<T> loadAll(File folder) {
        File[] files = folder.listFiles();
        if (files == null) {
            return Collections.emptyList();
        }
        return Arrays.stream(files).map(file -> {
            try {
                return this.load(file);
            } catch (Exception e) {
                e.printStackTrace();
                //noinspection ReturnOfNull
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    File getParentFolder();

}

