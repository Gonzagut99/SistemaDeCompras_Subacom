/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.subacomcompras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.subacomcompras.entity.ProveedorEntity;

/**
 *
 * @author jaime
 */
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long>{
    
}