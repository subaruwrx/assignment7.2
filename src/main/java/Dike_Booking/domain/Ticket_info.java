package Dike_Booking.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@javax.persistence.Entity
public class Ticket_info implements Serializable{
    @Id
    @GeneratedValue
    private Integer tick_num;
    private String event_date;
    private String status;


    private Ticket_info()
    {

    }

    public Integer getTick_num()
    {
        return tick_num;
    }

    public String getEvent_date()
    {
        return event_date;
    }

    public String getStatus()
    {
        return status;
    }
    public Ticket_info (Builder builder){

        tick_num=builder.tick_num;
        event_date=builder.event_date;
        status=builder. status;



    }
    public static class Builder{
        private Integer tick_num;
        private String event_date;
        private String status;

        public Builder(Integer tick_num)
        {
            this.tick_num=tick_num;

        }
        public Builder event_date(String value)
        {
            this.event_date=value;
            return this;
        }

        public Builder status(String value)
        {
            this.status=value;
            return this;
        }
        public Builder copy(Ticket_info values)
        {
            this.tick_num=values.getTick_num();
            this.event_date=values.getEvent_date();
            this.status=values.getStatus();
            return this;

        }


        public  Ticket_info build()
        {
            return new  Ticket_info(this);
        }


    }
    @Override
    public String toString()
    {
        return String.format(" ticknum:" + tick_num +"date : "+ event_date);
    }

}
