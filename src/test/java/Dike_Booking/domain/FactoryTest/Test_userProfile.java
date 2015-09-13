package Dike_Booking.domain.FactoryTest;

import Dike_Booking.config_factory.ProfileFactory;
import Dike_Booking.domain.User_profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class Test_userProfile {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreatedProfile() throws Exception {

        Map<String, String> values = new HashMap<String, String>();


        values.put("name", "Siba");
        values.put("surname","Dike");
        values.put("address","25 plein cape town");
        values.put("email","sibabalwe@gmail.com");
        values.put("te_no","0835670001");


        User_profile profile = ProfileFactory
                .createProfile( values);

        Assert.assertEquals("Siba", profile.getName());
        //Assert.assertEquals(101, profile.getUser_id());
    }

    @Test
    public void testUpdateProfile() throws Exception {

        Map<String, String> values = new HashMap<String, String>();


        values.put("name", "Siba");
        values.put("surname","Dike");
        values.put("address","25 plein cape town");
        values.put("email","sibabalwe@gmail.com");
        values.put("te_no","0835670001");


        User_profile profile = ProfileFactory
                .createProfile(values);



        User_profile profile1 = new  User_profile
                .Builder(profile.getUser_id())
                .copy(profile)
                .build();
        //Assert.assertEquals(101, profile1.getUser_id());

    }

}
