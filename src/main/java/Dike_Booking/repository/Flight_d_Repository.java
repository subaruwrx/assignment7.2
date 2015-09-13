package Dike_Booking.repository;

import Dike_Booking.domain.Flight_details;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/14.
 */
public interface Flight_d_Repository extends CrudRepository<Flight_details,Integer> {
}
