package com.company.services;

//AdminServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.Admin;
import com.company.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
 
 @Autowired
 private AdminRepository adminRepository;
 
 @Override
 public boolean isValidAdmin(String username, String password) {
     Admin admin = adminRepository.findByUsername(username);
     return admin != null && admin.getPassword().equals(password);
 }
}
