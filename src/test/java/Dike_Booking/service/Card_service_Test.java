package Dike_Booking.service;

import Dike_Booking.App;
import Dike_Booking.Service.Card_Service;
import Dike_Booking.config_factory.CreditFactory;
import Dike_Booking.domain.Credit_card_details;
import Dike_Booking.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/20.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class Card_service_Test extends AbstractTestNGSpringContextTests {

    private Integer card_num;
    @Autowired
    private Card_Service service;

    @Autowired
    public CardRepository repo;

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("card_holder","Sibabalwe Dike");
        values.put("card_type","MasterCard");
        values.put("expiration_month","May");
        values.put("expiration_year","2016");


        Credit_card_details card = CreditFactory
                .createCredit(values);

        repo.save(card);
        card_num = card.getCard_num();
        Assert.assertNotNull(card_num);
    }

    @Test
    public void testCardinfo() throws Exception {

        List<Credit_card_details> card=service.getCardInfo();
        Assert.assertTrue(card.size() == 3);

    }
}
