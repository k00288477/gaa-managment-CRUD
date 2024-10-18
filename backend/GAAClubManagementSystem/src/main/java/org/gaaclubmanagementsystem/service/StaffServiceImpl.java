package org.gaaclubmanagementsystem.service;

import org.gaaclubmanagementsystem.model.*;
import org.gaaclubmanagementsystem.model.abstractClasses.MembershipType;
import org.gaaclubmanagementsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private MembershipRepository membershipRepository;
    @Autowired
    private AboutPageRepository aboutPageRepository;
    @Autowired
    private ContactListRepository contactListRepository;



    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public void addNewTeam(Team team) {
        this.teamRepository.save(team);
    }

    @Override
    public Team findTeamById(Long team_id) {
        return teamRepository.findById(team_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid team id:" + team_id));
    }

    @Override
    public void deleteTeamById(Long team_id) {
        this.teamRepository.deleteById(team_id);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> getAllMembersByMembershipType(MembershipType membership_type) {
        return memberRepository.findAllByMembership_type(membership_type);
    }

    @Override
    public void addNewMember(Member member) {
        this.memberRepository.save(member);
    }

    @Override
    public Member findMemberById(Long member_id) {
        return memberRepository.findById(member_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member id:" + member_id));
    }

    @Override
    public void deleteMemberById(Long member_id) {
        this.memberRepository.deleteById(member_id);
    }

    @Override
    public void updateMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public void addNewStaff(Staff staff) {
        this.staffRepository.save(staff);
    }

    @Override
    public Staff findStaffById(Long staff_id) {
        return staffRepository.findById(staff_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff id: " + staff_id));
    }

    @Override
    public void deleteStaffById(Long staff_id) {
        this.staffRepository.deleteById(staff_id);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public void addNewPlayer(Player player) {
        this.playerRepository.save(player);
    }

    @Override
    public Player findPlayerById(Long player_id) {
        return playerRepository.findById(player_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid player id: " + player_id));
    }

    @Override
    public void deletePlayerById(Long player_id) {
        this.playerRepository.deleteById(player_id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void addNewEvent(Event event) {
        this.eventRepository.save(event);
    }

    @Override
    public Event findEventById(Long event_id) {
        return eventRepository.findById(event_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid event id" + event_id));
    }

    @Override
    public void deleteEventById(Long event_id) {
        this.eventRepository.deleteById(event_id);
    }

    @Override
    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    @Override
    public AboutPage getAboutPage(Long id) {
        return aboutPageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id" + id));
    }

    @Override
    public void updateAboutPage(AboutPage aboutPage) {
        aboutPageRepository.save(aboutPage);
    }

    @Override
    public List<ContactList> getContactList() {
        return contactListRepository.findAll();
    }

    @Override
    public void addContact(ContactList contact) {
        this.contactListRepository.save(contact);
    }
}
