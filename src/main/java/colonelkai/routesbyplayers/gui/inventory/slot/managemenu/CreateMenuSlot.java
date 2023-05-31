package colonelkai.routesbyplayers.gui.inventory.slot.managemenu;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotClickEvent;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvent;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import colonelkai.routesbyplayers.gui.inventory.templates.InventoryTemplates;
import colonelkai.routesbyplayers.util.context.TemplatePlayerContext;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CreateMenuSlot extends Slot {

    public CreateMenuSlot(@NotNull InventoryTemplate template, int slotIndex) {
        super(template, slotIndex, new ItemStackBuilder()
                        .setName(ChatColor.WHITE + "Create...")
                        .setMaterial(Material.ANVIL)
                        .setAmount(1)
                        .build(),
                SlotEvents.CANCEL_DRAG,

                (SlotClickEvent) (event, slot) -> {
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                    Bukkit.getScheduler().scheduleSyncDelayedTask(RoutesByPlayers.getPlugin(),
                            () -> {
                                event.getWhoClicked().openInventory(InventoryTemplates.CREATE.create((Player) event.getWhoClicked()));},
                            0L);
                }

                );
    }
}
