package maowcraft.explodingblocks;

import maowcraft.explodingblocks.config.ExplodingBlocksConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class ExplodingBlocks implements ModInitializer {
    public static final String MODID = "explodingblocks";

    @Override
    public void onInitialize() {
        AutoConfig.register(ExplodingBlocksConfig.class, JanksonConfigSerializer::new);
    }
}
