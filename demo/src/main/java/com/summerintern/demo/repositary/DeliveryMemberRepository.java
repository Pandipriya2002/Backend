package com.summerintern.demo.repositary;


import com.summerintern.demo.model.DeliveryMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryMemberRepository extends JpaRepository<DeliveryMember,Integer>
{
    @Query("select coalesce(max(a.dm_id), 0) from DeliveryMember a")
    public Integer findMaxId();
    @Query(value = "select count(deliver.dm_mail) from  deliver where deliver.dm_mail = ?1", nativeQuery = true)
    public int existsByEmail(String dm_mail);



   @Query(value = "select count(deliver.dm_password) from  deliver where deliver.dm_mail = ?1 and deliver.dm_password = ?2", nativeQuery = true)
    public int existsByPassword(String dm_mail, String dm_password);

    @Query(value = "select * from  deliver where deliver.dm_mail = ?1", nativeQuery = true)
    public List<DeliveryMember> findByEmail(String dm_mail);

}
