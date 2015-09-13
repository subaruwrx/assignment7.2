package Dike_Booking.repository;

import Dike_Booking.domain.Ticket_info;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/14.
 */
public interface TicketRepository extends CrudRepository<Ticket_info,Integer> {
}
