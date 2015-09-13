package Dike_Booking.repository;

import Dike_Booking.App;
import Dike_Booking.config_factory.EventFactory;
import Dike_Booking.config_factory.MusicFactory;
import Dike_Booking.domain.Event;
import Dike_Booking.domain.Music;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class Test_Crud_music extends AbstractTestNGSpringContextTests {

    private Integer music_id;

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
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Music music= repo.findOne(music_id);
        org.testng.Assert.assertNotNull(music);


    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Music music  = repo.findOne(music_id);

        Music newMusic  = new Music
                .Builder(music.getMusic_type())
                .copy(music)
                .artist("Culoe")
                .music_id(music.getMusic_id())
                .build();

        repo.save(newMusic);

       Music  updateMusic = repo.findOne(music_id);
        org.testng.Assert.assertEquals(updateMusic.getArtist(),"Culoe");
    }


    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Music music = repo.findOne(music_id);
        repo.delete(music);
        Music deletedMusic = repo.findOne(music_id);
        org.testng.Assert.assertNull(deletedMusic);

    }

}
