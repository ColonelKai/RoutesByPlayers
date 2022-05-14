package colonelkai.routesbyplayers.gui.inventory.templates;

import colonelkai.routesbyplayers.gui.inventory.PagedInventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.routelist.NextPageSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.routelist.PageIndicatorSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.routelist.PreviousPageSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.RouteSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.Route;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RouteInventoryTemplate implements PagedInventoryTemplate {
    @Override
    public int getInventorySize() {
        return 54;
    }

    @Override
    public @NotNull String getTemplateName() {
        return "Routes";
    }

    @Override
    public TreeSet<Slot> getSlots(int page) {
        List<Route> orderedRoutes = Managers.getInstance().getRouteManager().getElements().stream().sorted().collect(Collectors.toList());
        int itemsPerPage = this.getInventorySize() - 9;
        int maxIndex = Math.min(itemsPerPage * page, orderedRoutes.size());
        int minIndex = Math.max(maxIndex - itemsPerPage, 0);
        List<Route> pageRoutes = orderedRoutes.subList(minIndex, maxIndex);
        TreeSet<Slot> slots = new TreeSet<>();
        for (int i = 0; i < pageRoutes.size(); i++) {
            slots.add(new RouteSlot(this, i + 9));
        }
        slots.add(new NextPageSlot(this));
        slots.add(new PreviousPageSlot(this));
        slots.add(new PageIndicatorSlot(this));
        return slots;
    }

    @Override
    public int getMaxPages() {
        int itemsPerPage = this.getInventorySize() - 9;
        int routes = Managers.getInstance().getRouteManager().getElements().size();

        return routes / itemsPerPage;
    }
}
