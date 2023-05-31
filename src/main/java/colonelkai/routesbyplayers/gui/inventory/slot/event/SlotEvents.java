package colonelkai.routesbyplayers.gui.inventory.slot.event;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.PagedInventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.templates.InventoryTemplates;
import colonelkai.routesbyplayers.gui.inventory.templates.NodeInventoryTemplate;
import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.balance.IncomeBalance;
import colonelkai.routesbyplayers.util.context.TemplateContext;
import colonelkai.routesbyplayers.util.currency.CurrencyBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public interface SlotEvents {

    SlotDragEvent CANCEL_DRAG = (event, slot) -> event.setCancelled(true);
    SlotClickEvent CANCEL_CLICK = (event, slot) -> event.setCancelled(true);
    SlotClickEvent OPEN_ROUTE_LIST_CLICK = (event, slot) -> {
        event.setCancelled(true);
        event.getWhoClicked().closeInventory();
        Bukkit.getScheduler().scheduleSyncDelayedTask(RoutesByPlayers.getPlugin(),
                () ->
                        event.getWhoClicked().openInventory(InventoryTemplates.ROUTE.create((Player) event.getWhoClicked())),
                0L);
    };
    SlotClickEvent OPEN_NODE_LIST_CLICK = (event, slot) -> {
        event.setCancelled(true);
        event.getWhoClicked().closeInventory();
        Bukkit.getScheduler().scheduleSyncDelayedTask(RoutesByPlayers.getPlugin(),
                () ->
                        event.getWhoClicked().openInventory(InventoryTemplates.NODE.create((Player) event.getWhoClicked())),
                0L);
    };
    SlotClickEvent OPEN_BALANCE_CLICK = (event, slot) -> {
        event.setCancelled(true);
        event.getWhoClicked().closeInventory();
        Bukkit.getScheduler().scheduleSyncDelayedTask(RoutesByPlayers.getPlugin(),
                () -> {
                        InventoryTemplates.BALANCE.setCtx(new TemplateContext((Player) event.getWhoClicked()));
                        event.getWhoClicked().openInventory(InventoryTemplates.BALANCE.create((Player) event.getWhoClicked()));},
                0L);
    };
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
        if (loreLine.length() < 1) {
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
    SlotClickEvent WITHDRAW_FROM_INCOMEBALANCE = (event, slot) -> {
        event.setCancelled(true);
        IncomeBalance incomeBalance = Managers.getInstance().getIncomeBalanceManager().getOrCreate(event.getWhoClicked().getUniqueId());
        CurrencyBuilder.build(incomeBalance.getAmount()).transactionInventory(event.getWhoClicked().getUniqueId());
        event.getWhoClicked().sendMessage(ChatColor.GRAY + "Withdrew " + incomeBalance.getAmount() + " from income balance.");
        incomeBalance.setAmount(0);
    };
}
