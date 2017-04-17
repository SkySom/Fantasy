package io.sommers.fantasy.modules.foundation.items;

import com.teamacronymcoders.base.items.ItemBase;
import io.sommers.fantasy.api.FantasyCaps;
import io.sommers.fantasy.api.spells.CastingAttributes;
import io.sommers.fantasy.api.spells.ISpell;
import io.sommers.fantasy.api.spells.spellholder.ISpellHolder;
import io.sommers.fantasy.api.spells.spellholder.SpellHolder;
import io.sommers.fantasy.api.spells.spellholder.SpellHolderProvider;
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

public class ItemScroll extends ItemBase {
    public ItemScroll() {
        super("scroll");
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        EnumActionResult result = EnumActionResult.PASS;
        ItemStack itemStack = player.getHeldItem(hand);
        if (itemStack.hasCapability(FantasyCaps.spellHolder, null)) {
            ISpellHolder spellHolder = itemStack.getCapability(FantasyCaps.spellHolder, null);
            if (spellHolder != null) {
                ISpell spell = spellHolder.getSpell();
                if (spell.canCast(player)) {
                    spell.startCast(player, spellHolder.getCastingAttributes());
                }
            }
        }
        return new ActionResult<>(result, itemStack);
    }

    @Override
    @Nullable
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        ICapabilityProvider provider = null;
        if (nbt != null && nbt.hasKey("spell")) {
            ISpellHolder spellHolder = new SpellHolder(nbt.getCompoundTag("spell"));
            provider = new SpellHolderProvider(spellHolder);
        }
        return provider;
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
