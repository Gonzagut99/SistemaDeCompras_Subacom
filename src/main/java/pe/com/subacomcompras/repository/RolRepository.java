/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.subacomcompras.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.subacomcompras.entity.RolEntity;


public interface RolRepository extends JpaRepository<RolEntity, Long>{
    @Query("select r from RolEntity r where r.estado=true")
    List<RolEntity> findAllCustom();
}
