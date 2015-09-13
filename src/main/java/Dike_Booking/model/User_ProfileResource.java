package Dike_Booking.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/13.
 */
public class User_ProfileResource extends ResourceSupport {
    private Integer user_id;
    private String password;
    private String name;
    private String surname;
    private String address;
    private String tel_no;
    private String email;

    private  User_ProfileResource()
    {

    }
    public Integer getUser_id()
    {
        return user_id;
    }

    public String getPassword()
    {
        return password;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }
    public String getAddress()
    {
        return address;
    }

    public String getTel_no()
    {
        return tel_no;
    }
    public String getEmail()
    {
        return email;
    }



    public User_ProfileResource(Builder builder){

        user_id=builder.user_id;
        password=builder.password;
        name=builder.name;
        surname=builder.surname;
        address=builder.address;
        tel_no=builder.tel_no;
        email=builder.tel_no;


    }
    public static class Builder{
        private Integer user_id;
        private String password;
        private String name;
        private String surname;
        private String address;
        private String tel_no;
        private String email;

        public Builder(Integer user_id)
        {
            this.user_id=user_id;

        }
        public Builder pass(String value)
        {
            this.password=value;
            return this;
        }

        public Builder name(String value)
        {
            this.name=value;
            return this;
        }

        public Builder surname(String value)
        {
            this.surname=value;
            return this;

        }

        public Builder address(String value)
        {
            this.address=value;
            return this;
        }
        public Builder tel(String value)
        {
            this.tel_no=value;
            return this;
        }
        public Builder email(String value)
        {
            this.email=value;
            return this;
        }
        public Builder copy(User_ProfileResource values)
        {
            this.user_id=values.getUser_id();
            this.name=values.getName();
            this.surname=values.getSurname();
            this.address=values.getAddress();
            this.email=values.getEmail();
            this.tel_no=values.getTel_no();
            this.password=values.getPassword();
            return this;
        }


        public  User_ProfileResource build()
        {
            return new User_ProfileResource (this);
        }

    }
}
