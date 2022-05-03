package colonelkai.routesbyplayers.config.key;

import colonelkai.routesbyplayers.util.identity.customidentifier.RouteIdentifier;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class RouteIdentifierKey extends AbstractSerializationKey<RouteIdentifier> {
    protected RouteIdentifierKey(@NotNull String node) {
        super(node);
    }

    @Override // have to override this because RouteIdentifier is a special boy who needs special treatment
    public void set(@NotNull YamlConfiguration configuration, @Nullable RouteIdentifier value) {
        configuration.set(this.getNode()+".nodeA", value.getNodeA().getIdentifier());
        configuration.set(this.getNode()+".nodeB", value.getNodeB().getIdentifier());

    }

    @Override
    public @NotNull Optional<RouteIdentifier> get(@NotNull YamlConfiguration configuration) {
        String NodeAIdentifier = configuration.getString(this.getNode()+".nodeA");
        String NodeBIdentifier = configuration.getString(this.getNode()+".nodeB");

        // now we have to access already loaded NodeA and NodeB data from the identifiers.
        // TODO after we have implemented main class handling of manager classes.

        return Optional.empty();
    }
}
