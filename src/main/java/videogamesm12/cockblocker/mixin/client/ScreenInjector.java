package videogamesm12.cockblocker.mixin.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Style;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import videogamesm12.cockblocker.Cockblocker;

/**
 * ScreenInjector - Cockblocks exploits related to in-game menus.
 * @author Video
 */
@Mixin(Screen.class)
public class ScreenInjector
{
    /**
     * This completely disables "run_command" events caused by right clicking specially-crafted text in menus,
     * nullifying the effects of command books entirely in the process.
     *
     * @param style Style
     * @param cir CallbackInfoReturnable<Boolean>
     */
    @Inject(method = "handleTextClick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/Screen;sendMessage(Ljava/lang/String;Z)V"), cancellable = true)
    public void injectHandleTextClick(Style style, CallbackInfoReturnable<Boolean> cir)
    {
        if (Cockblocker.config.cnt_booleans.use_run_command_on_click_patch)
        {
            cir.setReturnValue(false);
        }
    }
}
