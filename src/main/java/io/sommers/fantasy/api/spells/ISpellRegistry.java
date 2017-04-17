package io.sommers.fantasy.api.spells;

import net.minecraft.util.ResourceLocation;

public interface ISpellRegistry {
    void addSpell(ISpell spell);

    ISpell getSpell(ResourceLocation name);

    default ISpell getSpell(String name) {
        return this.getSpell(new ResourceLocation(name));
    }
}
