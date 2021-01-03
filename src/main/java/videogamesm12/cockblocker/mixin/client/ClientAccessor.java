package videogamesm12.cockblocker.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.FontManager;
import net.minecraft.resource.ReloadableResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * Client Accessor - Gets certain fields from the Minecraft client.
 * @author Video
 */
@Mixin(MinecraftClient.class)
public interface ClientAccessor
{
    @Accessor("resourceManager")
    public ReloadableResourceManager getResourceManager();

    @Accessor("fontManager")
    public FontManager getFontManager();
}
