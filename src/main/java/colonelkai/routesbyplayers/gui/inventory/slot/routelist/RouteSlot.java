package colonelkai.routesbyplayers.gui.inventory.slot.routelist;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import colonelkai.routesbyplayers.util.Route;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class RouteSlot extends Slot {
    public RouteSlot(@NotNull InventoryTemplate template, int slotIndex, @NotNull Route route) {
        super(template, slotIndex, new ItemStackBuilder()
                .setName(ChatColor.WHITE + route.getNode(1).getIdentifier() + " to " + route.getNode(2).getIdentifier())
                .addLore(ChatColor.GRAY + "Upkeep: " + route.getUpkeep())
                .addLore(ChatColor.GRAY + "Cost: " + route.getTotalPrice())
                .setMaterial(Material.COMPASS)
                .setAmount(1)
                .build(),
                SlotEvents.CANCEL_DRAG,
                SlotEvents.CANCEL_CLICK
                );
    }
}
