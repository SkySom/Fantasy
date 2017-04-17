package io.sommers.fantasy.modules.foundation.items;

import com.teamacronymcoders.base.items.ItemBase;
import io.sommers.fantasy.api.FantasyCaps;
import io.sommers.fantasy.api.spells.CastingAttributes;
import io.sommers.fantasy.api.spells.ISpell;
import io.sommers.fantasy.api.spells.spellholder.ISpellHolder;
import io.sommers.fantasy.api.spells.spellholder.SpellHolder;
import io.sommers.fantasy.api.spells.spellholder.SpellHolderProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ItemScroll extends ItemSpellCaster {
    public ItemScroll() {
        super("scroll");
    }

    @Override
    public boolean canCast(EntityLivingBase caster, ISpell spell, CastingAttributes castingAttributes) {
        return spell.canCast(caster);
    }

    public ItemStack getItemStackFor(ISpell spell) {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        NBTTagCompound spellInfo = new NBTTagCompound();
        spellInfo.setString("name", spell.getName().toString());
        spellInfo.setTag("castingAttributes", new CastingAttributes(0.5, 0).writeToNBT(new NBTTagCompound()));
        nbtTagCompound.setTag("spell", spellInfo);
        return new ItemStack(this, 1, 0, nbtTagCompound);
    }
}
