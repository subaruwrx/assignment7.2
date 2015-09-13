package Dike_Booking.Service.impl;

import Dike_Booking.Service.BusDetail_Service;
import Dike_Booking.domain.Bus;
import Dike_Booking.domain.Bus_details;
import Dike_Booking.repository.BusRepository;
import Dike_Booking.repository.Bus_d_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@Service
public class Bus_DeatailsServiceImp implements BusDetail_Service {
    @Autowired
    Bus_d_Repository repository;
    public List<Bus_details> getBusDetails() {
        List<Bus_details> allBusses=new ArrayList<Bus_details>();

        Iterable<Bus_details> busses = repository.findAll();
        for(Bus_details bus: busses)
        {
            allBusses.add(bus);
        }
        return allBusses;
    }
}
