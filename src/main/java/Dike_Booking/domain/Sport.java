package Dike_Booking.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@javax.persistence.Entity

public class Sport  implements Serializable {
    @Id
    @GeneratedValue
    private Integer sport_id;
    private String sport_type;
    private String team;


    public String getSport_type()
    {
        return sport_type;
    }

    public String getTeam()
    {
        return team;
    }
    public Integer getSport_id()  {return sport_id;}
    public Sport()
    {

    }
    public Sport (Builder builder){

        sport_type=builder.sport_type;
        sport_id=builder.sport_id;
        team=builder.team;



    }
    public static class Builder{
        private String sport_type;
        private String team;
        private Integer sport_id;

        public Builder(String sport_type)
        {
            this.sport_type=sport_type;

        }
        public Builder copy(Sport value)
        {
            this.sport_type=value.getSport_type();
            this.team=value.getTeam();
            this.sport_id=value.getSport_id();
            return this;
        }

       public Builder sport_id(Integer value)
       {
           this.sport_id=value;
           return this;
       }

        public Builder team(String value)
        {
            this.team=value;
            return this;

        }


        public Sport build()
        {
            return new Sport(this);
        }

    }
    @Override
    public String toString()
    {
        return String.format(" type of sport:" + sport_type +"team: "+ team);
    }

}
