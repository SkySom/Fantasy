package io.sommers.fantasy.modules.foundation;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;

import static io.sommers.fantasy.Fantasy.MOD_ID;

@Module(MOD_ID)
public class FoundationModule extends ModuleBase {
    @Override
    public String getName() {
        return "Foundation";
    }

    @Override
    public boolean isConfigurable() {
        return false;
    }
}
