package com.summerintern.demo.service;

import com.summerintern.demo.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface CustomerService {

    Admin saveAdmin(Admin admin_info);

    List<Admin> getAllAdmin();

    Optional<Admin> getAdminById(Integer admin_id);

    List<Admin> getAllAdmins();

    void deleteAdmin(Integer admin_id);

    Admin updateAdmin(Integer admin_id, Admin updatedAdmin);
}
