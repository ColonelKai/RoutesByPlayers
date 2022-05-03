package colonelkai.routesbyplayers.util.identity;

import java.io.File;

public interface Identifiable<T> {

    interface Serializable<T> extends Identifiable<T> {
        File getFile(File file);
    }

    T getIdentifier();

    //if the identifier is used for saving .... you want to ensure this cannot change
    void setIdentifier(T element);
}
