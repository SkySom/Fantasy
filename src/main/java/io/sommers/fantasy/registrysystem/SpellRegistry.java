package io.sommers.fantasy.registrysystem;

import com.teamacronymcoders.base.IBaseMod;
import com.teamacronymcoders.base.registrysystem.ModularRegistry;
import com.teamacronymcoders.base.registrysystem.pieces.IRegistryPiece;
import io.sommers.fantasy.api.spells.ISpell;

import java.util.List;

public class SpellRegistry extends ModularRegistry<ISpell> {
    public SpellRegistry(IBaseMod mod, List<IRegistryPiece> registryPieces) {
        super("SPELL", mod, registryPieces);
    }
}
