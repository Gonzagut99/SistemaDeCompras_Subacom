/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.subacomcompras.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.subacomcompras.entity.ProductoEntity;


public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
    @Query("select p from ProductoEntity p")
    Page<ProductoEntity> findAllPageable(Pageable pageable);
    
    @Query("select p from ProductoEntity p where p.estado=true")
    Page<ProductoEntity> findAllCustomPageable(Pageable pageable);
    
    @Query("select p from ProductoEntity p where p.estado=true")
    List<ProductoEntity> findAllCustom();
}
