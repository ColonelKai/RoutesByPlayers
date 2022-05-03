package colonelkai.routesbyplayers.util.currency;

import colonelkai.routesbyplayers.config.ConfigManager;
import org.bukkit.Material;

public class CurrencyBuilder {

    public static AbstractCurrency build(int amount) {
        boolean ifVault = ConfigManager.getUseMoney();
        //Vault does nto exist yet lol

        return new ItemCurrency(amount);
    }


}
