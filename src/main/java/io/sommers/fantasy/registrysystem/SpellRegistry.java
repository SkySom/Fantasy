package io.sommers.fantasy.registrysystem;

import com.teamacronymcoders.base.IBaseMod;
import com.teamacronymcoders.base.registrysystem.ModularRegistry;
import com.teamacronymcoders.base.registrysystem.pieces.IRegistryPiece;
import io.sommers.fantasy.api.spells.ISpell;
import io.sommers.fantasy.api.spells.registry.ISpellRegistry;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;
import java.util.List;

public class SpellRegistry extends ModularRegistry<ISpell> implements ISpellRegistry {
    public SpellRegistry(IBaseMod mod, List<IRegistryPiece> registryPieces) {
        super("SPELL", mod, registryPieces);
    }

    @Override
    public void addSpell(ISpell spell) {
        this.register(spell.getName(), spell);
    }

    @Override
    public ISpell getSpell(ResourceLocation name) {
        return this.get(name);
    }

    @Override
    public Collection<ISpell> getAllSpells() {
        return this.getEntries().values();
    }
}
