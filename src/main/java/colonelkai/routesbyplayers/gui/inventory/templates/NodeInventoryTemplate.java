package colonelkai.routesbyplayers.gui.inventory.templates;

import colonelkai.routesbyplayers.gui.inventory.PagedInventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.nodelist.NodeSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.routelist.NextPageSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.routelist.PageIndicatorSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.routelist.PreviousPageSlot;
import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.Node;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class NodeInventoryTemplate implements PagedInventoryTemplate {
    @Override
    public int getInventorySize() {
        return 54;
    }

    @Override
    public @NotNull String getTemplateName() {
        return "Nodes";
    }

    @Override
    public TreeSet<Slot> getSlots(int page) {
        List<Node> orderedNodes = new ArrayList<>(Managers.getInstance().getNodeManager().getElements());
        int itemsPerPage = this.getInventorySize() - 9;
        int maxIndex = Math.min(itemsPerPage * page, orderedNodes.size());
        int minIndex = Math.max(maxIndex - itemsPerPage, 0);
        List<Node> pageNodes = orderedNodes.subList(minIndex, maxIndex);
        TreeSet<Slot> slots = new TreeSet<>();
        for (int i = 0; i < pageNodes.size(); i++) {
            slots.add(new NodeSlot(this, i + 9, pageNodes.get(i)));
        }
        slots.add(new NextPageSlot(this));
        slots.add(new PreviousPageSlot(this));
        slots.add(new PageIndicatorSlot(this));
        return slots;
    }

    @Override
    public int getMaxPages() {
        int itemsPerPage = this.getInventorySize() - 9;
        int nodes = Managers.getInstance().getNodeManager().getElements().size();

        return nodes / itemsPerPage;
    }
}
