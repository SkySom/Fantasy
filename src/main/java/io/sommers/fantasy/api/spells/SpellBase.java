package io.sommers.fantasy.api.spells;

import com.teamacronymcoders.base.util.ItemStackUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class SpellBase implements ISpell {
    private ResourceLocation name;
    private int castingCost;
    private int castingLength;

    public SpellBase(ResourceLocation name, int castingCost) {
        this(name, castingCost, 0);
    }

    public SpellBase(ResourceLocation name, int castingCost, int castingLength) {
        this.name = name;
        this.castingCost = castingCost;
        this.castingLength = castingLength;
    }

    @Override
    public ResourceLocation getName() {
        return name;
    }

    @Override
    public boolean canCast(EntityLivingBase livingBase) {
        return !ItemStackUtils.isValid(livingBase.getHeldItemMainhand());
    }

    @Override
    public double getCastingCost(CastingAttributes castingAttributes) {
        return Math.ceil(castingCost * castingAttributes.getCost());
    }

    @Override
    public int getCastingLength() {
        return castingLength;
    }


    @Override
    public void startCast(EntityLivingBase livingBase, CastingAttributes castingAttributes) {

    }

    @Override
    public void onTickCasting(EntityLivingBase livingBase, CastingAttributes castingAttributes) {

    }

    @Override
    public void onFinishCasting(EntityLivingBase livingBase, CastingAttributes castingAttributes) {

    }
}
