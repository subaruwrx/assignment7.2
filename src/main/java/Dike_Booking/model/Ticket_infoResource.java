package Dike_Booking.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/13.
 */
public class Ticket_infoResource extends ResourceSupport {
    private Integer tick_num;
    private String event_date;
    private String status;


    private Ticket_infoResource ()
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
    public Ticket_infoResource  (Builder builder){

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
        public Builder copy(Ticket_infoResource  values)
        {
            this.tick_num=values.getTick_num();
            this.event_date=values.getEvent_date();
            this.status=values.getStatus();
            return this;

        }


        public  Ticket_infoResource  build()
        {
            return new Ticket_infoResource (this);
        }


    }
}
