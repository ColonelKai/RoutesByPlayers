package colonelkai.routesbyplayers.singletons;

import colonelkai.routesbyplayers.util.identity.Identifiable;

import java.io.File;
import java.util.Collection;

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
