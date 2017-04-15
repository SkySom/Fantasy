package io.sommers.fantasy.api;

import io.sommers.fantasy.Fantasy;
import io.sommers.fantasy.api.spells.ISpellRegistry;

public class FantasyAPI {
    private static FantasyAPI api;

    private ISpellRegistry spellRegistry;

    public static FantasyAPI getInstance() {
        return api;
    }

    public static void setInstance(FantasyAPI fantasyAPI) {
        if (api == null) {
            api = fantasyAPI;
        } else {
            throw new RuntimeException("THE FANTASY API WAS SET TWICE");
        }
    }

    public FantasyAPI(ISpellRegistry spellRegistry) {
        this.spellRegistry = spellRegistry;
    }

    public ISpellRegistry getSpellRegistry() {
        return this.spellRegistry;
    }
}
