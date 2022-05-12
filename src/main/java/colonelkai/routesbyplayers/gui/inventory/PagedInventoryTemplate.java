package colonelkai.routesbyplayers.gui.inventory;

import colonelkai.routesbyplayers.gui.inventory.slot.PageSpecificSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface PagedInventoryTemplate extends InventoryTemplate {

    Collection<Slot> getSlots(int page);

    int getMaxPages();

    @Override
    default Collection<Slot> getSlots() {
        return this.getSlots(0);
    }

    @Override
    default @NotNull Inventory create(@NotNull Player player) {
        return this.create(player, 0);
    }

    default @NotNull Inventory create(@NotNull Player player, int page) {
        Inventory inventory = Bukkit.createInventory(player, this.getInventorySize(), this.getTemplateName());
        Collection<Slot> slots = this.getSlots(page);
        slots.forEach(slot -> {
            ItemStack stack = slot.getStack();
            if (slot instanceof PageSpecificSlot) {
                PageSpecificSlot pageSlot = (PageSpecificSlot) slot;
                stack = pageSlot.getStack(page);
            }
            inventory.setItem(slot.getIndex(), stack);
        });

        return inventory;
    }
}
