package colonelkai.routesbyplayers.config.key;

import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public interface SerializationKey<T> {

    @NotNull Optional<T> get(@NotNull YamlConfiguration configuration);

    void set(@NotNull YamlConfiguration configuration, @Nullable T value);

    @NotNull String getNode();
}
