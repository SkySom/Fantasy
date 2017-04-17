package io.sommers.fantasy.modules.foundation.items;

import io.sommers.fantasy.api.FantasyAPI;
import io.sommers.fantasy.api.spells.CastingAttributes;
import io.sommers.fantasy.api.spells.ISpell;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public class ItemScroll extends ItemSpellCaster {
    public ItemScroll() {
        super("scroll");
    }

    @Override
    public boolean canCast(EntityLivingBase caster, ISpell spell, CastingAttributes castingAttributes) {
        return spell.canCast(caster);
    }

    public List<ItemStack> getAllSubItems(List<ItemStack> list) {
        for (ISpell spell : FantasyAPI.getSpellRegistry().getAllSpells()) {
            list.add(this.getItemStackFor(spell));
        }
        return list;
    }

    public ItemStack getItemStackFor(ISpell spell) {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        NBTTagCompound spellInfo = new NBTTagCompound();
        spellInfo.setString("name", spell.getName().toString());
        spellInfo.setTag("castingAttributes", new CastingAttributes(0.5, 0, 1).writeToNBT(new NBTTagCompound()));
        nbtTagCompound.setTag("spell", spellInfo);
        return new ItemStack(this, 1, 0, nbtTagCompound);
    }
}
