package videogamesm12.cockblocker;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import videogamesm12.cockblocker.config.CockblockerConfig;

public class Cockblocker implements ModInitializer
{
    public static CockblockerConfig config;

    @Override
    public void onInitialize()
    {
        loadConfiguration();
    }

    public void loadConfiguration()
    {
        AutoConfig.register(CockblockerConfig.class, GsonConfigSerializer::new);
        //
        config = AutoConfig.getConfigHolder(CockblockerConfig.class).getConfig();
    }
}
