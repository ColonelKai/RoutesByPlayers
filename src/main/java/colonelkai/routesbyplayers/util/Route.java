package colonelkai.routesbyplayers.util;

import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.identity.Identifiable;
import colonelkai.routesbyplayers.util.identity.customidentifier.RouteIdentifier;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class Route implements Identifiable.Serializable<RouteIdentifier>, Comparable<Route> {
    private @Nullable Node node1;
    private @Nullable Node node2;
    private int Node1Price;
    private int Node2Price;

    public @NotNull Node getFirstNode() {
        if (this.node1 == null) {
            throw new IllegalStateException("Node 1 has not been set");
        }
        return this.node1;
    }

    public @NotNull Node getSecondNode() {
        if (this.node2 == null) {
            throw new IllegalStateException("Node 2 has not been set");
        }
        return this.node2;
    }

    public @NotNull Node getNode(int nodeNumber) {
        switch (nodeNumber) {
            case 1:
                return this.getFirstNode();
            case 2:
                return this.getSecondNode();
            default:
                throw new IndexOutOfBoundsException("Invalid nodeNumber, can only accept either 1 or 2");

        }
    }

    public boolean containsNode(Node node) {
        return (this.getFirstNode().equals(node) || this.getSecondNode().equals(node));
    }

    public int getUpkeep() {
        Location a = this.getFirstNode().getLocation();
        Location b = this.getSecondNode().getLocation();

        return (int) Math.round(
                // calculate distances between a and b
                Math.sqrt(StrictMath.pow(a.getX() - b.getX(), 2) + StrictMath.pow(a.getY() - b.getY(), 2) + StrictMath.pow(a.getZ() + b.getZ(), 2))
                        // divide it with the amount of blocks 1 currency will cover
                        / Managers.getInstance().getConfigManager().getUpkeepAmount());
    }


    @Override
    public @NotNull RouteIdentifier getIdentifier() {
        return new RouteIdentifier(this.getNode(1), this.getNode(2));
    }

    //SEE WHAT I MEAN BY IT MAKES NO SENSE
    @Override
    public void setIdentifier(@NotNull RouteIdentifier element) {
        this.node1 = element.getNodeA();
        this.node2 = element.getNodeB();
    }

    @Override
    public @NotNull File getFile(@NotNull File file) {
        return new File(file.getPath() + this.getIdentifier().getId() + ".yml");
    }

    @Override
    public int compareTo(@NotNull Route o) {
        return this.getIdentifier().compareTo(o.getIdentifier());
    }

    public int getNode1Price() {
        return this.Node1Price;
    }

    public void setNode1Price(int node1Price) {
        this.Node1Price = node1Price;
    }

    public int getNode2Price() {
        return this.Node2Price;
    }

    public int getTotalPrice() {
        return this.Node1Price + this.Node2Price;
    }

    public void setNode2Price(int node2Price) {
        this.Node2Price = node2Price;
    }
}


