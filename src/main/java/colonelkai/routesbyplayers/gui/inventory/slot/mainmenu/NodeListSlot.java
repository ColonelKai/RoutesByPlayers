package colonelkai.routesbyplayers.gui.inventory.slot.mainmenu;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class NodeListSlot extends Slot {
    public NodeListSlot(@NotNull InventoryTemplate template, int slotIndex) {
        super(template, slotIndex,
                new ItemStackBuilder()
                        .setName(ChatColor.WHITE + "View Nodes")
                        .setMaterial(Material.BEACON)
                        .setAmount(1)
                        .build(),
                SlotEvents.OPEN_NODE_LIST_CLICK
                );
    }
}
