package videogamesm12.cockblocker.mixin.both;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import videogamesm12.cockblocker.Cockblocker;

/**
 * AbstractFireBlockInjector - Cockblocks exploits related to Fire.
 * @author Video
 */
@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockInjector
{
    /**
     * This fixes a game-crashing exploit in Minecraft 1.16.x, which takes advantage of an oversight in the way it
     * checks for Obsidian, which causes servers and clients to crash when the fire block is facing down or up.
     *
     * The solution implemented here is to simply not search for Obsidian blocks if the directions are either of those
     * directions.
     *
     * @implNote Some code from PaperMC was used to make this patch for Cockblocker. You can view the commit I used as
     * reference here: https://github.com/PaperMC/Paper/commit/428db483a7af6978f90cfa952514798fb9847a05
     *
     * @param world World
     * @param blockPos BlockPos
     * @param direction Direction
     * @param cir CallbackInfoReturnable<Boolean>
     */
    @Inject(method = "method_30033", at = @At("HEAD"), cancellable = true)
    private static void injectMethod30033(World world, BlockPos blockPos, Direction direction, CallbackInfoReturnable<Boolean> cir)
    {
        if (Cockblocker.config.srv_booleans.use_fire_block_direction_patch)
        {
            switch (direction)
            {
                case DOWN:
                case UP:
                    cir.setReturnValue(false);
                    break;
                default:
                    break;
            }
        }
    }
}
