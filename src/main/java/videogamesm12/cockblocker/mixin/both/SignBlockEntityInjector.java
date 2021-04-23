package videogamesm12.cockblocker.mixin.both;

import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import videogamesm12.cockblocker.Cockblocker;

/**
 * SignBlockEntityInjector - Cockblocks exploits related to signs.
 * @author Video
 */
@Mixin(SignBlockEntity.class)
public class SignBlockEntityInjector
{
    /**
     * This completely disables "run_command" events caused by right clicking specially-crafted text in signs, completely
     * nullifying the effects of command signs.
     *
     * @param player PlayerEntity
     * @param cir CallbackInfoReturnable<Boolean>
     */
    @Inject(method = "onActivate", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/command/CommandManager;execute(Lnet/minecraft/server/command/ServerCommandSource;Ljava/lang/String;)I"), cancellable = true)
    public void injectOnActivate(PlayerEntity player, CallbackInfoReturnable<Boolean> cir)
    {
        if (Cockblocker.config.cnt_booleans.use_run_command_on_click_patch)
        {
            cir.setReturnValue(true);
        }
    }
}
