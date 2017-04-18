package io.sommers.fantasy.modules.restoration;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import io.sommers.fantasy.api.spells.registry.ISpellRegistry;
import io.sommers.fantasy.modules.restoration.spells.PotionEffectSpell;
import io.sommers.fantasy.modulesystem.FantasyModule;

import static io.sommers.fantasy.Fantasy.MOD_ID;

@Module(MOD_ID)
public class RestorationModule extends FantasyModule {
    @Override
    public String getName() {
        return "Restoration";
    }

    @Override
    public void registerSpells(ConfigRegistry configRegistry, ISpellRegistry spellRegistry) {
        spellRegistry.addSpell(new PotionEffectSpell("wither"));
    }


}
