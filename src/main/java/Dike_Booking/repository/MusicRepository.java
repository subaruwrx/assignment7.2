package Dike_Booking.repository;

import Dike_Booking.domain.Music;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/12.
 */
public interface MusicRepository extends CrudRepository<Music,Integer> {
    //public Music find_byMusic_type(String music_type);
}
