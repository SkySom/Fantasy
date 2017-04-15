package io.sommers.fantasy.api.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class SpellBase implements ISpell {
    private ResourceLocation name;
    private int castingCost;
    private CastingType castingType;

    public SpellBase(ResourceLocation name, int castingCost) {
        this(name, castingCost, CastingType.INSTANT);
    }

    public SpellBase(ResourceLocation name, int castingCost, CastingType castingType) {
        this.name = name;
        this.castingCost = castingCost;
        this.castingType = castingType;
    }

    @Override
    public ResourceLocation getName() {
        return name;
    }

    @Override
    public CastingType getCastingType() {
        return castingType;
    }
    @Override
    public int getCastingCost() {
        return 0;
    }


    @Override
    public void startCast(EntityPlayer player) {

    }

    @Override
    public void onTickCasting(EntityPlayer player) {

    }

    @Override
    public void onFinishCasting(EntityPlayer player) {

    }
}