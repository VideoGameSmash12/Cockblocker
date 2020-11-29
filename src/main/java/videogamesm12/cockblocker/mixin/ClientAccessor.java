package videogamesm12.cockblocker.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ReloadableResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MinecraftClient.class)
public interface ClientAccessor
{
    @Accessor("resourceManager")
    public ReloadableResourceManager getResourceManager();
}
