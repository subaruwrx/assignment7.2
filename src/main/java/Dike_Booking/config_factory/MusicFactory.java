package Dike_Booking.config_factory;

import Dike_Booking.domain.Music;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class MusicFactory {
    public static Integer music_id;
    public static Music createMusic(Map<String, String> values)
    {
        Music music = new Music
                .Builder(values.get("music_type"))
                .artist(values.get("artist"))
                .music_id(music_id)
                .build();
        return music;
    }
}
