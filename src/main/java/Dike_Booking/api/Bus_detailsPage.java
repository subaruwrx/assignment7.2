package Dike_Booking.api;

import Dike_Booking.Service.BusDetail_Service;
import Dike_Booking.Service.Bus_Service;
import Dike_Booking.domain.Bus;
import Dike_Booking.domain.Bus_details;
import Dike_Booking.model.BusResource;
import Dike_Booking.model.Bus_detailsResource;
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
@RequestMapping(value="/busDetails/**")
public class Bus_detailsPage {
    @Autowired
    private BusDetail_Service service;

    @RequestMapping(value = "/busDetails", method = RequestMethod.GET)

    public List<Bus_detailsResource> getBus() {
        List<Bus_detailsResource> hateos = new ArrayList<>();
        List<Bus_details> busname = service.getBusDetails();
        for (Bus_details bus : busname) {
            Bus_detailsResource res = new Bus_detailsResource
                    .Builder(bus.getBus_name())
                    .trip_id(bus.getTrip_id())
                    .trip_date(bus.getTrip_date())
                    .price(bus.getPrice())
                    .seat_aval(bus.getSeats_aval())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
