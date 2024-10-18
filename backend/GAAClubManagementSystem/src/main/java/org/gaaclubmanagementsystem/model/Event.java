package org.gaaclubmanagementsystem.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalTime;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private
    Long event_id;
    private String name;
    private String location;
    private String type;
    private Date date;
    private LocalTime time;
    private BigDecimal ticket_price;


    public Event(){};

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


//    public Staff getOrganiser() {
//        return organiser;
//    }
//
//    public void setOrganiser(Staff organiser) {
//        this.organiser = organiser;
//    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(BigDecimal ticket_price) {
        this.ticket_price = ticket_price;
    }
}
