package dev.meywy.purpie.features;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.MinecraftClient;

@Getter
public abstract class Module {

    public String name;
    public String description;
    public int keyCode;
    public Category category;

    @Setter
    public boolean toggled;

    public MinecraftClient mc;

    public Module(String name, String description, Category category, MinecraftClient mc) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.toggled = false;
        this.mc = MinecraftClient.getInstance();
    }

    public void onEnabled() {}
    public void onDisabled() {}
    public void onUpdate() {}

    public void toggle() {
        this.toggled = !this.toggled;
        if (this.toggled) {
            onEnabled();
        } else  {
            onDisabled();
        }
    }

    public void onRender() {
        if (this.isToggled()) {
            renderLogic();
        }
    }

    protected void renderLogic() {}

}
