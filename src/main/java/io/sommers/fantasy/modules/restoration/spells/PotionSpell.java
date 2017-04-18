package io.sommers.fantasy.modules.restoration.spells;

import io.sommers.fantasy.api.spells.projectiles.ProjectileSpellBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionSpell extends ProjectileSpellBase {
    private Potion potion;

    public PotionSpell(String name) {
        this(ForgeRegistries.POTIONS.getValue(new ResourceLocation(name)), 50);
    }

    public PotionSpell(Potion potion) {
        this(potion, 50);
    }

    public PotionSpell(Potion potion, int castingCost) {
        super(potion.getRegistryName(), castingCost);
        this.potion = potion;
    }

    @Override
    public void onHit(World world, RayTraceResult rayTraceResult) {
        if (rayTraceResult.entityHit instanceof EntityLivingBase) {
            EntityLivingBase entityLivingBase = (EntityLivingBase) rayTraceResult.entityHit;
            this.potion.performEffect(entityLivingBase, 1);
        }
    }
}
