package videogamesm12.cockblocker.mixin.client;

import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import videogamesm12.cockblocker.Cockblocker;

/**
 * InGameHudInjector - Cockblocks exploits related to the in-game HUD.
 * @author Video
 */
@Mixin(InGameHud.class)
public class InGameHudInjector
{
    /**
     * This mitigates an exploit in versions of Minecraft up to 1.16.5, which takes advantage of the lack of a cap in
     * how many hearts are rendered when a player has the Absorption effect.
     *
     * The solution here is to simply add a customizable cap to the amount of hearts that can be rendered.
     *
     * @param absorption Integer
     * @return Integer (Capped value if it exceeded the maximum heart count)
     */
    @ModifyVariable(method = "renderStatusBars", at = @At("STORE"), ordinal = 6)
    public int injectRenderStatusBars(int absorption)
    {
        if (!Cockblocker.config.cnt_booleans.use_absorption_hud_patch)
        {
            return absorption;
        }

        return Math.min(absorption, Cockblocker.config.cnt_variables.max_absorption_heart_count * 2);
    }
}
