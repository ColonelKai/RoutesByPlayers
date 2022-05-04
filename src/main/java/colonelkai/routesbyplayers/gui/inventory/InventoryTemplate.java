package colonelkai.routesbyplayers.gui.inventory;

import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface InventoryTemplate {

    int getInventorySize();

    Collection<Slot> getSlots();

    @NotNull String getTemplateName();

    default @NotNull Slot getSlot(int index) {
        return this.getSlots().stream().filter(slot -> slot.getIndex() == index).findFirst().orElseThrow(() -> new IndexOutOfBoundsException("larger then slot provided"));
    }

    default @NotNull Inventory create(@NotNull Player player) {
        Inventory inventory = Bukkit.createInventory(player, 64, this.getTemplateName());
        Collection<Slot> slots = this.getSlots();
        slots.forEach(slot -> {
            ItemStack stack = slot.getStack();
            inventory.setItem(slot.getIndex(), stack);
        });

        return inventory;
    }
}
