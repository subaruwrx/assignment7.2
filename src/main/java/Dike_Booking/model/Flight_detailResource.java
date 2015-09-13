package Dike_Booking.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/13.
 */
public class Flight_detailResource extends ResourceSupport {
    private Integer flight_id;
    private String flight_date;
    private int price;
    private int seats_aval;

    private Flight_detailResource()
    {

    }

    public Integer getFlight_id()
    {
        return flight_id;
    }

    public String getFlight_date()
    {
        return flight_date;
    }

    public int getprice()
    {
        return price;
    }

    public int getSeats_aval()
    {
        return seats_aval;
    }

    public  Flight_detailResource(Builder builder){
        flight_id=builder.flight_id;
        flight_date=builder.flight_date;
        price=builder.price;
        seats_aval=builder.seats_aval;

    }
    public static class Builder{
        private Integer flight_id;
        private String flight_date;
        private int price;
        private int seats_aval;

        public Builder(Integer flight_id)
        {
            this.flight_id=flight_id;

        }
        public Builder flight_date(String value)
        {
            this.flight_date=value;
            return this;
        }

        public Builder price(int value)
        {
            this.price=value;
            return this;
        }
        public Builder seat_aval(int value)
        {
            this.seats_aval=value;
            return this;
        }
        public Builder copy(Flight_detailResource values)
        {
            this.flight_id=values.getFlight_id();
            this.flight_date=values.getFlight_date();
            this.seats_aval=values.getSeats_aval();
            this.price=values.getprice();
            return this;
        }
        public  Flight_detailResource build()
        {
            return new Flight_detailResource(this);
        }

    }
}
