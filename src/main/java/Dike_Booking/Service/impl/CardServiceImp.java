package Dike_Booking.Service.impl;

import Dike_Booking.Service.Card_Service;
import Dike_Booking.domain.Bus;
import Dike_Booking.domain.Credit_card_details;
import Dike_Booking.repository.BusRepository;
import Dike_Booking.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class CardServiceImp implements Card_Service {
    @Autowired
    CardRepository repository;
    @Override
    public List<Credit_card_details> getCardInfo()
    {
        List<Credit_card_details> allcards=new ArrayList<Credit_card_details>();

        Iterable<Credit_card_details> cards = repository.findAll();
        for(Credit_card_details card: cards)
        {
            allcards.add(card);
        }
        return allcards;
    }
}
