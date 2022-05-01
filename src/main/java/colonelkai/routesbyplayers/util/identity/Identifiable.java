package colonelkai.routesbyplayers.util.identity;

import java.io.File;

public interface Identifiable<T> {

    interface Serializable<T> extends Identifiable<T> {
        File getFile();
    }

    T getIdentifier();

    //if the identifier is used for saving .... you want to ensure this cannot change
    void setIdentifier(T element);
}
