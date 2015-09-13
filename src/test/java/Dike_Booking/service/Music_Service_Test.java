package Dike_Booking.service;

import Dike_Booking.App;
import Dike_Booking.Service.Flight_Service;
import Dike_Booking.Service.Music_Service;
import Dike_Booking.config_factory.MusicFactory;
import Dike_Booking.domain.Flight;
import Dike_Booking.domain.Music;
import Dike_Booking.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class Music_Service_Test extends AbstractTestNGSpringContextTests {
    private Integer music_id;
    @Autowired
    private Music_Service service;
    @Autowired
    private MusicRepository repo;

    @Test
    public void create() throws Exception {
        List<Music> musicList = new ArrayList<Music>();
        Map<String,String> values = new HashMap<String,String>();
        values.put("music_type","House");
        values.put("artist","Black coffee");



        Music event = MusicFactory
                .createMusic(values);

        repo.save(event);
        music_id = event.getMusic_id();
        Assert.assertNotNull(event.getMusic_id());
    }
    @Test
    public void testEventinfo() throws Exception {

        List<Music> music=service.getMusic();
        org.testng.Assert.assertTrue(music.size() == 4);

    }
}
