package videogamesm12.cockblocker.mixin.client;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import videogamesm12.cockblocker.Cockblocker;

/**
 * EntityRendererInjector - Cockblocks exploits related to the entity renderer.
 * @author Video
 */
@Mixin(EntityRenderer.class)
public class EntityRendererInjector
{
    /**
     * This fixes an exploit present in versions of Minecraft up to 1.16.4, which takes advantage of the lag-producing
     * side-effects of rendering entities with too much text in a custom name.
     *
     * The solution implemented here is to simply shorten how much text actually gets rendered.
     *
     * TODO: Make the maximum length configurable.
     *
     * @param text Text
     * @return Text
     */
    @ModifyVariable(method = "renderLabelIfPresent", at = @At(value = "INVOKE"))
    private Text injectRenderLabelIfPresentText(Text text)
    {
        if (text.getString().length() > Cockblocker.MAX_ENTITY_NAME_LENGTH)
        {
            LiteralText ltext = new LiteralText(text.getString().substring(0, Cockblocker.MAX_ENTITY_NAME_LENGTH));
            ltext.setStyle(text.getStyle());
            //
            return ltext;
        }
        return text;
    }
}
