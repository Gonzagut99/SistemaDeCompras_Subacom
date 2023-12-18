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
import pe.com.subacomcompras.entity.ProveedorEntity;
import pe.com.subacomcompras.entity.UsuarioEntity;
import pe.com.subacomcompras.service.gestion.ProveedorService;


@RestController
@RequestMapping("/proveedor_rest")
public class ProveedorRestController {
    
    @Autowired
    private ProveedorService servicio;
    
     @GetMapping
    public List<ProveedorEntity> findAll() {
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
        public List<ProveedorEntity> findAllCustom() {
        return servicio.findAllCustom();
    }
    
        
    @GetMapping("/{id}")
    public Optional<ProveedorEntity> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }
    
    @PostMapping
    public ProveedorEntity add(@RequestBody ProveedorEntity c) {
        return servicio.add(c);
    }
    
    
    @PutMapping("{id}")
    public ProveedorEntity update(@PathVariable Long id, @RequestBody ProveedorEntity c) {
        c.setId_supplier(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("{id}")
    public ProveedorEntity delete(@PathVariable Long id) {
        ProveedorEntity objproveedor = new ProveedorEntity();
        objproveedor.setEstado(false);
        return servicio.delete(ProveedorEntity.builder().id_supplier(id).build());
    }
    
}
