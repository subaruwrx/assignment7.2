package Dike_Booking.api;

import Dike_Booking.Service.Bus_Service;
import Dike_Booking.Service.Event_Service;
import Dike_Booking.domain.Bus;
import Dike_Booking.domain.Event;
import Dike_Booking.model.BusResource;
import Dike_Booking.model.EventResource;
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
@RequestMapping(value="/bus/**")
public class BusPage {
    @Autowired
    private Bus_Service service;

    @RequestMapping(value = "/bus", method = RequestMethod.GET)

    public List<BusResource> getBus() {
        List<BusResource> hateos = new ArrayList<>();
        List<Bus> busname = service.getBusses();
        for (Bus bus : busname) {
            BusResource res = new BusResource
                    .Builder(bus.getbus_name())
                    .trip_id(bus.getTrip_id())
                    .from(bus.getFrom_location())
                    .to(bus.getTo_location())
                    .dep_time(bus.getDeparture_time())
                    .arr_time(bus.getArrival_time())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }

}
