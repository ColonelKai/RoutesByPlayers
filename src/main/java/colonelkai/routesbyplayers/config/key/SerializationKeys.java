package colonelkai.routesbyplayers.config.key;

public interface SerializationKeys {
    UUIDKey OWNER = new UUIDKey("owner");
    IntegerKey AMOUNT = new IntegerKey("amount");
    LocationKey LOCATION = new LocationKey("location");
    IntegerKey NODE1PRICE = new IntegerKey("nodeprice.one");
    IntegerKey NODE2PRICE = new IntegerKey("nodeprice.two");
    StringKey NAME = new StringKey("name");
    RouteIdentifierKey ROUTE_IDENTIFIER = new RouteIdentifierKey("nodeidentifier");

    DoubleKey UPKEEP_AMOUNT = new DoubleKey("Upkeep.Amount");
    BooleanKey USE_VAULT = new BooleanKey("Currency.Vault");
    ItemKey UPKEEP_ITEM = new ItemKey("Currency.Item");
    BooleanKey NODES_PUBLIC = new BooleanKey("PublicNodes");
    BooleanKey NODES_DYNMAP = new BooleanKey("NodesOnDynmap");
    IntegerKey ROUTE_DISTANCE_MIN = new IntegerKey("MinimumDistance");
    IntegerKey NODES_MAXIMUM = new IntegerKey("MaximumNodes");
}
