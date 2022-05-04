package colonelkai.routesbyplayers.util.currency;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.balance.IncomeBalance;
import colonelkai.routesbyplayers.util.balance.UpkeepBalance;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ItemCurrency extends AbstractCurrency {

    public ItemCurrency(int amount) {
        super(amount);
    }

    @Override
    public boolean hasEnoughOnSelf(UUID uuid) {
        Player player = RoutesByPlayers.getPlugin().getServer().getPlayer(uuid);
        if (player == null) {
            return false;
        } else if (!player.isOnline()) {
            return false;
        }
        Inventory inventory = player.getInventory();
        Material mat = Managers.getInstance().getConfigManager().getUpkeepItem();
        return inventory.contains(mat, this.getAmount());
    }

    @Override
    public boolean hasEnoughOnUpkeep(UUID uuid) {
        Optional<UpkeepBalance> upkeepBalance = Managers.getInstance().getUpkeepBalanceManager().getBy(uuid);
        return upkeepBalance.filter(balance -> (balance.getAmount() > this.getAmount())).isPresent();
    }


    @Override
    public boolean transactionInventory(UUID uuid) {
        if (this.getAmount() < 0 && !this.hasEnoughOnSelf(uuid)) {
            return false;
        }
        Material mat = Managers.getInstance().getConfigManager().getUpkeepItem();
        Inventory inventory = Objects.requireNonNull(RoutesByPlayers.getPlugin().getServer().getPlayer(uuid)).getInventory();

        if (this.getAmount() < 0) {
            inventory.remove(new ItemStack(mat, this.getAmount()));
        } else {
            inventory.addItem(new ItemStack(mat, this.getAmount()));
        }
        return true;
    }

    @Override
    public boolean transactionUpkeep(UUID uuid) {
        Optional<UpkeepBalance> upkeepBalance = Managers.getInstance().getUpkeepBalanceManager().getBy(uuid);
        if (!this.hasEnoughOnUpkeep(uuid)) {
            return false;
        }
        return upkeepBalance.map(balance -> balance.withdraw(this.getAmount())).orElse(false);
    }

    @Override
    public boolean transactionIncome(UUID uuid) {
        Optional<IncomeBalance> incomeBalance = Managers.getInstance().getIncomeBalanceManager().getBy(uuid);
        if (!incomeBalance.isPresent()) {
            return false;
        }
        incomeBalance.get().deposit(this.getAmount());
        return true;
    }
}
