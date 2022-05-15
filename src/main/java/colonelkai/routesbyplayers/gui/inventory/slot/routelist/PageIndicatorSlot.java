package colonelkai.routesbyplayers.gui.inventory.slot.routelist;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.PageSpecificSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvent;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class PageIndicatorSlot extends Slot implements PageSpecificSlot {
    public PageIndicatorSlot(@NotNull InventoryTemplate template) {
        super(template, 49, new ItemStackBuilder()
                        .setMaterial(Material.BOOK)
                        .setAmount(1)
                        .setName(ChatColor.WHITE+"Viewing:")
                        .addLore(ChatColor.WHITE+"Page: 0")
                        .build(),
                SlotEvents.CANCEL_DRAG,
                SlotEvents.TO_PAGE_CLICK_EVENT);
        }

        @Override
        public ItemStack getStack(int page) {
            ItemStack stack = this.getStack();
            ItemMeta meta = stack.getItemMeta();
            if (meta == null) {
                throw new RuntimeException("No meta can be found");
            }
            meta.setLore(Collections.singletonList("Page: " + page));
            stack.setItemMeta(meta);
            return stack;
        }
    }


