package org.gaaclubmanagementsystem.model;

import jakarta.persistence.*;
import org.gaaclubmanagementsystem.model.abstractClasses.Person;
import org.gaaclubmanagementsystem.model.abstractClasses.Register;

@Entity
public class Player extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long player_id;
    @Enumerated(EnumType.STRING)
    private Register registered;
    @ManyToOne
    @JoinColumn
    private Team team;

    public Player() {

    }

    public Register getRegistered() {
        return registered;
    }

    public void setRegistered(Register registered) {
        this.registered = registered;
    }

    public Long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Long player_id) {
        this.player_id = player_id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
