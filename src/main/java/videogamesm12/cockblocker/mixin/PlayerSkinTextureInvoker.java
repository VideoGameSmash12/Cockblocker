package videogamesm12.cockblocker.mixin;

import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.PlayerSkinTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PlayerSkinTexture.class)
public interface PlayerSkinTextureInvoker
{
    @Invoker("stripAlpha")
    public static void invokeStripAlpha(NativeImage image, int x, int y, int width, int height)
    {
        throw new AssertionError();
    }
}
