package io.sommers.fantasy.api.spells.registry;

import io.sommers.fantasy.api.spells.ISpell;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;

public interface ISpellRegistry {
    void addSpell(ISpell spell);

    ISpell getSpell(ResourceLocation name);

    default ISpell getSpell(String name) {
        return this.getSpell(new ResourceLocation(name));
    }

    Collection<ISpell> getAllSpells();
}
