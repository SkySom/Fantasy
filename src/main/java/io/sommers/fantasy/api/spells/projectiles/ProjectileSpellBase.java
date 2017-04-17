package io.sommers.fantasy.api.spells.projectiles;

import io.sommers.fantasy.api.spells.SpellBase;
import net.minecraft.util.ResourceLocation;

public abstract class ProjectileSpellBase extends SpellBase implements IProjectileSpell {
    public ProjectileSpellBase(ResourceLocation name, int castingCost) {
        super(name, castingCost);
    }
}
