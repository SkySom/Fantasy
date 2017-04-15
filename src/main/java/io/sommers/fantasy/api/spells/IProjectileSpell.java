package io.sommers.fantasy.api.spells;

import net.minecraft.util.math.RayTraceResult;

public interface IProjectileSpell extends ISpell {
    void onHit(RayTraceResult rayTraceResult);
}
