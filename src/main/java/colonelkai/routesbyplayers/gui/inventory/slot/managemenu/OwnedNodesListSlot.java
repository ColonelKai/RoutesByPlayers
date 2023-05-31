package colonelkai.routesbyplayers.gui.inventory.slot.managemenu;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvent;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class OwnedNodesListSlot extends Slot {
    public OwnedNodesListSlot(@NotNull InventoryTemplate template, int slotIndex) {
        super(template, slotIndex, new ItemStackBuilder()
                        .setName(ChatColor.WHITE + "View Owned Nodes")
                        .setMaterial(Material.BEACON)
                        .setAmount(1)
                        .build(),
                SlotEvents.CANCEL_DRAG,
                SlotEvents.CANCEL_CLICK);
    }
}
