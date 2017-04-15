package io.sommers.fantasy.api.spells;

import net.minecraft.util.ResourceLocation;

public interface ISpell {
    ResourceLocation getName();

    CastingType getCastingType();

    void startCast();

    void onTickCasting();

    void onFinishCasting();
}
