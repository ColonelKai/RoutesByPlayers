package colonelkai.routesbyplayers.util;

import colonelkai.routesbyplayers.config.ConfigManager;
import colonelkai.routesbyplayers.util.identity.Identifiable;
import colonelkai.routesbyplayers.util.identity.customidentifier.RouteIdentifier;
import org.bukkit.Location;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

public class Route implements Identifiable<RouteIdentifier> {
    private Node node1;
    private Node node2;

    public Node getNode(int nodeNumber) throws IOException {
        if(nodeNumber == 1) {
            return node1;
        }
        else if(nodeNumber==2) {
            return node2;
        }
        throw new IOException("Invalid parameter passed to getNode(), must be between 1 and 2.");
    }

    public boolean containsNode(Node node) {
        return (node1.equals(node) || node2.equals(node));
    }

    public int getUpkeep() {
        Location a = node1.getLocation();
        Location b = node2.getLocation();

        return (int) Math.round(
                // calculate distances between a and b
                Math.sqrt( Math.pow(a.getX()-b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2) + Math.pow(a.getZ()+b.getZ(), 2))
                // divide it with the amount of blocks 1 currency will cover
                /  ConfigManager.getUpkeepAmount());
    }


    @Override
    public RouteIdentifier getIdentifier() {
        return new RouteIdentifier(node1, node2);
    }

    @Override
    public void setIdentifier(RouteIdentifier element) {
        this.node1=element.getNodeA();
        this.node2=element.getNodeB();
    }
}
