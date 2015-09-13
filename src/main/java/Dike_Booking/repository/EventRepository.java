package Dike_Booking.repository;

import Dike_Booking.domain.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/12.
 */
public interface EventRepository extends CrudRepository<Event,Long>{
    //public Event findByCode(int code);
}
