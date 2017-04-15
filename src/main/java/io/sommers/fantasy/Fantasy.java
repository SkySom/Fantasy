package io.sommers.fantasy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = Fantasy.MOD_ID,
        name = Fantasy.MOD_NAME,
        version = Fantasy.VERSION
)
public class Fantasy {

    public static final String MOD_ID = "fantasy";
    public static final String MOD_NAME = "Fantasy";
    public static final String VERSION = "1.0.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
