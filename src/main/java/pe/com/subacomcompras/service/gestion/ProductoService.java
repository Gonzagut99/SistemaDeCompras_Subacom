/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.subacomcompras.service.gestion;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.com.subacomcompras.entity.ProductoEntity;
import pe.com.subacomcompras.service.generico.GenericoService;

public interface ProductoService extends GenericoService<ProductoEntity>{
    Page<ProductoEntity> findAllCustomPaginated(Pageable pageable);
    
    Page<ProductoEntity> findAllPaginated(Pageable pageable);
}
