package org.gaaclubmanagementsystem.repository;

import org.gaaclubmanagementsystem.model.Member;
import org.gaaclubmanagementsystem.model.Staff;
import org.gaaclubmanagementsystem.model.abstractClasses.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    @Query("SELECT s FROM Staff s WHERE s.email = :email")
    Staff findByEmail(@Param("email") String username);
}
