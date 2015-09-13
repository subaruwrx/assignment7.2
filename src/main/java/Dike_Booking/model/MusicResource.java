package Dike_Booking.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/08/24.
 */
public class MusicResource extends ResourceSupport {
    private Integer music_id;
    private String music_type;
    private String artist;

    public MusicResource()
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


    public MusicResource (Builder builder){

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


        public Builder copy(MusicResource values)
        {
            this.music_type=values.getMusic_type();
            this.artist=values.getArtist();
            this.music_id=values.getMusic_id();

            return this;
        }

        public MusicResource build()
        {
            return new MusicResource(this);
        }

    }

}
