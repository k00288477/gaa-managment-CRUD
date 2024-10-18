package org.gaaclubmanagementsystem.service;

import org.gaaclubmanagementsystem.model.*;
import org.gaaclubmanagementsystem.model.abstractClasses.MembershipType;

import java.util.List;
import java.util.Optional;

public interface StaffService {

    // TEAMS
    List<Team> getAllTeams();
    void addNewTeam(Team team);
    Team findTeamById(Long team_id);
    void deleteTeamById(Long team_id);

    // MEMBERS
    List<Member> getAllMembers();
    List<Member> getAllMembersByMembershipType(MembershipType membership_type);
    void addNewMember(Member member);
    Member findMemberById(Long member_id);
    void deleteMemberById(Long member_id);
    void updateMember(Member member);


    // STAFF
    List<Staff> getAllStaff();
    void addNewStaff(Staff staff);
    Staff findStaffById(Long staff_id);
    void deleteStaffById(Long staff_id);
    void updateStaff(Staff staff);

    // PLAYERS
    List<Player> getAllPlayers();
    void addNewPlayer(Player player);
    Player findPlayerById(Long player_id);
    void deletePlayerById(Long player_id);

    // EVENTS
    List<Event> getAllEvents();
    void addNewEvent(Event event);
    Event findEventById(Long event_id);
    void deleteEventById(Long event_id);
    void updateEvent(Event event);

    // OTHER
    List<Club> getAllClubs();
    List<Membership> getAllMemberships();
    AboutPage getAboutPage(Long id);
    void updateAboutPage(AboutPage aboutPage);
    List<ContactList> getContactList();
    void addContact(ContactList contact);


}
