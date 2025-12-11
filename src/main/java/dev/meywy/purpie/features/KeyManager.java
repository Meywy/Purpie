package dev.meywy.purpie.features;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

public class KeyManager {

    private MinecraftClient mc =  MinecraftClient.getInstance();
    private boolean[] keyPressed = new boolean[GLFW.GLFW_KEY_LAST];

    public void checkKeys(ModuleManager moduleManager) {
        long windowHandle = mc.getWindow().getHandle();

        for(Module module : moduleManager.getModules()) {
            int keyCode = module.getKeyCode();
            if(GLFW.glfwGetKey(windowHandle, keyCode) == GLFW.GLFW_PRESS) {
                if (!keyPressed[keyCode]) {
                    module.toggle();
                    keyPressed[keyCode] = true;
                } else {
                    keyPressed[keyCode] = false;
                }
            }
        }
    }

}
