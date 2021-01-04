package videogamesm12.cockblocker.mixin.both;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.SpawnPointCommand;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import videogamesm12.cockblocker.Cockblocker;

import java.util.Collection;

/**
 * SpawnPointCommandInjector - Cockblocks exploits related to the /spawnpoint command.
 * @author Video
 */
@Mixin(SpawnPointCommand.class)
public class SpawnPointCommandInjector
{
    private static final SimpleCommandExceptionType INVALID_POSITION_EXCEPTION = new SimpleCommandExceptionType(new TranslatableText("commands.spawnpoint.invalidPosition"));

    /**
     * This fixes an exploit present in versions of Minecraft up to 1.16.4, which takes advantage of an oversight in the
     * /spawnpoint command where it doesn't check if the provided coordinates are valid.
     *
     * The solution implemented here checks the coordinates using WorldInvoker to determine whether or not they are
     * valid.
     *
     * @param source ServerCommandSource
     * @param targets Collection<ServerPlayerEntity>
     * @param pos BlockPos
     * @param angle Float
     * @param cir CallbackInfoReturnable
     * @throws CommandSyntaxException If the command contains an invalid syntax.
     */
    @Inject(method = "execute", at = @At("INVOKE"), cancellable = true)
    private static void injectExecute(ServerCommandSource source, Collection<ServerPlayerEntity> targets, BlockPos pos, float angle, CallbackInfoReturnable<Integer> cir) throws CommandSyntaxException
    {
        if (Cockblocker.config.srv_booleans.use_spawnpoint_cmd_oob_patch)
        {
            if (!WorldInvoker.invokeIsValid(pos))
            {
                throw INVALID_POSITION_EXCEPTION.create();
            }
        }
    }
}
