package dev.meywy.purpie;

import dev.meywy.purpie.features.KeyManager;
import dev.meywy.purpie.features.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.render.GuiRenderer;

public class PurpieClient implements ClientModInitializer {

    public static ModuleManager modManager;
    public static KeyManager keyManager;

    @Override
    public void onInitializeClient() {
        modManager = new ModuleManager();
        keyManager = new KeyManager();
    }

    public static void onTick() {
        modManager.onTick(keyManager);
    }

    public void onRender(GuiRenderer guiRenderer) {

    }
}
