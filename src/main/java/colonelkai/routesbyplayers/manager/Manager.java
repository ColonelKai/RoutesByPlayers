package colonelkai.routesbyplayers.manager;

import colonelkai.routesbyplayers.util.identity.Identifiable;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/*
every single class that implements manager needs a better system for saving
data, but I'm so frustrated to the point that I can't be arsed anymore.
If you're picking up the rubble after I've left, or if you're mose, I'm sorry.
 */

public interface Manager<V, T extends Identifiable.Serializable<V>> {

    Collection<T> getElements();

    T load(File file);

    void save(T value) throws IOException;

    boolean add(T element);

    boolean remove(T element);

    Optional<T> getBy(V value);

    File getDefaultLocation();

    default void saveAll() {
        for (T element : this.getElements()) {
            try {
                this.save(element);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toSet());
    }


    /*default boolean add(T element) {
        if(this.checkIfContains(element)) {
            return false;
        }
        else {
            this.getElements().add(element);
            return true;
        }
   }*/

   /*default boolean remove(T element) {
        Optional<T> toRemove = this.getSet()
                .parallelStream()
                .filter(t -> (t.getIdentifier().hashCode()==element.getIdentifier().hashCode()))
                .findAny();
        if(!toRemove.isPresent()) {
            return false;
        }
        this.getSet().remove(toRemove.get());
        return true;
   }*/

   /*default T get(int hashcode) {
        Optional<T> optionalT = this.getSet().parallelStream()
                .filter(t->(t.getIdentifier().hashCode()==hashcode))
                .findAny();

       return optionalT.orElse(null);
   }*/

    /*default boolean checkIfContains(T element) {
        return


        return this.getSet()
                .parallelStream()
                .anyMatch(e -> (e.getIdentifier().hashCode()==element.getIdentifier().hashCode()));
    }*/

}

