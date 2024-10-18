package org.gaaclubmanagementsystem.repository;

import org.gaaclubmanagementsystem.model.AboutPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutPageRepository extends JpaRepository<AboutPage, Long> {
}
