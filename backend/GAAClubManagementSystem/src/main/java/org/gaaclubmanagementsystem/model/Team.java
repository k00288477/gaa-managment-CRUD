package org.gaaclubmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.gaaclubmanagementsystem.model.abstractClasses.TeamLevel;
import org.gaaclubmanagementsystem.model.abstractClasses.TeamType;

import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long team_id;
    private String name;
    @Enumerated(EnumType.STRING)
    private TeamType type;
    @Enumerated(EnumType.STRING)
    private TeamLevel level;
    @ManyToOne
    @JoinColumn
    private Club club;
    @OneToMany(mappedBy = "team")
    @JsonIgnore // stops infinite loop when retrieving list
    private List<Player> players;


    public Team(){};


    public TeamLevel getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = TeamLevel.valueOf(level);
    }

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = TeamType.valueOf(type);
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
