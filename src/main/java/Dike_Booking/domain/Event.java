package Dike_Booking.domain;



import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@javax.persistence.Entity
public class Event implements Serializable {
    @Id
    @GeneratedValue
    private Long event_id;
    private String event_name;
    private String event_type;
    private String place;
    private int price;
    private String date;
    //@ManyToMany
    //@JoinTable(name="music")
    //private int music_id;






    private Event()
    {

    }

    public Event(Builder builder)
    {
        event_id=builder.event_id;
        event_name=builder.event_name;
        event_type=builder.event_type;
        place=builder.place;
        price=builder.price;
        date=builder.date;


    }

    public Long getEvent_id()
    {
        return event_id;
    }

    public String getEvent_name()
    {
        return event_name;
    }

    public String getEvent_type()
    {
        return event_type;
    }

    public String getPlace()
    {
        return place;
    }

    public int getPrice()
    {
        return price;
    }
    public String getDate()
    {
        return date;
    }

    public static class Builder{
        private Long event_id;
        private String event_name;
        private String event_type;
        private String place;
        private int price;
        private String date;


        public Builder(String event_type)
        {
            this.event_type=event_type;

        }

        public Builder name(String event_name)
        {
            this.event_name=event_name;
            return this;
        }

        public Builder event_id(Long event_id)
        {
            this.event_id=event_id;
            return this;
        }
        public Builder place(String value)
        {
            this.place=value;
            return this;
        }
        public Builder price(int value)
        {
            this.price=value;
            return this;
        }
        public Builder date(String value)
        {
            this.date=value;
            return this;
        }
        public Builder copy(Event value)
        {
            this.event_id=value.getEvent_id();
            this.event_name=value.getEvent_name();
            this.event_type=value.getEvent_type();
            this.place=value.getPlace();
            this.price=value.getPrice();
            this.date=value.getDate();

            return this;
        }

        public Event build()
        {
            return new Event(this);
        }


    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(!(o instanceof Event))
            return false;
        Event event =(Event) o;
        return !(event_id != null ?equals(event.event_id): event.event_id != null);
    }
    @Override
    public int hashCode()
    {
        return event_id!=null ? event_id.hashCode() :0;
    }

    @Override
    public String toString()
    {
        return String.format("Event_id" +event_id + "Event Name: " +event_name);
    }






}
