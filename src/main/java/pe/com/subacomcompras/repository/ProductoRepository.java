/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.subacomcompras.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.subacomcompras.entity.ProductoEntity;


public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
    @Query("select p from ProductoEntity p where p.estado=true")
    List<ProductoEntity> findAllCustom();
}
