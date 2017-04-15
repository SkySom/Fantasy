package io.sommers.fantasy.api.spells;

import net.minecraft.util.ResourceLocation;

public class SpellBase implements ISpell {
    private ResourceLocation name;
    private CastingType castingType;

    public SpellBase(ResourceLocation name) {
        this(name, CastingType.INSTANT);
    }

    public SpellBase(ResourceLocation name, CastingType castingType) {

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
    public void startCast() {

    }

    @Override
    public void onTickCasting() {

    }

    @Override
    public void onFinishCasting() {

    }
}
