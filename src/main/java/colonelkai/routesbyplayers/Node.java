package colonelkai.routesbyplayers;

import colonelkai.routesbyplayers.path.Route;
import org.bukkit.Location;

import java.util.Set;
import java.util.UUID;

public class Node {
    private Location location;
    private UUID owner;
    private String name;

    public Node(Location location, UUID owner, String name) {
        this.location = location;
        this.owner = owner;
        this.name = name;
    }

    public Set<Route> getPaths() {
        // TODO here
        return null;
    }

    public int getTotalUpkeep() {
        // TODO here
        return Integer.MIN_VALUE;
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

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }
    // endregion
}
