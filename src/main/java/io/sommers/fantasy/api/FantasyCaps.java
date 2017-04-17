package io.sommers.fantasy.api;

import io.sommers.fantasy.api.spells.spellholder.ISpellHolder;
import io.sommers.fantasy.api.spells.spellholder.SpellHolder;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class FantasyCaps {
    @CapabilityInject(ISpellHolder.class)
    public static Capability<ISpellHolder> spellHolder;

    public static void registerCaps() {
        CapabilityManager.INSTANCE.register(ISpellHolder.class, new Capability.IStorage<ISpellHolder>() {
            @Override
            public NBTTagCompound writeNBT(Capability<ISpellHolder> capability, ISpellHolder instance, EnumFacing side) {
                return instance.serializeNBT();
            }

            @Override
            public void readNBT(Capability<ISpellHolder> capability, ISpellHolder instance, EnumFacing side, NBTBase nbt) {
                NBTTagCompound compound = (NBTTagCompound)nbt;
                instance.deserializeNBT(compound);
            }
        }, SpellHolder.class);
    }

}
