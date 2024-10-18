package org.gaaclubmanagementsystem.repository;

import org.gaaclubmanagementsystem.model.Member;
import org.gaaclubmanagementsystem.model.Membership;
import org.gaaclubmanagementsystem.model.abstractClasses.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m WHERE m.membership_type = :membership_type")
    List<Member> findAllByMembership_type(@Param("membership_type")MembershipType membership_type);
}
