package Dike_Booking.Service.impl;

import Dike_Booking.Service.SportService;
import Dike_Booking.domain.Music;
import Dike_Booking.domain.Sport;
import Dike_Booking.repository.MusicRepository;
import Dike_Booking.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@Service
public class SportServiceImp implements SportService {
    @Autowired
    SportRepository repository;
    public List<Sport> getSport()
    {
        List<Sport> allSports=new ArrayList<Sport>();

        Iterable<Sport> sports = repository.findAll();
        for(Sport sport: sports)
        {
            allSports.add(sport);
        }
        return allSports;
    }
}
