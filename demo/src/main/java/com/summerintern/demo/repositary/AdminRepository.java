package com.summerintern.demo.repositary;

import com.summerintern.demo.model.Admin;
import com.summerintern.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin , Integer> {
    @Query("select coalesce(max(a.admin_id), 0) from Admin a")
    public Integer findMaxId();

    @Query(value = "select count(admin.admin_mail) from Admin admin where admin.admin_mail = ?1", nativeQuery = true)
    public int existsByEmail(String admin_mail);


    @Query(value = "select count(admin.admin_password) from Admin admin where admin.admin_mail = ?1 and admin.admin_password = ?2", nativeQuery = true)
    public int existsByPassword(String admin_mail, String admin_password);

    @Query(value = "select * from Admin admin where admin.admin_mail = ?1", nativeQuery = true)
    public List<Admin> findByEmail(String admin_mail);
}
