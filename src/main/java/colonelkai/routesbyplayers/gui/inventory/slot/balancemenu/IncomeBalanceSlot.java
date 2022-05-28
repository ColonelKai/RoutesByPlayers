package colonelkai.routesbyplayers.gui.inventory.slot.balancemenu;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.balance.IncomeBalance;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class IncomeBalanceSlot extends Slot {
    public IncomeBalanceSlot(@NotNull InventoryTemplate template, int slotIndex, Player player) {
        this(template, slotIndex, Managers.getInstance().getIncomeBalanceManager().getOrCreate(player.getUniqueId()));
    }
    public IncomeBalanceSlot(@NotNull InventoryTemplate template, int slotIndex, IncomeBalance incomeBalance) {
        super(template, slotIndex, new ItemStackBuilder()
                .setName(ChatColor.WHITE + "Income Balance")
                .addLore(ChatColor.GRAY + "(Withdraw Only)")
                .addLore(ChatColor.GRAY + "Amount: " + incomeBalance.getAmount())
                .setAmount(1)
                .setMaterial(Material.SUNFLOWER)
                .build(),
                SlotEvents.WITHDRAW_FROM_INCOMEBALANCE,
                SlotEvents.OPEN_BALANCE_CLICK
        );
    }
}
