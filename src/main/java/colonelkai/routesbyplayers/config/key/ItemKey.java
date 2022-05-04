package colonelkai.routesbyplayers.config.key;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ItemKey extends AbstractSerializationKey<Material> {

    ItemKey(@NotNull String node) {
        super(node);
    }

    @Override
    public void set(@NotNull FileConfiguration configuration, @Nullable Material value) {
        if (value == null) {
            configuration.set(this.getNode(), null);
            return;
        }
        if (!value.isItem()) {
            throw new IllegalArgumentException("Material must be item");
        }
        configuration.set(this.getNode(), value.name());
    }

    @Override
    public @NotNull Optional<Material> get(@NotNull FileConfiguration configuration) {
        String materialName = configuration.getString(this.getNode());
        if (materialName == null) {
            return Optional.empty();
        }
        Material material = Material.getMaterial(materialName);
        return Optional.ofNullable(material);
    }
}
