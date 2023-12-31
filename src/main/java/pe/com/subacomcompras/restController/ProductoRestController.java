/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.restController;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("/custom")
    public List<ProductoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }
    
    
    @GetMapping("/{id}")
    public Optional<ProductoEntity> findById(@PathVariable Long id){
        return servicio.findById(id);
    }
    

    @PostMapping
    public ProductoEntity add(@RequestBody ProductoEntity c) {
        return servicio.add(c);
    }
    
    
    @PutMapping("{id}")
    public ProductoEntity update(@PathVariable Long id, @RequestBody ProductoEntity c) {
        c.setId_product(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("{id}")
    public ProductoEntity delete(@PathVariable Long id) {
        ProductoEntity objproducto = new ProductoEntity();
        objproducto.setEstado(false);
        return servicio.delete(ProductoEntity.builder().id_product(id).build());
    }
}
