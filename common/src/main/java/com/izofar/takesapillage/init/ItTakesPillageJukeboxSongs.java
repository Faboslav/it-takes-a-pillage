/*? >=1.21 {*/
package com.izofar.takesapillage.init;

import com.izofar.takesapillage.ItTakesPillage;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

public class ItTakesPillageJukeboxSongs
{

    public static ResourceKey<JukeboxSong> BASTILLE_BLUES = create("bastille_blues");

    private static ResourceKey<JukeboxSong> create(String id) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ItTakesPillage.makeId(id));
    }
}
/*?}*/