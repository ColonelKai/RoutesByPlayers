package colonelkai.routesbyplayers.config.key;

import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.Node;
import colonelkai.routesbyplayers.util.identity.customidentifier.RouteIdentifier;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class RouteIdentifierKey extends AbstractSerializationKey<RouteIdentifier> {
    protected RouteIdentifierKey(@NotNull String node) {
        super(node);
    }

    @Override // have to override this because RouteIdentifier is a special boy who needs special treatment
    public void set(@NotNull FileConfiguration configuration, @Nullable RouteIdentifier value) {
        if (value == null) {
            configuration.set(this.getNode(), null);
            return;
        }
        configuration.set(this.getNode() + ".nodeA", value.getNodeA().getIdentifier());
        configuration.set(this.getNode() + ".nodeB", value.getNodeB().getIdentifier());

    }

    @Override
    public @NotNull Optional<RouteIdentifier> get(@NotNull FileConfiguration configuration) {
        String NodeAIdentifier = configuration.getString(this.getNode() + ".nodeA");
        String NodeBIdentifier = configuration.getString(this.getNode() + ".nodeB");

        Optional<Node> nodeA = Managers.getInstance().getNodeManager().getBy(NodeAIdentifier);
        Optional<Node> nodeB = Managers.getInstance().getNodeManager().getBy(NodeBIdentifier);

        if (!nodeA.isPresent() || !nodeB.isPresent()) {
            return Optional.empty();
        }

        return Optional.of(new RouteIdentifier(nodeA.get(), nodeB.get()));

    }
}
