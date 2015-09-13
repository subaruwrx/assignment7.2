package Dike_Booking.api;

import Dike_Booking.Service.Card_Service;
import Dike_Booking.Service.Music_Service;
import Dike_Booking.domain.Credit_card_details;
import Dike_Booking.domain.Music;
import Dike_Booking.model.Credit_card_detailsResource;
import Dike_Booking.model.MusicResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@RestController
@RequestMapping(value="/Credit card details/**")
public class Credit_card_detailsPage {
    @Autowired
    private Card_Service service;
    @RequestMapping(value = "/Credit card details", method = RequestMethod.GET)

    public List<Credit_card_detailsResource> getCard_details() {
        List<Credit_card_detailsResource> hateos = new ArrayList<>();
        List<Credit_card_details> creditCard = service.getCardInfo();
        for (Credit_card_details card : creditCard) {
            Credit_card_detailsResource res = new Credit_card_detailsResource
                    .Builder(card.getCard_num())
                    .card(card.getCard_type())
                    .card_holder(card.getCardholder())
                    .month(card.getMonth())
                    .year(card.getYear())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }

}
