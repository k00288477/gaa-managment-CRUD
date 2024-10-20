package org.gaaclubmanagementsystem.repository;

import org.gaaclubmanagementsystem.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
