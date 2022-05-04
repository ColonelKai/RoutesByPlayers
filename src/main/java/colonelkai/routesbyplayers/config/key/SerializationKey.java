package colonelkai.routesbyplayers.config.key;

import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public interface SerializationKey<T> {

    @NotNull Optional<T> get(@NotNull FileConfiguration configuration);

    void set(@NotNull FileConfiguration configuration, @Nullable T value);

    @NotNull String getNode();
}
