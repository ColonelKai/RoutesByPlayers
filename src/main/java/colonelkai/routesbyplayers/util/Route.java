package colonelkai.routesbyplayers.util;

import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.identity.Identifiable;
import colonelkai.routesbyplayers.util.identity.customidentifier.RouteIdentifier;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class Route implements Identifiable.Serializable<RouteIdentifier>, Comparable<Route> {
    private Node node1;
    private Node node2;

    public Node getNode(int nodeNumber) throws IOException {
        if (nodeNumber == 1) {
            return this.node1;
        } else if (nodeNumber == 2) {
            return this.node2;
        }
        throw new IOException("Invalid parameter passed to getNode(), must be between 1 and 2.");
    }

    public boolean containsNode(Node node) {
        return (this.node1.equals(node) || this.node2.equals(node));
    }

    public int getUpkeep() {
        Location a = this.node1.getLocation();
        Location b = this.node2.getLocation();

        return (int) Math.round(
                // calculate distances between a and b
                Math.sqrt(StrictMath.pow(a.getX() - b.getX(), 2) + StrictMath.pow(a.getY() - b.getY(), 2) + StrictMath.pow(a.getZ() + b.getZ(), 2))
                        // divide it with the amount of blocks 1 currency will cover
                        / Managers.getInstance().getConfigManager().getUpkeepAmount());
    }


    @Override
    public RouteIdentifier getIdentifier() {
        return new RouteIdentifier(this.node1, this.node2);
    }

    //SEE WHAT I MEAN BY IT MAKES NO SENSE
    @Override
    public void setIdentifier(RouteIdentifier element) {
        this.node1 = element.getNodeA();
        this.node2 = element.getNodeB();
    }

    @Override
    public File getFile(File file) {
        return new File(file.getPath() + this.getIdentifier().getId() + ".yml");
    }

    @Override
    public int compareTo(@NotNull Route o) {
        return this.getIdentifier().compareTo(o.getIdentifier());
    }
}
