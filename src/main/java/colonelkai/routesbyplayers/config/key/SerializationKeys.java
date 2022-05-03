package colonelkai.routesbyplayers.config.key;

public interface SerializationKeys {
    UUIDKey OWNER = new UUIDKey("owner");
    IntegerKey AMOUNT = new IntegerKey("amount");
    LocationKey LOCATION = new LocationKey("location");
    StringKey NAME = new StringKey("name");
    RouteIdentifierKey ROUTE_IDENTIFIER = new RouteIdentifierKey("nodeidentifier");
}
