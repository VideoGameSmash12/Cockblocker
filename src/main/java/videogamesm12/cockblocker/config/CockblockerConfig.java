package videogamesm12.cockblocker.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.util.Identifier;

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

        @ConfigEntry.Gui.Tooltip(count = 7)
        public boolean use_fire_block_direction_patch = true;
    }

    public static class ClientBooleans
    {
        @ConfigEntry.Gui.Tooltip(count = 2)
        public boolean use_entity_length_patch = true;

        @ConfigEntry.Gui.Tooltip(count = 3)
        public boolean use_skin_size_patch = true;

        @ConfigEntry.Gui.Tooltip(count = 3)
        public boolean use_run_command_on_click_patch = true;

        @ConfigEntry.Gui.Tooltip(count = 2)
        public boolean use_absorption_hud_patch = true;

        //@ConfigEntry.Gui.Tooltip(count = 2)
        //public boolean use_item_name_length_patch = true;
    }

    public static class ClientVariables
    {
        public int max_entity_name_length = 32;

        //public int max_item_name_length = 32;

        public int max_absorption_heart_count = 32;

        @ConfigEntry.Gui.Tooltip(count = 3)
        public HeadPatchMethod head_patch_method = HeadPatchMethod.texture;
    }

    public enum HeadPatchMethod
    {
        vanilla(DefaultSkinHelper.getTexture()),
        texture(new Identifier("cockblocker", "textures/replacements/replacement_head_texture.png"));

        public final Identifier identifier;

        HeadPatchMethod(Identifier id)
        {
            this.identifier = id;
        }
    }
}
