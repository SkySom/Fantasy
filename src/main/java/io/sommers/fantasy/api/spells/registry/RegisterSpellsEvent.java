package io.sommers.fantasy.api.spells.registry;

import io.sommers.fantasy.api.spells.ISpell;
import net.minecraftforge.fml.common.eventhandler.Event;

public class RegisterSpellsEvent extends Event {
    private ISpellRegistry spellRegistry;

    public RegisterSpellsEvent(ISpellRegistry spellRegistry) {
        this.spellRegistry = spellRegistry;
    }

    public void register(ISpell spell) {
        this.getSpellRegistry().addSpell(spell);
    }

    public ISpellRegistry getSpellRegistry() {
        return spellRegistry;
    }
}
