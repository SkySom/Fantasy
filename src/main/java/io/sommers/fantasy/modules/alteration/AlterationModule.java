package io.sommers.fantasy.modules.alteration;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import io.sommers.fantasy.api.spells.registry.ISpellRegistry;
import io.sommers.fantasy.api.spells.projectiles.ProjectileSpellBase;
import io.sommers.fantasy.modules.alteration.blocks.BlockMageLight;
import io.sommers.fantasy.modulesystem.FantasyModule;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import static io.sommers.fantasy.Fantasy.MOD_ID;

@Module(MOD_ID)
public class AlterationModule extends FantasyModule {
    public static BlockMageLight mageLight;

    @Override
    public String getName() {
        return "Alteration Spells";
    }

    @Override
    public void registerBlocks(ConfigRegistry configRegistry, BlockRegistry blockRegistry) {
        blockRegistry.register(mageLight = new BlockMageLight());
    }

    @Override
    public void registerSpells(ConfigRegistry configRegistry, ISpellRegistry spellRegistry) {
        spellRegistry.addSpell(new ProjectileSpellBase(new ResourceLocation(MOD_ID, "magelight"), 5) {
            @Override
            public void onHit(World world, RayTraceResult rayTraceResult) {
                world.setBlockState(rayTraceResult.getBlockPos(), mageLight.getDefaultState());
            }
        });
    }
}
