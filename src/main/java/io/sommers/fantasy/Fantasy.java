package io.sommers.fantasy;

import com.teamacronymcoders.base.BaseModFoundation;
import com.teamacronymcoders.base.creativetabs.CreativeTabBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = Fantasy.MOD_ID,
        name = Fantasy.MOD_NAME,
        version = Fantasy.VERSION
)
public class Fantasy extends BaseModFoundation<Fantasy> {

    public static final String MOD_ID = "fantasy";
    public static final String MOD_NAME = "Fantasy";
    public static final String VERSION = "1.0.0";

    public Fantasy() {
        super(MOD_ID, MOD_NAME, VERSION, new CreativeTabBase("fantasy", () -> new ItemStack(Items.STICK)));
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public Fantasy getInstance() {
        return this;
    }
}
