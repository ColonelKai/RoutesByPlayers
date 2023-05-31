package colonelkai.routesbyplayers.gui.inventory.slot.mainmenu;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class ManageSlot extends Slot {
    public ManageSlot(@NotNull InventoryTemplate template, int slotIndex) {
        super(template, slotIndex,
                new ItemStackBuilder()
                        .setName(ChatColor.WHITE + "Manage")
                        .setMaterial(Material.WRITABLE_BOOK)
                        .addLore("Manage your Routes, Nodes Etc.")
                        .setAmount(1)
                        .build(),
                SlotEvents.OPEN_MANAGE_CLICK,
                SlotEvents.CANCEL_DRAG
        );
    }
}
