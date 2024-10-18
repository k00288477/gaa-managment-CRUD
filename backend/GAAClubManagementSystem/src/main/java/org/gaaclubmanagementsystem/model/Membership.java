package org.gaaclubmanagementsystem.model;

import jakarta.persistence.*;
import org.gaaclubmanagementsystem.model.abstractClasses.MembershipType;

import java.util.List;

@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long membership_id;

    @Enumerated(EnumType.STRING)
    private MembershipType membership_type;

    @OneToMany(mappedBy = "membership_type")
    private List<Member> members;

    public Membership(){};

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Long getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(Long membership_id) {
        this.membership_id = membership_id;
    }

    public MembershipType getMembership_type() {
        return membership_type;
    }

    public void setMembership_type(MembershipType membership_type) {
        this.membership_type = membership_type;
    }
}
