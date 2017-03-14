package com.maxpro.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    /*
     following line is responsible for infinite loop
     because Role call User, and User call Role
     Role-User-Role and forms an infinite loop
     that's why we comment out the following line
     used for users :
        - users
        - getUsers()
        - setUsers(Set<User> users); and
        - toString()
    */

    /*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", users=" + users +
                '}';
    }

}
