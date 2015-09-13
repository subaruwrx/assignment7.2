package Dike_Booking.config_factory;

import Dike_Booking.domain.User_profile;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class ProfileFactory {
    public static Integer user_id;
    public static User_profile createProfile(Map<String, String> values)
    {
        User_profile profile= new User_profile
                .Builder(user_id)
                .name(values.get("name"))
                .surname(values.get("surname"))
                .address(values.get("address"))
                .email(values.get("email"))
                .tel(values.get("tel_no"))
                .pass(values.get("password"))
                .build();
        return profile;




    }
}
