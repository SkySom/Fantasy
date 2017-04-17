package io.sommers.fantasy.api.spells.spellholder;

import io.sommers.fantasy.api.FantasyCaps;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SpellHolderProvider implements ICapabilityProvider {
    private ISpellHolder spellHolder;

    public SpellHolderProvider(ISpellHolder spellHolder) {
        this.spellHolder = spellHolder;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == FantasyCaps.spellHolder;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == FantasyCaps.spellHolder ? FantasyCaps.spellHolder.cast(this.spellHolder) : null;
    }
}
