package com.keyin.AtlasSearch.Web;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "auth_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_user_id")
    private int id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
    private Set<Role> roles;
    //Get the ID
    public int getId() { return id; }
    //Get firstName
    public String getName() { return name; }
    //Get lastName
    public String getLastName() { return lastName; }
    //get Email
    public String getEmail() { return email; }
    //get password
    public String getPassword() { return password; }
    //get mobile
    public String getMobile() { return mobile; }
    //get status
    public String getStatus() { return status; }
    //get roles
    public Set<Role> getRoles() { return roles;}


    //Set the role
    public void setRoles(Set<Role> roles) { this.roles = roles; }
    //Set the ID
    public void setId(int id) { this.id = id; }
    //Set the First Name
    public void setName(String name) { this.name = name; }
    //Set the LastName
    public void setLastName(String lastName) { this.lastName = lastName; }
    //Set the Email
    public void setEmail(String email) { this.email = email; }
    //Set the Password
    public void setPassword(String password){ this.password = password; }
    //Set the Mobile
    public void setMobile(String mobile){ this.mobile = mobile; }
    //Set the status
    public void setStatus(String status) { this.status = status; }
}
