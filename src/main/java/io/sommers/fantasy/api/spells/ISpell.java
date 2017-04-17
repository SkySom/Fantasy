package io.sommers.fantasy.api.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public interface ISpell {
    ResourceLocation getName();

    boolean canCast(EntityLivingBase livingBase);

    double getCastingCost(CastingAttributes castingAttributes);

    int getCastingLength();

    void startCast(EntityLivingBase livingBase, CastingAttributes castingAttributes);

    void onTickCasting(EntityLivingBase livingBase, CastingAttributes castingAttributes);

    void onFinishCasting(EntityLivingBase livingBase, CastingAttributes castingAttributes);
}
