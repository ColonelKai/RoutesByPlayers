package colonelkai.routesbyplayers.util.context;

import org.bukkit.entity.Player;

public class TemplateContext {
    // wowowoeoeoeeowowoweoeoeeoeowoeoeowoeoeo

    private final Player player;

    public TemplateContext(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }
}
