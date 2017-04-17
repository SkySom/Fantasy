package io.sommers.fantasy.modules.foundation.entities;

import io.sommers.fantasy.api.spells.CastingAttributes;
import io.sommers.fantasy.api.spells.projectiles.IProjectileSpell;
import io.sommers.fantasy.modules.foundation.FoundationModule;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SpellProjectile extends EntityArrow {
    private IProjectileSpell spell;
    private CastingAttributes castingAttributes;

    public SpellProjectile(World world) {
        super(world);
    }

    public SpellProjectile(World world, IProjectileSpell spell) {
        super(world);
        this.spell = spell;
    }

    @Override
    public void onHit(RayTraceResult rayTraceResult) {
        this.spell.onHit(this.getEntityWorld(), rayTraceResult);
        this.setDead();
    }

    @Override
    @Nullable
    public EntityItem entityDropItem(ItemStack stack, float offsetY) {
        //Just to ensure it drops nothing
        return null;
    }

    @Override
    @Nonnull
    protected ItemStack getArrowStack() {
        return FoundationModule.itemScroll.getItemStackFor(spell);
    }
}
