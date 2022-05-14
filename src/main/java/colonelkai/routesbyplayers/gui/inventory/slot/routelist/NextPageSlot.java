package colonelkai.routesbyplayers.gui.inventory.slot.routelist;

import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.PagedInventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.PageSpecificSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class NextPageSlot extends Slot implements PageSpecificSlot {


    public NextPageSlot(@SuppressWarnings("TypeMayBeWeakened") @NotNull PagedInventoryTemplate template) {
        super(template, 53, new ItemStackBuilder()
                        .setMaterial(Material.ARROW)
                        .setAmount(1)
                        .setName("Next")
                        .addLore("To page: 0")
                        .build(),
                SlotEvents.CANCEL_DRAG,
                SlotEvents.TO_PAGE_CLICK_EVENT);
    }

    @Override
    public @NotNull PagedInventoryTemplate getTemplate() {
        return (PagedInventoryTemplate) super.getTemplate();
    }

    @Override
    public ItemStack getStack(int page) {
        ItemStack stack = this.getStack();
        ItemMeta meta = stack.getItemMeta();
        if (meta == null) {
            throw new RuntimeException("No meta can be found");
        }
        meta.setLore(Collections.singletonList("To page: " + (page+1)));
        stack.setItemMeta(meta);
        return stack;
    }
}
