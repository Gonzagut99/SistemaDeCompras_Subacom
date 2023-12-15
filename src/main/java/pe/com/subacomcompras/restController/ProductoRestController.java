/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.restController;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.subacomcompras.entity.ProductoEntity;
import pe.com.subacomcompras.service.gestion.ProductoService;

@RestController
@RequestMapping("/productosrest")
public class ProductoRestController {
    @Autowired
    private ProductoService servicio;
    
    @GetMapping
    public List<ProductoEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<ProductoEntity> findById(@PathVariable Long id){
        return servicio.findById(id);
    }
}
