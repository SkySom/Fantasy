package io.sommers.fantasy.modulesystem;

import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import io.sommers.fantasy.api.spells.registry.ISpellRegistry;
import io.sommers.fantasy.api.spells.registry.RegisterSpellsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public abstract class FantasyModule extends ModuleBase {
    public FantasyModule() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerSpells(RegisterSpellsEvent registerSpellsEvent) {
        this.registerSpells(this.getConfigRegistry(), registerSpellsEvent.getSpellRegistry());
    }

    public abstract void registerSpells(ConfigRegistry configRegistry, ISpellRegistry spellRegistry);
}
