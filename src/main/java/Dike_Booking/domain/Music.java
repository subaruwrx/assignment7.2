package Dike_Booking.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@Entity
public class Music implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(unique = true)
    private Integer music_id;
    private String music_type;
    private String artist;


    private Music()
    {

    }
    public Integer getMusic_id()
    {
        return music_id;
    }

    public String getMusic_type()
    {
        return music_type;
    }


    public String getArtist()
    {
        return artist;
    }


    public Music (Builder builder){

        music_type=builder.music_type;
        music_id=builder.music_id;
        artist=builder.artist;


    }
    public static class Builder{
        private String music_type;
        private Integer music_id;
        private String artist;


        public Builder(String music_type)
        {
            this.music_type=music_type;

        }
        public Builder music_id(Integer value)
        {
            this.music_id=value;
            return this;
        }


        public Builder artist(String value)
        {
            this.artist=value;
            return this;

        }


        public Builder copy(Music values)
        {
            this.music_type=values.getMusic_type();
            this.artist=values.getArtist();
            this.music_id=values.getMusic_id();

            return this;
        }

        public Music build()
        {
            return new Music(this);
        }

    }
    @Override
    public String toString()
    {
        return String.format("music type :" + music_type +"artist: "+ artist);
    }


}
