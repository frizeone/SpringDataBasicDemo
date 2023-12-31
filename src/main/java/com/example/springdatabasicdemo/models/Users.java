package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class Users extends CreatedAndModified{

    @Column(name = "is_active")
    private Boolean is_active;



    @Column(name = "first_name")
    private String first_name;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "last_name")
    private String last_name;



    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;

    public Users(Boolean is_active, String first_name, String last_name, String password, String username) {
        this.is_active = is_active;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.username = username;
    }

    public Users() {
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }



    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "is_active=" + is_active +
                ", first_name='" + first_name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}
