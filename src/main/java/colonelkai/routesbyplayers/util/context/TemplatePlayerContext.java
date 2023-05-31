package colonelkai.routesbyplayers.util.context;

import org.bukkit.entity.Player;

public class TemplatePlayerContext implements TemplateContext {
    // wowowoeoeoeeowowoweoeoeeoeowoeoeowoeoeo

    private final Player player;

    public TemplatePlayerContext(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }
}
