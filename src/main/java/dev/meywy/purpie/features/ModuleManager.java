package dev.meywy.purpie.features;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {

    @Getter
    private static List<Module> modules;

    public ModuleManager() {
        // Dungeons

        // Mining

        // Misc
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public List<Module> getEnabledModules() {
        return modules.stream()
                .filter(Module::isToggled)
                .collect(Collectors.toList());
    }

    public static List<Module> getModulesByCategory(Category category) {
        return modules.stream()
                .filter(module -> module.category == category)
                .collect(Collectors.toList());
    }

    public Module getModuleByName(String name) {
        for (Module module : modules) {
            if (module.getName().equalsIgnoreCase(name)) {
                return module;
            }
        }
        return null;
    }

    public void toggleModule(String name) {
        Module module = getModuleByName(name);
        if (module != null) {
            module.toggle();
        }
    }

    public static void onUpdate() {
        for (Module module : modules) {
            module.onUpdate();
        }
    }

    public void onRender() {
        for (Module module : modules) {
            module.onRender();
        }
    }

    public void onTick(KeyManager keyManager) {
        keyManager.checkKeys(this);

        for (Module module : modules) {
            if(module.isToggled()) {
                module.onUpdate();
            }
        }
    }

}
