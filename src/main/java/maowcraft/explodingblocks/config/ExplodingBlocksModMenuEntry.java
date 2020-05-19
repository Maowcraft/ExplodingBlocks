package maowcraft.explodingblocks.config;

import io.github.prospector.modmenu.api.ModMenuApi;
import maowcraft.explodingblocks.ExplodingBlocks;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;

import java.util.function.Function;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class ExplodingBlocksModMenuEntry implements ModMenuApi {
    @Override
    public String getModId() {
        return ExplodingBlocks.MODID;
    }

    @Override
    public Function<Screen, ? extends Screen> getConfigScreenFactory() {
        return (screen) -> AutoConfig.getConfigScreen(ExplodingBlocksConfig.class, screen).get();
    }
}
