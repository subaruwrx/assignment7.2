package Dike_Booking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@Entity
public class Bus_details implements Serializable{
    @Id
    @GeneratedValue
    private Integer trip_id;
    private String bus_name;
    private String trip_date;
    private int price;
    private int seats_aval;

    private Bus_details()
    {

    }
    public Integer getTrip_id(){return trip_id;}
    public String getBus_name()
    {
        return bus_name;
    }

    public String getTrip_date()
    {
        return  trip_date;
    }

    public int getPrice()
    {
        return price;
    }

    public int getSeats_aval()
    {
        return seats_aval;
    }
    public  Bus_details(Builder builder){
        trip_id=builder.trip_id;
        bus_name=builder.bus_name;
        trip_date=builder.trip_date;
        price=builder.price;
        seats_aval=builder.seats_aval;

    }
    public static class Builder{
        private Integer trip_id;
        private String bus_name;
        private String trip_date;
        private int price;
        private int seats_aval;

        public Builder(String bus_name)
        {
            this.bus_name=bus_name;

        }
        public Builder trip_date(String value)
        {
            this.trip_date=value;
            return this;
        }
        public Builder trip_id(Integer value)
        {
            this.trip_id=value;
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
        public Builder copy( Bus_details values)
        {
            this.trip_id=values.getTrip_id();
            this.bus_name=values.getBus_name();
            this.price=values.getPrice();
            this.seats_aval=values.getSeats_aval();
            this.trip_date=values.getTrip_date();
            return this;
        }
        public  Bus_details build()
        {
            return new Bus_details(this);
        }

    }
    @Override
    public String toString()
    {
        return String.format(" bus name :" +bus_name );
    }
}
