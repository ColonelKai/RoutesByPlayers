package colonelkai.routesbyplayers.gui.inventory.slot.mainmenu;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvent;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BalanceSlot extends Slot {

    public BalanceSlot(@NotNull InventoryTemplate template, int slotIndex) {
        super(template, slotIndex,
                new ItemStackBuilder()
                        .setName(ChatColor.WHITE + "View Your Balances")
                        .setMaterial(Material.SUNFLOWER)
                        .setAmount(1)
                        .build(),
                SlotEvents.OPEN_BALANCE_CLICK
        );
    }
}
