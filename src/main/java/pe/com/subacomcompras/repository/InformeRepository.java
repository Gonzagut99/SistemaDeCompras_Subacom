/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.subacomcompras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.subacomcompras.entity.InformeEntity;

/**
 *
 * @author jaime
 */
public interface InformeRepository extends JpaRepository<InformeEntity, Long>{
    
}
