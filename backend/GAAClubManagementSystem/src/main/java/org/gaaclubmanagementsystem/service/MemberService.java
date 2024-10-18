package org.gaaclubmanagementsystem.service;

import org.gaaclubmanagementsystem.model.AboutPage;
import org.gaaclubmanagementsystem.model.ContactList;
import org.gaaclubmanagementsystem.model.Event;
import org.gaaclubmanagementsystem.model.Member;

import java.util.List;

public interface MemberService {
    // add new member
    void addNewMember(Member member);

    // retrieve all events
    List<Event> getAllEvents();

    // retrieve event details
    Event getEventById(Long event_id);

    List<ContactList> getContactList();

    AboutPage getAboutPage(Long id);
}
