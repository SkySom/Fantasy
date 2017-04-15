package io.sommers.fantasy.modules.foundation.items;

import com.teamacronymcoders.base.items.ItemBase;
import io.sommers.fantasy.api.spells.IProjectileSpell;
import net.minecraft.item.ItemStack;

public class ItemScroll extends ItemBase {
    public ItemScroll() {
        super("scroll");
    }

    public ItemStack getItemStackFor(IProjectileSpell spell) {
        return new ItemStack(this);
    }
}
