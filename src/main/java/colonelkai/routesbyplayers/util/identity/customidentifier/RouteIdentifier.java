package colonelkai.routesbyplayers.util.identity.customidentifier;

import colonelkai.routesbyplayers.util.Node;
import org.jetbrains.annotations.NotNull;

public class RouteIdentifier implements Comparable<RouteIdentifier> {

    private @NotNull Node nodeA;
    private @NotNull Node nodeB;

    public RouteIdentifier(@NotNull Node nodeA, @NotNull Node nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public boolean contains(@NotNull Node node) {
        if (node.equals(this.nodeA)) {
            return true;
        }
        return node.equals(this.nodeB);
    }

    public @NotNull String getId() {
        String nameA = this.nodeA.getIdentifier();
        String nameB = this.nodeB.getIdentifier();

        if (nameA.compareTo(nameB) > 0) {
            return (nameA + nameB);
        } else {
            return (nameB + nameA);
        }
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RouteIdentifier)) {
            return false;
        }
        RouteIdentifier identifier = (RouteIdentifier) obj;
        return identifier.contains(this.nodeA) && identifier.contains(this.nodeB);
    }

    public @NotNull Node getNodeA() {
        return this.nodeA;
    }

    //SET NODE IN THIS MAKES NO SENSE
    public void setNodeA(Node nodeA) {
        this.nodeA = nodeA;
    }

    public @NotNull Node getNodeB() {
        return this.nodeB;
    }

    //SET NODE IN THIS MAKES NO SENSE
    public void setNodeB(Node nodeB) {
        this.nodeB = nodeB;
    }

    @Override
    public int compareTo(@NotNull RouteIdentifier o) {
        return this.getId().compareTo(o.getId());
    }
}
