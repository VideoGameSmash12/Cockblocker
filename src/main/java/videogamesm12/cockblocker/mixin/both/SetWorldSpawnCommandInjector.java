package videogamesm12.cockblocker.mixin.both;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.SetWorldSpawnCommand;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import videogamesm12.cockblocker.Cockblocker;

/**
 * SetWorldSpawnCommandInjector - Cockblocks exploits related to the /setworldspawn command.
 * @author Video
 */
@Mixin(SetWorldSpawnCommand.class)
public class SetWorldSpawnCommandInjector
{
    private static final SimpleCommandExceptionType INVALID_POSITION_EXCEPTION = new SimpleCommandExceptionType(new TranslatableText("commands.setworldspawn.invalidPosition"));

    /**
     * This fixes an exploit present in versions of Minecraft up to 1.16.5, which takes advantage of an oversight in the
     * /setworldspawn command where it doesn't check if the provided coordinates are valid.
     *
     * The solution implemented here checks the coordinates using WorldInvoker to determine whether or not they are
     * valid.
     *
     * @param source ServerCommandSource
     * @param pos BlockPos
     * @param angle Float
     * @param cir CallbackInfoReturnable
     * @throws CommandSyntaxException If the command contains an invalid syntax.
     */
    @Inject(method = "execute", at = @At("INVOKE"), cancellable = true)
    private static void injectExecute(ServerCommandSource source, BlockPos pos, float angle, CallbackInfoReturnable<Integer> cir) throws CommandSyntaxException
    {
        if (Cockblocker.config.srv_booleans.use_setworldspawn_cmd_oob_patch)
        {
            if (!WorldInvoker.invokeIsValid(pos))
            {
                throw INVALID_POSITION_EXCEPTION.create();
            }
        }
    }
}
