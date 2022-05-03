package colonelkai.routesbyplayers.gui.inventory.templates;

import colonelkai.routesbyplayers.gui.inventory.PagedInventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.RouteSlot;
import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.Route;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class RouteInventoryTemplate implements PagedInventoryTemplate {
    @Override
    public int getInventorySize() {
        return 64;
    }

    @Override
    public @NotNull Inventory create(@NotNull Player player, int page) {
        List<Route> orderedRoutes = Managers.getInstance().getRouteManager().getElements().stream().sorted().collect(Collectors.toList());
        int itemsPerPage = this.getInventorySize() - 9;
        int minIndex = itemsPerPage * page;
        int maxIndex = minIndex + (itemsPerPage - 1);
        List<Route> pageRoutes = orderedRoutes.subList(minIndex, maxIndex);
        Inventory inventory = Bukkit.createInventory(player, page, "Routes");

        for(int i = 0; i < pageRoutes.size(); i++){
            inventory.setItem(i, new RouteSlot(this, i).getStack());
        }

        return null;
    }

    @Override
    public int getMaxPages() {
        int itemsPerPage = this.getInventorySize() - 9;
        int routes = Managers.getInstance().getRouteManager().getElements().size();

        return routes / itemsPerPage;
    }
}
