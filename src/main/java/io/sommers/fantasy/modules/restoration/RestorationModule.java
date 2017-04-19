package io.sommers.fantasy.modules.restoration;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import io.sommers.fantasy.api.spells.registry.ISpellRegistry;
import io.sommers.fantasy.modules.restoration.spells.PotionSpell;
import io.sommers.fantasy.modulesystem.FantasyModule;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static io.sommers.fantasy.Fantasy.MOD_ID;

@Module(MOD_ID)
public class RestorationModule extends FantasyModule {
    @Override
    public String getName() {
        return "Restoration";
    }

    @Override
    public void registerSpells(ConfigRegistry configRegistry, ISpellRegistry spellRegistry) {
        ForgeRegistries.POTIONS.getEntries().forEach(entry -> {
            if (entry.getKey().getResourceDomain().equals("minecraft")) {
                spellRegistry.addSpell(new PotionSpell(entry.getValue()));
            }
        });
    }


}
