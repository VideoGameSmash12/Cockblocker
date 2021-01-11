package videogamesm12.cockblocker.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

/**
 * CockblockerConfig - Stores Cockblocker's configuration data.
 * @author Video
 */
@Config(name = "cockblocker")
public class CockblockerConfig implements ConfigData
{
    @ConfigEntry.Category("server")
    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    public ServerBooleans srv_booleans = new ServerBooleans();

    @ConfigEntry.Category("client")
    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    public ClientBooleans cnt_booleans = new ClientBooleans();

    @ConfigEntry.Category("client")
    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    public ClientVariables cnt_variables = new ClientVariables();

    public static class ServerBooleans
    {
        @ConfigEntry.Gui.Tooltip(count = 3)
        public boolean use_spawnpoint_cmd_oob_patch = true;

        @ConfigEntry.Gui.Tooltip(count = 3)
        public boolean use_setworldspawn_cmd_oob_patch = true;

        @ConfigEntry.Gui.Tooltip(count = 4)
        public boolean use_fire_block_direction_patch = true;
    }

    public static class ClientBooleans
    {
        @ConfigEntry.Gui.Tooltip(count = 2)
        public boolean use_entity_length_patch = true;

        @ConfigEntry.Gui.Tooltip(count = 3)
        public boolean use_skin_size_patch = true;
    }

    public static class ClientVariables
    {
        public int max_entity_name_length = 32;
    }
}
