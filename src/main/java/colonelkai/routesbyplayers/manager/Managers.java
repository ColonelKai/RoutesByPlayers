package colonelkai.routesbyplayers.manager;

public interface Managers {
    IncomeBalanceManager INCOME_BALANCE_MANAGER = new IncomeBalanceManager();
    UpkeepBalanceManager UPKEEP_BALANCE_MANAGER = new UpkeepBalanceManager();
    NodeManager NODE_MANAGER = new NodeManager();
    RouteManager ROUTE_MANAGER = new RouteManager();
}
