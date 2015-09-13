package Dike_Booking.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@javax.persistence.Entity
public class User_profile implements Serializable {
    @Id
    @GeneratedValue
    private Integer user_id;
    private String password;
    private String name;
    private String surname;
    private String address;
    private String tel_no;
    private String email;

   private  User_profile()
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



    public User_profile (Builder builder){

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
        public Builder copy(User_profile values)
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


        public  User_profile build()
        {
            return new  User_profile (this);
        }

    }
    @Override
    public String toString()
    {
        return String.format(" name :" + name+"surname: "+ surname);
    }



}
