package org.gaaclubmanagementsystem.controller;

import org.gaaclubmanagementsystem.model.*;
import org.gaaclubmanagementsystem.service.MemberServiceImpl;
import org.gaaclubmanagementsystem.service.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
@RequestMapping("/api/gaaManagementSystem")
public class MainController {

    // ADMIN ENDPOINTS
    @Autowired
    private StaffServiceImpl staffService;

    // VIEWS
    @GetMapping("/events-list")
    public List<Event> getAllEvents() {
        return staffService.getAllEvents();
    }
    @GetMapping("/member-list")
    public List<Member> getAdminPortal() {
        return staffService.getAllMembers();
    }

    @GetMapping("/team-list")
    public List<Team> getTeamList() {
        return staffService.getAllTeams();
    }

    @GetMapping("/staff-list")
    public List<Staff> getStaffList(){
        return staffService.getAllStaff();
    }

    @GetMapping("/player-list")
    public List<Player> getPlayerList() {
        return staffService.getAllPlayers();
    }

    @GetMapping("/all-clubs")
    public List<Club> getAllClubs(){
        return staffService.getAllClubs();
    }

    @GetMapping("/all-membership-types")
    public List<Membership> geAllMembershipTypes(){
        return staffService.getAllMemberships();
    }

    // POST REQUESTS
    @PostMapping("/add-event")
    public ResponseEntity<String> addEvent(@RequestBody Event event){
        try {
            staffService.addNewEvent(event);
            return ResponseEntity.ok("Event added successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Event");
        }
    }

    @PostMapping("/add-staff")
    public ResponseEntity<String> addStaff(@RequestBody Staff staff){
        try {
            // TODO encrypt password

            //
            staffService.addNewStaff(staff);
            return ResponseEntity.ok("Staff added successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add staff");
        }

    }
    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.DELETE, RequestMethod.OPTIONS})
    @DeleteMapping("delete-staff/{staff_id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long staff_id){
        try {
            staffService.deleteStaffById(staff_id);
            return ResponseEntity.ok("Staff deleted successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete staff");
        }

    }

    @PostMapping("/add-team")
    public ResponseEntity<String> addTeam(@RequestBody Team team){
        try {
            staffService.addNewTeam(team);
            return ResponseEntity.ok("Team added successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add team");
        }
    }


    // UPDATE METHODS
    @GetMapping("/find-staff/{staff_id}")
    public Staff findStaff(@PathVariable Long staff_id){
        return staffService.findStaffById(staff_id);
    }
    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.PUT, RequestMethod.OPTIONS})
    @PutMapping("/update-staff/{staff_id}")
    public ResponseEntity<String> updateStaff(@PathVariable Long staff_id, @RequestBody Staff updatedStaff){
        System.out.println("Staff id: "+ staff_id);
        // find object by id
        Staff existingStaff = staffService.findStaffById(staff_id);
        // send response if not exists
        if(existingStaff == null){
            return ResponseEntity.notFound().build();
        }
        // update details
        existingStaff.setFirst_name(updatedStaff.getFirst_name());
        existingStaff.setLast_name(updatedStaff.getLast_name());
        existingStaff.setEmail(updatedStaff.getEmail());
        existingStaff.setDob(updatedStaff.getDob());
        existingStaff.setContact_no(updatedStaff.getContact_no());
        existingStaff.setAddress1(updatedStaff.getAddress1());
        existingStaff.setAddress2(updatedStaff.getAddress2());
        existingStaff.setAddress3(updatedStaff.getAddress3());
        existingStaff.setRole(updatedStaff.getRole());
        existingStaff.setPassword(updatedStaff.getPassword());

        // add th new details to the database
        staffService.updateStaff(existingStaff);

        return ResponseEntity.ok("Staff member updated successfully");

    }

    // update event
    @GetMapping("/find-event/{event_id}")
    public Event findEvent(@PathVariable Long event_id){
        return staffService.findEventById(event_id);
    }
    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.PUT, RequestMethod.OPTIONS})
    @PutMapping("/update-event/{event_id}")
    public ResponseEntity<String> updateEvent(@PathVariable Long event_id, @RequestBody Event updatedEvent) {
        // find object by id
        Event existingEvent = staffService.findEventById(event_id);
        // send response if not exists
        if (existingEvent == null) {
            return ResponseEntity.notFound().build();
        }
        // update details
        existingEvent.setName(updatedEvent.getName());
        existingEvent.setLocation(updatedEvent.getLocation());
        existingEvent.setType(updatedEvent.getType());
        existingEvent.setDate(updatedEvent.getDate());
        existingEvent.setTime(updatedEvent.getTime());
        existingEvent.setTicket_price(updatedEvent.getTicket_price());

        // add th new details to the database
        staffService.updateEvent(existingEvent);

        return ResponseEntity.ok("Event updated successfully");
    }
    // delete event
    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.DELETE, RequestMethod.OPTIONS})
    @DeleteMapping("delete-event/{event_id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long event_id){
        try {
            staffService.deleteEventById(event_id);
            return ResponseEntity.ok("Event deleted successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete event");
        }

    }

    @GetMapping("/get-about-page")
    public AboutPage getAboutPage(){
        Long id = 1L;
        return staffService.getAboutPage(id);
    }

    // update about page
    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.PUT, RequestMethod.OPTIONS})
    @PutMapping("/update-about-page/{about_id}")
    public ResponseEntity<String> updateAboutPage(@PathVariable Long about_id, @RequestBody AboutPage updatedPage){
        Long id = 1L;
        // get existing page
        AboutPage existingPage = staffService.getAboutPage(id);
        // update attributes
        existingPage.setHeading(updatedPage.getHeading());
        existingPage.setParagraph1(updatedPage.getParagraph1());
        existingPage.setParagraph2(updatedPage.getParagraph2());

        staffService.updateAboutPage(existingPage);

        return ResponseEntity.ok("About Page updated successfully");

    }

    // get contact list
    @GetMapping("/get-contact-list")
    public List<ContactList> getContactList(){
        return staffService.getContactList();
    }
    // add new contact
    @PostMapping("/add-contact")
    public ResponseEntity<String> addContact(@RequestBody ContactList contact){
        try {
            staffService.addContact(contact);
            return ResponseEntity.ok("Contact added successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add contact");
        }
    }

    // secure log in
    @PostMapping("/staff-login")
    public ResponseEntity<String> staffLogIn(@RequestBody Staff staff){
        return ResponseEntity.ok("");
    }


    @GetMapping("/find-member/{member_id}")
    public Member findMember(@PathVariable Long member_id){
        return staffService.findMemberById(member_id);
    }


    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.DELETE, RequestMethod.OPTIONS})
    @DeleteMapping("delete-member/{member_id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long member_id){
        try {
            staffService.deleteMemberById(member_id);
            return ResponseEntity.ok("Member deleted successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete member");
        }

    }
    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.PUT, RequestMethod.OPTIONS})
    @PutMapping("/update-member/{member_id}")
    public ResponseEntity<String> updateMember(@PathVariable Long member_id, @RequestBody Member member){
        // get existing page
        Member existingMember = staffService.findMemberById(member_id);
        // update attributes
        existingMember.setFirst_name(member.getFirst_name());
        existingMember.setLast_name(member.getLast_name());
        existingMember.setDob(member.getDob());
        existingMember.setContact_no(member.getContact_no());
        existingMember.setEmail(member.getEmail());
        existingMember.setAddress1(member.getAddress1());
        existingMember.setAddress2(member.getAddress2());
        existingMember.setAddress3(member.getAddress3());
        existingMember.setMembership(member.getMembership());

        staffService.updateMember(existingMember);
        return ResponseEntity.ok("Member updated successfully");
    }

}
