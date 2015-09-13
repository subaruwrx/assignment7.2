package Dike_Booking.Service.impl;

import Dike_Booking.Service.UserProfile_Service;
import Dike_Booking.domain.Ticket_info;
import Dike_Booking.domain.User_profile;
import Dike_Booking.repository.TicketRepository;
import Dike_Booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@Service
public class UserProfileServiceImp implements UserProfile_Service {
    @Autowired
    UserRepository repository;
    public List<User_profile> getUserInfo() {
        List<User_profile> allProfiles=new ArrayList<User_profile>();

        Iterable<User_profile> profiles = repository.findAll();
        for(User_profile profile: profiles)
        {
            allProfiles.add(profile);
        }
        return allProfiles;
    }
}
