package com.summerintern.demo.service;

import com.summerintern.demo.model.Admin;
import com.summerintern.demo.model.Customer;
import com.summerintern.demo.repositary.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImp {

    @Autowired
    public AdminRepository adminRepository;


    //    @Override
    public Optional<Admin> getAdminById(int admin) {
        return adminRepository.findById(admin);
    }


    public List<Admin> getAllAdmin() {
        return (List<Admin>) adminRepository.findAll();
    }

    //    @Override
    public void deleteAdmin(Integer admin_id) {
        adminRepository.deleteById(admin_id);
    }

//    public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
//       return (ResponseEntity<Admin>) adminRepository.findById(admin.updateAdmin_id()).get();}
////        Admin updateAdmin = adminRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id: " + id));
//
//        updateAdmin.setAdmin_name(adminDetails.getAdmin_name());
//        updateAdmin.setAdmin_mail(adminDetails.getAdmin_mail());
//        updateAdmin.setLogin_id(adminDetails.getLogin_id());
//        adminRepository.save(updateAdmin);
//}
//    @Override


    public String existsByEmailandPassword(Admin admin) {
        if (adminRepository.existsByEmail(admin.getAdmin_mail()) > 0 ) {
            if (adminRepository.existsByPassword(admin.getAdmin_mail(), admin.getAdmin_password()) > 0) {

                List<Admin> user1 = adminRepository.findByEmail(admin.getAdmin_mail());

                System.out.println(user1.toString());

                String[] strArray = user1.toString().split(",");
                return "{ \"1\" : \"Logged in successfully\"}";
            }
            return "{ \"2\" : \"incorrect password\"}";
        }
        return "{ \"3\" : \"Email Id does not exist ;\"}" ;
    }

    public Admin createAdmin(Admin admin) {
        admin.setAdmin_id(adminRepository.findMaxId() + 1);
        return adminRepository.save(admin);
    }


}
