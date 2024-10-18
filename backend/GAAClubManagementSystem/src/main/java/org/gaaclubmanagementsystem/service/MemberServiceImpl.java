package org.gaaclubmanagementsystem.service;

import org.gaaclubmanagementsystem.model.*;
import org.gaaclubmanagementsystem.repository.AboutPageRepository;
import org.gaaclubmanagementsystem.repository.ContactListRepository;
import org.gaaclubmanagementsystem.repository.EventRepository;
import org.gaaclubmanagementsystem.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private AboutPageRepository aboutPageRepository;
    @Autowired
    private ContactListRepository contactListRepository;

    @Override
    public void addNewMember(Member member) {
            this.memberRepository.save(member);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long event_id) {
        return eventRepository.findById(event_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid event id: " + event_id));
    }

    @Override
    public List<ContactList> getContactList() {
        return contactListRepository.findAll();
    }

    @Override
    public AboutPage getAboutPage(Long id) {
        return aboutPageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id" + id));
    }
}
