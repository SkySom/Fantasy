package io.sommers.fantasy.modulesystem;

import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import io.sommers.fantasy.api.spells.registry.ISpellRegistry;
import io.sommers.fantasy.registrysystem.SpellRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public abstract class FantasyModule extends ModuleBase {
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        this.registerSpells(this.getConfigRegistry(), this.getSpellRegistry());
    }

    public void registerSpells(ConfigRegistry configRegistry, ISpellRegistry spellRegistry) {

    }

    public SpellRegistry getSpellRegistry() {
        return this.getRegistryHolder().getRegistry(SpellRegistry.class, "SPELL");
    }
}
