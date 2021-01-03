package videogamesm12.cockblocker.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.PlayerSkinTexture;
import net.minecraft.client.texture.ResourceTexture;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;

/**
 * PlayerSkinTextureInjector - Cockblocks exploits related to player skin textures.
 * @author Video
 */
@Mixin(PlayerSkinTexture.class)
public class PlayerSkinTextureInjector
{
    /**
     * This fixes an exploit present in versions of Minecraft up to 1.16.4, which takes advantage of a bug in the skins
     * handler that causes clients to crash if a provided skin texture is too small.
     *
     * The solution to the exploit (one which does not require the game's code to be modified directly) is to add a
     * check to see if the skin's texture is too small. If so, it'll replace the skin texture with the default skin.
     * It does not check the default skin, however.
     *
     * @param image NativeImage
     */
    @Inject(method = "remapTexture", at = @At("HEAD"), cancellable = true)
    private static void injectRemapTexture(NativeImage image, CallbackInfoReturnable<NativeImage> cir)
    {
        if (image.getHeight() < 32 || image.getWidth() < 64)
        {
            Identifier id = DefaultSkinHelper.getTexture();
            //
            ReloadableResourceManager rm = ((ClientAccessor) MinecraftClient.getInstance()).getResourceManager();
            ResourceTexture.TextureData data = ResourceTexture.TextureData.load(rm, id);
            //
            try
            {
                image = data.getImage();
                //
                PlayerSkinTextureInvoker.invokeStripAlpha(image, 0, 0, 32, 16);
                PlayerSkinTextureInvoker.invokeStripAlpha(image, 0, 16, 64, 32);
                PlayerSkinTextureInvoker.invokeStripAlpha(image, 16, 48, 48, 64);
                //
                cir.setReturnValue(image);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
