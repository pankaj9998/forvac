package com.company.repository;

//AdminRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
 Admin findByUsername(String username);
}
