package io.sommers.fantasy.api.spells.projectiles;

import io.sommers.fantasy.api.spells.ISpell;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public interface IProjectileSpell extends ISpell {
    void onHit(World world, RayTraceResult rayTraceResult);
}
