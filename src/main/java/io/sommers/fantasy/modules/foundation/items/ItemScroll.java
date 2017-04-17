package io.sommers.fantasy.modules.foundation.items;

import com.teamacronymcoders.base.items.ItemBase;
import io.sommers.fantasy.api.spells.ISpell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemScroll extends ItemBase {
    public ItemScroll() {
        super("scroll");
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        EnumActionResult result = EnumActionResult.PASS;
        ItemStack itemStack = player.getHeldItem(hand);
        if (itemStack.hasCapability())
        return new ActionResult<>(result, itemStack);
    }

    public ItemStack getItemStackFor(ISpell spell) {
        ItemStack itemStack = new ItemStack(this);
        itemStack.getOrCreateSubCompound("spell").setString("name", spell.getName().toString());
        return itemStack;
    }
}
