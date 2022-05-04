package colonelkai.routesbyplayers.config.key;

import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractSerializationKey<T> implements SerializationKey<T> {

    private final @NotNull String node;

    protected AbstractSerializationKey(@NotNull String node) {
        this.node = node;
    }

    @Override
    public void set(@NotNull FileConfiguration configuration, @Nullable T value) {
        configuration.set(this.getNode(), value);
    }

    @Override
    public int hashCode() {
        return this.node.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SerializationKey)) {
            return false;
        }
        SerializationKey<?> key = (SerializationKey<?>) obj;
        return key.getNode().equals(this.node);
    }

    @Override
    public @NotNull String getNode() {
        return this.node;
    }
}
