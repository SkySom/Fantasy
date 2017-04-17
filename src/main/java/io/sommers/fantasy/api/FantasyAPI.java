package io.sommers.fantasy.api;

import io.sommers.fantasy.api.spells.registry.ISpellRegistry;
import io.sommers.fantasy.api.spells.registry.RegisterSpellsEvent;
import net.minecraftforge.common.MinecraftForge;

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
        MinecraftForge.EVENT_BUS.post(new RegisterSpellsEvent(spellRegistry));
    }

    public static ISpellRegistry getSpellRegistry() {
        return getInstance().spellRegistry;
    }
}
