package com.summerintern.demo.controller;
import com.summerintern.demo.Exception.ResourceNotFoundException;
import com.summerintern.demo.model.Admin;
import com.summerintern.demo.model.Customer;
import com.summerintern.demo.repositary.AdminRepository;
import com.summerintern.demo.service.AdminServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


//import javax.transaction.Transactional;


@CrossOrigin()
@RestController
//@RequestMapping("/api/v1/admin_info")


public class AdminController {
    @Autowired
    private AdminServiceImp adminServiceImp;

    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/getAllAdmin")
    public List<Admin> GetAllAdmin(){
        return adminServiceImp.getAllAdmin();
    }

    // build create employee REST API
    @PostMapping("/AddAdmin")
    public Admin CreateAdmin(@RequestBody Admin admin)
    {
        return adminServiceImp.createAdmin(admin);
    }
    @Transactional
    @GetMapping("/getAdminById/{adminId}")
    public Optional<Admin> getAdminById(@PathVariable int adminId){
        System.out.println(adminServiceImp.getAdminById(adminId));
        return adminServiceImp.getAdminById(adminId);
    }


    @PutMapping("/PutAdmin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin adminDetails) {
        Admin updateAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id: " + id));

        updateAdmin.setAdmin_name(adminDetails.getAdmin_name());
        updateAdmin.setAdmin_mail(adminDetails.getAdmin_mail());
        adminRepository.save(updateAdmin);
        return ResponseEntity.ok(updateAdmin);
    }




//    @PutMapping("/UpdateAdmin/{id}")
//    public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
//        updateAdmin.setAdmin_name(admin.getAdmin_name());
//        updateAdmin.setAdmin_mail(admin.getAdmin_mail());
//        updateAdmin.setLogin_id(admin.getLogin_id());
//        adminRepository.save(updateAdmin);
//        return ResponseEntity.ok(updateAdmin);
////        Admin updateAdmin = adminRepository.findById(id)
////                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id: " + id));
//        System.out.println(adminServiceImp.updateAdmin_id(admin));
//        return adminServiceImp.updateAdminById(admin);
//
//    }

    @DeleteMapping("/DeleteAdmin/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable int id){

        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        adminRepository.delete(admin);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @Transactional
    @PostMapping("/login1")
    public String admin(@RequestBody Admin admin) {

        return adminServiceImp.existsByEmailandPassword(admin);
    }
}
