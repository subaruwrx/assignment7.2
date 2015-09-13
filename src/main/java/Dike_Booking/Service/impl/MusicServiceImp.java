package Dike_Booking.Service.impl;

import Dike_Booking.Service.Music_Service;
import Dike_Booking.domain.Flight;
import Dike_Booking.domain.Music;
import Dike_Booking.repository.FlightRepository;
import Dike_Booking.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@Service
public class MusicServiceImp implements Music_Service {
    @Autowired
    MusicRepository repository;
    public List<Music> getMusic()
    {
        List<Music> allMusic=new ArrayList<Music>();

        Iterable<Music> musics = repository.findAll();
        for(Music music: musics)
        {
            allMusic.add(music);
        }
        return allMusic;
    }
}
