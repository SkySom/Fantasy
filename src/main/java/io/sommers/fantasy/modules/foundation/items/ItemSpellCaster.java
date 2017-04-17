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

public abstract class ItemSpellCaster extends ItemBase {
    public ItemSpellCaster(String name) {
        super(name);
    }

    public boolean canCast(EntityLivingBase caster, ISpell spell, CastingAttributes castingAttributes) {
        return spell.canCast(caster);
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        EnumActionResult result = EnumActionResult.PASS;
        ItemStack itemStack = player.getHeldItem(hand);
        ISpellHolder spellHolder = this.getSpellHolder(itemStack);
        if (spellHolder != null) {
            ISpell spell = spellHolder.getSpell();
            CastingAttributes castingAttributes = spellHolder.getCastingAttributes();
            if (this.canCast(player, spell, castingAttributes)) {
                spell.startCast(player, castingAttributes);
                result = EnumActionResult.SUCCESS;
            }
        }
        return new ActionResult<>(result, itemStack);
    }

    @Override
    public void onUsingTick(ItemStack itemStack, EntityLivingBase entityLiving, int count) {
        ISpellHolder spellHolder = this.getSpellHolder(itemStack);
        if (spellHolder != null) {
            ISpell spell = spellHolder.getSpell();
            CastingAttributes castingAttributes = spellHolder.getCastingAttributes();
            if (this.canCast(entityLiving, spell, castingAttributes)) {
                spell.onTickCasting(entityLiving, castingAttributes);
            }
        }
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityLivingBase entityLiving, int timeLeft) {
        ISpellHolder spellHolder = this.getSpellHolder(itemStack);
        if (spellHolder != null) {
            ISpell spell = spellHolder.getSpell();
            CastingAttributes castingAttributes = spellHolder.getCastingAttributes();
            if (this.canCast(entityLiving, spell, castingAttributes)) {
                spell.onFinishCasting(entityLiving, castingAttributes);
            }
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        int length = 0;
        ISpellHolder spellHolder = this.getSpellHolder(itemStack);
        if (spellHolder != null) {
            ISpell spell = spellHolder.getSpell();
            if (spell != null) {
                length = spell.getCastingLength();
                CastingAttributes castingAttributes = spellHolder.getCastingAttributes();
                if (castingAttributes != null) {
                    length = (int) Math.ceil(length * castingAttributes.getLength());
                }
            }
        }
        return length;
    }

    public ISpellHolder getSpellHolder(ItemStack itemStack) {
        ISpellHolder spellHolder = null;
        if (itemStack.hasCapability(FantasyCaps.spellHolder, null)) {
            spellHolder = itemStack.getCapability(FantasyCaps.spellHolder, null);
        }
        return spellHolder;
    }

    @Override
    @Nullable
    public ICapabilityProvider initCapabilities(ItemStack itemStack, @Nullable NBTTagCompound nbt) {
        ICapabilityProvider provider = null;
        if (nbt != null && nbt.hasKey("spell")) {
            ISpellHolder spellHolder = new SpellHolder(nbt.getCompoundTag("spell"));
            provider = new SpellHolderProvider(spellHolder);
        }
        return provider;
    }
}
