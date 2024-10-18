package org.gaaclubmanagementsystem.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Club {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private
    Long club_id;
    private String name;
    private String address1;
    private String address2;
    private String address3;
    private Date date_est;



    public Club(){};

    public Long getClub_id() {
        return club_id;
    }

    public void setClub_id(Long club_id) {
        this.club_id = club_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public Date getDate_est() {
        return date_est;
    }

    public void setDate_est(Date date_est) {
        this.date_est = date_est;
    }




}
