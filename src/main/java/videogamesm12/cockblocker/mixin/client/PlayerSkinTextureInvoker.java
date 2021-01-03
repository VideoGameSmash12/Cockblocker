package videogamesm12.cockblocker.mixin.client;

import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.PlayerSkinTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/**
 * PlayerSkinTextureInvoker - Hooks into PlayerSkinTexture and invokes some of its methods.
 * @author Video
 */
@Mixin(PlayerSkinTexture.class)
public interface PlayerSkinTextureInvoker
{
    /**
     * Invokes the stripAlpha method in PlayerSkinTexture.
     *
     * @param image NativeImage
     * @param x Integer
     * @param y Integer
     * @param width Integer
     * @param height Integer
     */
    @Invoker("stripAlpha")
    public static void invokeStripAlpha(NativeImage image, int x, int y, int width, int height)
    {
        throw new AssertionError();
    }
}
