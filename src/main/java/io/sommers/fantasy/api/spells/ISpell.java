package io.sommers.fantasy.api.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public interface ISpell {
    ResourceLocation getName();

    CastingType getCastingType();

    int getCastingCost();

    void startCast(EntityPlayer player);

    void onTickCasting(EntityPlayer player);

    void onFinishCasting(EntityPlayer player);
}
