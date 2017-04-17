package io.sommers.fantasy.api.spells.spellholder;

import io.sommers.fantasy.api.FantasyAPI;
import io.sommers.fantasy.api.spells.CastingAttributes;
import io.sommers.fantasy.api.spells.ISpell;
import net.minecraft.nbt.NBTTagCompound;

public class SpellHolder implements ISpellHolder {
    private ISpell spell;
    private CastingAttributes castingAttributes;

    public SpellHolder() {

    }

    public SpellHolder(ISpell spell, CastingAttributes castingAttributes) {
        this.spell = spell;
        this.castingAttributes = castingAttributes;
    }

    public SpellHolder(NBTTagCompound nbtTagCompound) {
        this.deserializeNBT(nbtTagCompound);
    }

    @Override
    public ISpell getSpell() {
        return this.spell;
    }

    @Override
    public CastingAttributes getCastingAttributes() {
        return this.castingAttributes;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound spellInfo = new NBTTagCompound();
        spellInfo.setString("name", spell.getName().toString());
        spellInfo.setTag("castingAttributes", this.castingAttributes.writeToNBT(new NBTTagCompound()));
        return spellInfo;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        this.spell = FantasyAPI.getSpellRegistry().getSpell(nbt.getString("name"));
        this.castingAttributes = new CastingAttributes(nbt.getCompoundTag("castingAttributes"));
    }
}
