package colonelkai.routesbyplayers.util.currency;

import colonelkai.routesbyplayers.manager.Managers;

public final class CurrencyBuilder {

    private CurrencyBuilder() {
        throw new RuntimeException("Should not run");
    }

    public static AbstractCurrency build(int amount) {
        boolean ifVault = Managers.getInstance().getConfigManager().getUseMoney();
        //Vault does nto exist yet lol

        return new ItemCurrency(amount);
    }


}
