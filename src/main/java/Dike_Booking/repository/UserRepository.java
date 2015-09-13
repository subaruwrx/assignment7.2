package Dike_Booking.repository;

import Dike_Booking.domain.User_profile;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/14.
 */
public interface UserRepository extends CrudRepository<User_profile,Integer>{
}
