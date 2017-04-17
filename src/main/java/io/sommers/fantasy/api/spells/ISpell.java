package io.sommers.fantasy.api.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public interface ISpell {
    ResourceLocation getName();

    CastingType getCastingType();

    boolean canCast(EntityLivingBase livingBase);

    int getCastingCost();

    void startCast(EntityPlayer player, CastingAttributes castingAttributes);

    void onTickCasting(EntityPlayer player, CastingAttributes castingAttributes);

    void onFinishCasting(EntityPlayer player, CastingAttributes castingAttributes);
}
