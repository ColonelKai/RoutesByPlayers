package colonelkai.routesbyplayers.gui;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.templates.InventoryTemplates;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InventoryManager {

    private final Set<InventoryTemplate> templates;

    public InventoryManager() {
        this.templates = Arrays
                .stream(InventoryTemplates.class.getDeclaredFields())
                .filter(field -> Modifier.isFinal(field.getModifiers()))
                .filter(field -> Modifier.isPublic(field.getModifiers()))
                .filter(field -> Modifier.isStatic(field.getModifiers()))
                .filter(field -> InventoryTemplate.class.isAssignableFrom(field.getType()))
                .map(field -> {
                    try {
                        return (InventoryTemplate) field.get(null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        //noinspection ReturnOfNull
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public Optional<InventoryTemplate> getTemplate(@NotNull InventoryView inventory) {
        //primitive -> could be better but bukkit sucks
        return this.templates.stream().filter(temp -> temp.getTemplateName().equals(inventory.getTitle())).findFirst();
    }
}
