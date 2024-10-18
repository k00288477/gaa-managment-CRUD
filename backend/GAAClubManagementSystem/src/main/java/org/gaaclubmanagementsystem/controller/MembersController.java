package org.gaaclubmanagementsystem.controller;

import org.gaaclubmanagementsystem.model.AboutPage;
import org.gaaclubmanagementsystem.model.ContactList;
import org.gaaclubmanagementsystem.model.Event;
import org.gaaclubmanagementsystem.model.Member;
import org.gaaclubmanagementsystem.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
@RequestMapping("/api/member-portal")
public class MembersController {


    @Autowired
    private MemberServiceImpl memberService;

    // VIEWS
    @GetMapping("/events-list")
    public List<Event> getAllEvents() {
        return memberService.getAllEvents();
    }

    @GetMapping("/event-details/{event_id}")
    public Event getEventDetails(@PathVariable(value = "event_id") Long event_id) {
        return memberService.getEventById(event_id);
    }

    // Register
    @PostMapping("/member-create-account")
    public ResponseEntity<String> addMember(@RequestBody Member member){
        try {
            memberService.addNewMember(member);
            return ResponseEntity.ok("Member added successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Member");
        }
    }

    @GetMapping("/get-about-page")
    public AboutPage getAboutPage(){
        Long id = 1L;
        return memberService.getAboutPage(id);
    }

    // get contact list
    @GetMapping("/get-contact-list")
    public List<ContactList> getContactList(){
        return memberService.getContactList();
    }
}
