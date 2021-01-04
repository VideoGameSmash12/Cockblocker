package videogamesm12.cockblocker.client;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import videogamesm12.cockblocker.config.CockblockerConfig;

/**
 * ModMenuScreen - Cockblocker's Mod Menu integration
 * @author Video
 */
@Environment(EnvType.CLIENT)
public class ModMenuScreen implements ModMenuApi
{
    /**
     * Get the configuration screen for the Mod Menu mod.
     *
     * @return ConfigScreenFactory<?>
     */
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory()
    {
        return parent -> AutoConfig.getConfigScreen(CockblockerConfig.class, parent).get();
    }
}
