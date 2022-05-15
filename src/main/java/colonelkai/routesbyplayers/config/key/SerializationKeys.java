package colonelkai.routesbyplayers.config.key;

public interface SerializationKeys {
    UUIDKey OWNER = new UUIDKey("owner");
    IntegerKey AMOUNT = new IntegerKey("amount");
    LocationKey LOCATION = new LocationKey("location");
    IntegerKey NODE1PRICE = new IntegerKey("nodeprice.one");
    IntegerKey NODE2PRICE = new IntegerKey("nodeprice.two");
    StringKey NAME = new StringKey("name");
    RouteIdentifierKey ROUTE_IDENTIFIER = new RouteIdentifierKey("nodeidentifier");
    BooleanKey USE_VAULT = new BooleanKey("Currency.Vault.Use");
    DoubleKey UPKEEP_AMOUNT = new DoubleKey("Upkeep.Amount");
    ItemKey UPKEEP_ITEM = new ItemKey("Upkeep.Item");
    BooleanKey NODES_PUBLIC = new BooleanKey("Nodes.Public");
    BooleanKey NODES_DYNMAP = new BooleanKey("Nodes.Dynmap");
    IntegerKey ROUTE_DISTANCE_MIN = new IntegerKey("Route.Distance.Minimum");
    IntegerKey NODES_MAXIMUM = new IntegerKey("Nodes.Maximum");
}
