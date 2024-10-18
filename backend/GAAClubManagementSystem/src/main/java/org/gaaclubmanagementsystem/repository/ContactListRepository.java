package org.gaaclubmanagementsystem.repository;

import org.gaaclubmanagementsystem.model.ContactList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactListRepository extends JpaRepository<ContactList, Long> {
}
