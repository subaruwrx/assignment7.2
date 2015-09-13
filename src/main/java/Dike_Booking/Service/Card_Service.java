package Dike_Booking.Service;

import Dike_Booking.domain.Credit_card_details;

import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
public interface Card_Service {
    List<Credit_card_details> getCardInfo();
}
