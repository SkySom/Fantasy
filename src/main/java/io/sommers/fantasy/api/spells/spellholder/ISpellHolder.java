package io.sommers.fantasy.api.spells.spellholder;

import io.sommers.fantasy.api.spells.CastingAttributes;
import io.sommers.fantasy.api.spells.ISpell;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public interface ISpellHolder extends INBTSerializable<NBTTagCompound> {
    ISpell getSpell();

    CastingAttributes getCastingAttributes();
}
