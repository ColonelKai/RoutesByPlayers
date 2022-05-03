package colonelkai.routesbyplayers.manager;

public class Managers {
    private final IncomeBalanceManager incomeBalance = new IncomeBalanceManager();
    private final UpkeepBalanceManager upkeepBalance = new UpkeepBalanceManager();
    private final NodeManager node = new NodeManager();
    private final RouteManager route = new RouteManager();

    private static final Managers INSTANCE = new Managers();

    private Managers() {

    }

    public IncomeBalanceManager getIncomeBalanceManager() {
        return this.incomeBalance;
    }

    public UpkeepBalanceManager getUpkeepBalanceManager() {
        return this.upkeepBalance;
    }

    public NodeManager getNodeManager() {
        return this.node;
    }

    public RouteManager getRouteManager() {
        return this.route;
    }

    public static Managers getInstance() {
        return INSTANCE;
    }


}
