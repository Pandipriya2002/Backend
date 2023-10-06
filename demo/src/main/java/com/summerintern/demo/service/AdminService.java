package com.summerintern.demo.service;

import com.summerintern.demo.model.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    Admin saveAdmin(Admin admin_info);

    List<Admin> getAllAdmin();

    Optional<Admin> getAdminById(Integer admin_id);

    List<Admin> getAllAdmins();

    void deleteAdmin(Integer admin_id);

    Admin updateAdmin(Integer admin_id, Admin updatedAdmin);
}