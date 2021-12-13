package com.keyin.AtlasSearch.Web;


import javax.persistence.*;

@Entity
@Table(name = "auth_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_role_id")
    private int id;

    @Column(name = "role_name")
    private String role;

    @Column(name = "role_desc")
    private String desc;

    //get the ID
    public int getId() { return id; }
    //Get the Role
    public String getRole() { return role; }
    //Get the description
    public String getDesc() { return desc; }

    //Set the ID
    public void setId(int id) { this.id = id; }
    //set the Role
    public void setRole(String role) { this.role = role; }
    //Set the description
    public void setDesc(String desc) { this.desc = desc; }


}
