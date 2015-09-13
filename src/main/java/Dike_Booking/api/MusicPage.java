package Dike_Booking.api;

import Dike_Booking.Service.Music_Service;
import Dike_Booking.domain.Music;
import Dike_Booking.model.MusicResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/24.
 */
@RestController
@RequestMapping(value="/music/**")
public class MusicPage {
    @Autowired
    private Music_Service service;
    @RequestMapping(value = "/music", method = RequestMethod.GET)

    public List<MusicResource> getPlaylists() {
        List<MusicResource> hateos = new ArrayList<>();
        List<Music> playlist = service.getMusic();
        for (Music music : playlist) {
            MusicResource res = new MusicResource
                    .Builder(music.getMusic_type())
                    .music_id(music.getMusic_id())
                    .artist(music.getArtist())
                    .build();
                     hateos.add(res);
        }
        return hateos;
    }
}