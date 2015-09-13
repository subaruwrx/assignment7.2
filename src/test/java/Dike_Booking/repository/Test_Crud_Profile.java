package Dike_Booking.repository;

import Dike_Booking.App;
import Dike_Booking.config_factory.FilghtFactory;
import Dike_Booking.config_factory.ProfileFactory;
import Dike_Booking.domain.Flight;
import Dike_Booking.domain.User_profile;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/14.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class Test_Crud_Profile extends AbstractTestNGSpringContextTests {
    private Integer user_id;

    @Autowired
    public  UserRepository repo;

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Peter");
        values.put("surname","Dike");
        values.put("address","33 cape town");
        values.put("email","siba@gmail.com");
        values.put("tel_no","0835670001");
        values.put("password","12345");



        User_profile profile = ProfileFactory
                .createProfile(values);

        repo.save(profile);
        user_id= profile.getUser_id();
        Assert.assertNotNull(profile.getUser_id());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        User_profile profile = repo.findOne(user_id);
        org.testng.Assert.assertNotNull(profile);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        User_profile profile = repo.findOne(user_id);

        User_profile newProfile = new  User_profile
                .Builder(profile.getUser_id())
                .copy(profile)
                .name("Sibabalwe")
                .surname(profile.getSurname())
                .address(profile.getAddress())
                .email(profile.getEmail())
                .tel(profile.getTel_no())
                .pass(profile.getPassword())
                .build();

        repo.save(newProfile);

        User_profile updateUser = repo.findOne(user_id);
        Assert.assertEquals(updateUser.getName(),"Sibabalwe");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        User_profile profile = repo.findOne(user_id);
        repo.delete(profile);
        User_profile deletedUser  = repo.findOne(user_id);
        Assert.assertNull(deletedUser);

    }
}
