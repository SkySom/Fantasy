package io.sommers.fantasy.modules.foundation.entities;

import io.sommers.fantasy.api.spells.IProjectileSpell;
import io.sommers.fantasy.modules.foundation.FoundationModule;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class SpellProjectile extends EntityArrow {
    private IProjectileSpell spell;

    public SpellProjectile(World world) {
        super(world);
    }

    public SpellProjectile(World world, IProjectileSpell spell) {
        super(world);
        this.spell = spell;
    }


    @Override
    @Nonnull
    protected ItemStack getArrowStack() {
        return FoundationModule.itemScroll.getItemStackFor(spell);
    }

    @Override
    public void onCollideWithPlayer(@Nonnull EntityPlayer entityIn) {

    }
}
