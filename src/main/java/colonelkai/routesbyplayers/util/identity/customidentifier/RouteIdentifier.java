package colonelkai.routesbyplayers.util.identity.customidentifier;

import colonelkai.routesbyplayers.util.Node;

public class RouteIdentifier {

    Node nodeA;
    Node nodeB;

    public RouteIdentifier(Node nodeA, Node nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    @Override
    public int hashCode(){
        String nameA = this.nodeA.getIdentifier();
        String nameB = this.nodeB.getIdentifier();
        String finalString = "";

        if(nameA.compareTo(nameB)>0) {
            finalString = nameA + nameB;
        } else {
            finalString = nameB + nameA;
        }

        return  finalString.hashCode();
    }

    public Node getNodeA() {
        return nodeA;
    }

    public void setNodeA(Node nodeA) {
        this.nodeA = nodeA;
    }

    public Node getNodeB() {
        return nodeB;
    }

    public void setNodeB(Node nodeB) {
        this.nodeB = nodeB;
    }
}
