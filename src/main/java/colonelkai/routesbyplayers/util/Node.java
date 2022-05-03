package colonelkai.routesbyplayers.util;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.util.identity.Identifiable;
import org.bukkit.Location;

import java.io.File;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class Node implements Identifiable.Serializable<String> {
    private Location location;
    private UUID owner;
    private String name;

    public Node(Location location, UUID owner, String name) {
        this.location = location;
        this.owner = owner;
        this.name = name;
    }

    public Set<Route> getRoutes() {
        // TODO here
        return null;
    }

    public Optional<Route> getRoute(Node otherNode) {
        return this.getRoutes()
                .parallelStream()
                .filter(route -> (route.containsNode(this) && route.containsNode(otherNode)))
                .findAny();
    }

    public int getTotalUpkeep() {
        return this
                .getRoutes()
                .stream()
                .mapToInt(Route::getUpkeep)
                .sum();
    }

    // region getset


    public UUID getOwner() {
        return this.owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String getIdentifier() {
        return this.name;
    }

    @Override
    public void setIdentifier(String element) {
        this.name = element;
    }

    @Override
    public File getFile() {
        return new File(RoutesByPlayers.getPlugin().getDataFolder(),
                "data/node/" + this.name + ".yml");
    }

    // endregion
}
