package Dike_Booking.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/13.
 */
public class FlightResource extends ResourceSupport {
    private Integer flight_id;
    private String from_location;
    private String to_location;
    private String departure_time;
    private String arrival_time;

    private FlightResource()
    {

    }

    public Integer getFlight_id()
    {
        return flight_id;
    }

    public String getFrom_location()
    {
        return from_location;
    }

    public String getTo_location()
    {
        return to_location;
    }
    public String getDeparture_time()
    {
        return departure_time;
    }

    public String getArrival_time()
    {
        return arrival_time;
    }

    public FlightResource (Builder builder)
    {
        flight_id=builder.flight_id;
        from_location=builder.from_location;
        to_location=builder.to_location;
        departure_time=builder.departure_time;
        arrival_time=builder.arrival_time;
    }
    public static class Builder{
        private Integer flight_id;
        private String from_location;
        private String to_location;
        private String departure_time;
        private String arrival_time;

        public Builder(Integer flight_id)
        {
            this.flight_id=flight_id;

        }

        public Builder from(String value)
        {
            this.from_location=value;
            return this;
        }

        public Builder to(String value)
        {
            this.to_location=value;
            return this;

        }
        public Builder dep_time(String value)
        {
            this.departure_time=value;
            return this;
        }

        public Builder arr_time(String value)
        {
            this.arrival_time=value;
            return this;
        }
        public Builder copy(FlightResource value)
        {
            this.flight_id=value.getFlight_id();
            this.arrival_time=value.getArrival_time();
            this.departure_time=value.getDeparture_time();
            this.from_location=value.getFrom_location();
            this.to_location=value.getTo_location();
            return this;
        }
        public FlightResource build()
        {
            return new FlightResource (this);
        }


    }
}
