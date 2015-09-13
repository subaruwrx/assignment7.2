package Dike_Booking.config_factory;

import Dike_Booking.domain.Sport;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class SportFactory {
    public static Integer sport_id;
    public static Sport createSport(Map<String, String> values)
    {
        Sport sport=new Sport
                .Builder(values.get("sport_type"))
                .team(values.get("team"))
                .sport_id(sport_id)
                .build();
        return sport;
    }
}
