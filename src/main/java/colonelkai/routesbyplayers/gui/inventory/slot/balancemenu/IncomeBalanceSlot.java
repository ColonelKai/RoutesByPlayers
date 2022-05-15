package colonelkai.routesbyplayers.gui.inventory.slot.balancemenu;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.util.balance.IncomeBalance;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class IncomeBalanceSlot extends Slot {
    public IncomeBalanceSlot(@NotNull InventoryTemplate template, int slotIndex, IncomeBalance incomeBalance) {
        super(template, slotIndex, new ItemStackBuilder()
                .setName(ChatColor.WHITE + "Income Balance")
                .addLore(ChatColor.GRAY + "(Withdraw Only)")
                .addLore(ChatColor.GRAY + "Amount: " + incomeBalance.getAmount())
                .build()
        );
    }
}
