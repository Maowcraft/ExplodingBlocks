package maowcraft.explodingblocks.config;

import maowcraft.explodingblocks.ExplodingBlocks;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = ExplodingBlocks.MODID)
public class ExplodingBlocksConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    private int chance = 200;

    @ConfigEntry.Gui.Tooltip
    private boolean createFire = true;

    @ConfigEntry.Gui.Tooltip
    private boolean outputChance = false;

    @ConfigEntry.Gui.Tooltip
    private float explosionPower = 15.0f;

    public int getChance() {
        return chance;
    }
    public boolean willOutputChance() {
        return outputChance;
    }
    public boolean willCreateFire() {
        return createFire;
    }
    public float getExplosionPower() {
        return explosionPower;
    }
}
