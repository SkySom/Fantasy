package io.sommers.fantasy.modules.restoration.spells;

import io.sommers.fantasy.api.spells.projectiles.ProjectileSpellBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionEffectSpell extends ProjectileSpellBase {
    private PotionType potionEffect;

    public PotionEffectSpell(String name) {
        this(ForgeRegistries.POTION_TYPES.getValue(new ResourceLocation(name)), 50);
    }

    public PotionEffectSpell(PotionType potionEffect) {
        this(potionEffect, 50);
    }

    public PotionEffectSpell(PotionType potionEffect, int castingCost) {
        super(potionEffect.getRegistryName(), castingCost);
        this.potionEffect = potionEffect;
    }

    @Override
    public void onHit(World world, RayTraceResult rayTraceResult) {
        if (rayTraceResult.entityHit instanceof EntityLivingBase) {
            EntityLivingBase entityLivingBase = (EntityLivingBase) rayTraceResult.entityHit;
            potionEffect.getEffects().forEach(entityLivingBase::addPotionEffect);
        }
    }
}
