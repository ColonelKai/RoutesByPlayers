package colonelkai.routesbyplayers.gui.inventory.slot.nodelist;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.manager.NodeManager;
import colonelkai.routesbyplayers.util.Node;
import colonelkai.routesbyplayers.util.Route;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class NodeSlot extends Slot {
    public NodeSlot(@NotNull InventoryTemplate template, int slotIndex, @NotNull Node node) {
        super(template, slotIndex, new ItemStackBuilder()
                        .setName(ChatColor.WHITE + node.getIdentifier())
                        .addLore(ChatColor.GRAY + "Owner: "  +
                                RoutesByPlayers.getPlugin().getServer().getPlayer(node.getOwner()).getName()
                        )
                        .addLore(ChatColor.GRAY + "Location: "  + NodeManager.getLocationString(node))
                        .setMaterial(Material.BEACON)
                        .setAmount(1)
                        .build(),
                SlotEvents.CANCEL_DRAG
        );
    }
}
