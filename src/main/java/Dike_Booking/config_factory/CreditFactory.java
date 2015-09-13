package Dike_Booking.config_factory;

import Dike_Booking.domain.Credit_card_details;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class CreditFactory {
    public static Integer card_num;
    public static Credit_card_details createCredit( Map<String, String> values)
    {


        Credit_card_details card =new Credit_card_details
                .Builder(card_num)
                .card_holder(values.get("card_holder"))
                .card(values.get("card_type"))
                .month(values.get("expiration_month"))
                .year(values.get("expiration_year"))
                .build();
        return card;
    }
}
