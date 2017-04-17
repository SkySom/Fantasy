package io.sommers.fantasy.api.spells;

import net.minecraft.util.ResourceLocation;

import java.util.List;

public interface ISpellRegistry {
    void addSpell(ISpell spell);

    ISpell getSpell(ResourceLocation name);

    default ISpell getSpell(String name) {
        return this.getSpell(new ResourceLocation(name));
    }

    List<ISpell> getAllSpells();
}
