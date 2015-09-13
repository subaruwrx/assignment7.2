package Dike_Booking.api;

import Dike_Booking.Service.Ticket_Service;
import Dike_Booking.Service.UserProfile_Service;
import Dike_Booking.domain.Ticket_info;
import Dike_Booking.domain.User_profile;
import Dike_Booking.model.Ticket_infoResource;
import Dike_Booking.model.User_ProfileResource;
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
@RequestMapping(value="/User/**")
public class UserPage {
    @Autowired
    private UserProfile_Service service;
    @RequestMapping(value = "/Ticket", method = RequestMethod.GET)

    public List<User_ProfileResource> getProfile() {
        List<User_ProfileResource> hateos = new ArrayList<>();
        List<User_profile> user = service.getUserInfo();
        for (User_profile profile : user) {
            User_ProfileResource res = new User_ProfileResource
                    .Builder(profile.getUser_id())
                    .name(profile.getName())
                    .surname(profile.getSurname())
                    .address(profile.getAddress())
                    .email(profile.getEmail())
                    .pass(profile.getPassword())
                    .tel(profile.getTel_no())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
