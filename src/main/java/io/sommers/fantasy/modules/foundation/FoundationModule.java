package io.sommers.fantasy.modules.foundation;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import io.sommers.fantasy.modules.foundation.items.ItemScroll;

import static io.sommers.fantasy.Fantasy.MOD_ID;

@Module(MOD_ID)
public class FoundationModule extends ModuleBase {
    public static ItemScroll itemScroll;
    @Override
    public String getName() {
        return "Foundation";
    }

    @Override
    public boolean isConfigurable() {
        return false;
    }

    @Override
    public void registerItems(ConfigRegistry configRegistry, ItemRegistry itemRegistry) {
        itemRegistry.register(itemScroll = new ItemScroll());
    }
}
