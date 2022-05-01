package colonelkai.routesbyplayers.singletons;

import colonelkai.routesbyplayers.util.identity.Identifiable;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

/*
every single class that implements manager needs a better system for saving
data, but I'm so frustrated to the point that I can't be arsed anymore.
If you're picking up the rubble after I've left, or if you're mose, I'm sorry.
 */

public interface Manager<T extends Identifiable> {
    public boolean saveAll(File folder);
    public boolean loadAll(File folder);


    public Collection<T> getSet();

    default boolean add(T element) {
        if(this.checkIfContains(element)) {
            return false;
        }
        else {
            this.getSet().add(element);
            return true;
        }
   }

   default boolean remove(T element) {
        Optional<T> toRemove = this.getSet()
                .parallelStream()
                .filter(t -> (t.getIdentifier().hashCode()==element.getIdentifier().hashCode()))
                .findAny();
        if(!toRemove.isPresent()) {
            return false;
        }
        this.getSet().remove(toRemove.get());
        return true;
   }

   default T get(int hashcode) {
        Optional<T> optionalT = this.getSet().parallelStream()
                .filter(t->(t.getIdentifier().hashCode()==hashcode))
                .findAny();

       return optionalT.orElse(null);
   }

    default boolean saveAll() {
       return saveAll(this.getDefaultLocation());
   }

    default boolean checkIfContains(T element) {
        return this.getSet()
                .parallelStream()
                .anyMatch(e -> (e.getIdentifier().hashCode()==element.getIdentifier().hashCode()));
    }

    public File getDefaultLocation();

}

