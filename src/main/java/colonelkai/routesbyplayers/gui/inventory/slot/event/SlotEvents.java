package colonelkai.routesbyplayers.gui.inventory.slot.event;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.PagedInventoryTemplate;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public interface SlotEvents {

    SlotDragEvent CANCEL_DRAG = (event, slot) -> event.setCancelled(true);
    SlotClickEvent TO_PAGE_CLICK_EVENT = (event, slot) -> {
        InventoryTemplate inv = slot.getTemplate();
        if (!(inv instanceof PagedInventoryTemplate)) {
            throw new RuntimeException("To Page Click Event can only be applied to 'PagedInventoryTemplate's ");
        }
        event.setCancelled(true);
        ItemStack previousItem = event.getCurrentItem();
        if (previousItem == null) {
            throw new RuntimeException("Clicked slot is null, yet got to clicked code");
        }
        ItemMeta meta =
                previousItem.getItemMeta();
        if (meta == null) {
            throw new RuntimeException("Clicked slot has item without meta, yet located as previous slot");
        }
        List<String> lore = meta.getLore();
        if (lore == null || lore.isEmpty()) {
            throw new RuntimeException("Clicked slot has item without lore, yet located as previous slot");
        }
        String loreLine = lore.get(0);
        if (loreLine.length() < 10) {
            throw new RuntimeException("Clicked slot does not have correct lore");
        }
        String toPageString = loreLine.substring(9);
        int page;
        try {
            page = Integer.parseInt(toPageString);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Clicked slot does not have page to in lore", e);
        }
        if (page < 0) {
            page = 0;
        }
        Player player = (Player) event.getWhoClicked(); //bukkit doesn't allow any other human entity by default -> so this is a safe cast
        ((PagedInventoryTemplate) inv).create(player, page);
    };
}
