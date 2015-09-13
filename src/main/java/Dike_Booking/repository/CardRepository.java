package Dike_Booking.repository;

import Dike_Booking.domain.Credit_card_details;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/11.
 */
public interface CardRepository extends CrudRepository<Credit_card_details,Integer> {
//public Credit_card_details findByCode(int code);
}
