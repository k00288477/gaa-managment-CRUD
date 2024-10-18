package org.gaaclubmanagementsystem.model;

import jakarta.persistence.*;
import org.gaaclubmanagementsystem.model.abstractClasses.MembershipType;
import org.gaaclubmanagementsystem.model.abstractClasses.Person;

@Entity
public class Member extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long member_id;
    private String password;
    @Enumerated(EnumType.STRING)
    private MembershipType membership_type;

    public Member(){};

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public MembershipType getMembership() {
        return membership_type;
    }

    public void setMembership(MembershipType membership) {
        this.membership_type = membership;
    }
}
