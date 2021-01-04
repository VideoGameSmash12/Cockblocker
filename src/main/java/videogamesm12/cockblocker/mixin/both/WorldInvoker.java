package videogamesm12.cockblocker.mixin.both;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/**
 * WorldInvoker - Hooks into World and invokes some of its methods.
 * @author Video
 */
@Mixin(World.class)
public interface WorldInvoker
{
    @Invoker("isValid")
    public static boolean invokeIsValid(BlockPos pos)
    {
        throw new AssertionError();
    }
}
