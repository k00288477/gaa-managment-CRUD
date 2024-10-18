package org.gaaclubmanagementsystem.model;

import jakarta.persistence.*;
import org.gaaclubmanagementsystem.model.abstractClasses.Person;

@Entity
public class Staff extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private
    Long staff_id;
    private String role;
    private String password;



    public Staff() {
    }

    public Long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
