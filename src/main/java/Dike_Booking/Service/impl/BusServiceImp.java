package Dike_Booking.Service.impl;

import Dike_Booking.Service.Bus_Service;
import Dike_Booking.domain.Bus;
import Dike_Booking.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/19.
 */
@Service
public class BusServiceImp implements Bus_Service {
    @Autowired
    BusRepository repository;
    public List<Bus> getBusses()
    {
        List<Bus> allBusses=new ArrayList<Bus>();

        Iterable<Bus> busses = repository.findAll();
        for(Bus bus: busses)
        {
            allBusses.add(bus);
        }
        return allBusses;
    }
}
