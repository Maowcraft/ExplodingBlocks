package maowcraft.explodingblocks.mixin;

import maowcraft.explodingblocks.config.ExplodingBlocksConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.ThreadLocalRandom;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "onPlaced", at = @At("HEAD"))
    public void explosionOnPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack, CallbackInfo ci) {
        if (!world.isClient()) {
            ExplodingBlocksConfig config = AutoConfig.getConfigHolder(ExplodingBlocksConfig.class).getConfig();
            int randomInt = ThreadLocalRandom.current().nextInt(config.getChance()) + 1;
            if (config.willOutputChance()) {
                System.out.println(randomInt);
            }
            if (randomInt == config.getChance()) {
                TntEntity entity = new TntEntity(world, pos.getX(), pos.getY(), pos.getZ(), placer);
                world.createExplosion(entity, pos.getX(), pos.getY(), pos.getZ(), config.getExplosionPower(), config.willCreateFire(), Explosion.DestructionType.DESTROY);
            }
        }
    }
}
