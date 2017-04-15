package io.sommers.fantasy.modules.alteration;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import io.sommers.fantasy.Fantasy;
import io.sommers.fantasy.modules.alteration.blocks.BlockMageLight;
import io.sommers.fantasy.modulesystem.FantasyModule;
import io.sommers.fantasy.registrysystem.SpellRegistry;

@Module(Fantasy.MOD_ID)
public class AlterationModule extends FantasyModule {
    @Override
    public String getName() {
        return "Alteration Spells";
    }

    @Override
    public void registerBlocks(ConfigRegistry configRegistry, BlockRegistry blockRegistry) {
        blockRegistry.register(new BlockMageLight());
    }

    @Override
    public void registerSpells(ConfigRegistry configRegistry, SpellRegistry spellRegistry) {

    }
}
