package Dike_Booking.repository;

import Dike_Booking.App;
import Dike_Booking.config_factory.CreditFactory;
import Dike_Booking.domain.Credit_card_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/11.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class Test_Crud_Card  extends AbstractTestNGSpringContextTests {
    private Integer card_num;

    @Autowired
    public  CardRepository repo;

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
        Assert.assertNotNull(card.getCard_num());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Credit_card_details card = repo.findOne(card_num);
        Assert.assertNotNull(card);


    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Credit_card_details card = repo.findOne(card_num);

        Credit_card_details newcard = new Credit_card_details
                .Builder(card.getCard_num())
                .copy(card)
                .card_holder(card.getCardholder())
                .month("Jan")
                .year(card.getYear())
                .build();

        repo.save(newcard);

        Credit_card_details updatedCard = repo.findOne(card_num);
        Assert.assertEquals(updatedCard.getMonth(), "Jan");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Credit_card_details card = repo.findOne(card_num);
        repo.delete(card);
        Credit_card_details  deletedCard = repo.findOne(card_num);
        Assert.assertNull(deletedCard);

    }
}
