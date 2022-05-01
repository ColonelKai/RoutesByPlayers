package colonelkai.routesbyplayers.singletons;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.singletons.datanode.simplenodes.IntDataNode;
import colonelkai.routesbyplayers.util.balance.IncomeBalance;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public class IncomeBalanceManager implements Manager<IncomeBalance> {

    Set<IncomeBalance> set;

    @Override
    public boolean saveAll(File folder) {

    }

    @Override
    public boolean loadAll(File folder) {

        return true;
    }

    @Override
    public Collection<IncomeBalance> getSet() {
        return this.set;
    }

    @Override
    public File getDefaultLocation() {
        return new File(RoutesByPlayers.getPlugin().getDataFolder().getPath()
                +File.separator+"data"+File.separator+"incomebalance");
    }
}
