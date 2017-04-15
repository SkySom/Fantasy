package io.sommers.fantasy.modules.alteration;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import io.sommers.fantasy.Fantasy;
import io.sommers.fantasy.modulesystem.FantasyModule;
import io.sommers.fantasy.registrysystem.SpellRegistry;

@Module(Fantasy.MOD_ID)
public class AlterationModule extends FantasyModule {
    @Override
    public String getName() {
        return "Alteration Spells";
    }

    public void registerSpells(ConfigRegistry configRegistry, SpellRegistry spellRegistry) {

    }
}
