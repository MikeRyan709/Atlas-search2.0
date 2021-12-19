package com.keyin.AtlasSearch.Model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 40)
    private String email;
    @Column(nullable = false, unique = true, length = 40)
    private String password;
    @Column(name = "first_name", nullable = false, length = 15)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 15)
    private String lastName;

    public User() {

    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
        this.firstName = null;
        this.lastName = null;
    }

    public long getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() {return password;}
    public String getLastName() {return lastName;}
    public String getFirstName() {return firstName;}

    public void setId(long id) {this.id = id;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
