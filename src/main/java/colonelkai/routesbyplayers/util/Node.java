package colonelkai.routesbyplayers.util;

import colonelkai.routesbyplayers.util.identity.Identifiable;
import org.bukkit.Location;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class Node implements Identifiable<String> {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
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

    // endregion
}
