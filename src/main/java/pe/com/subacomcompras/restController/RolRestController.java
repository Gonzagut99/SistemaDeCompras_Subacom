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
import pe.com.subacomcompras.entity.RolEntity;
import pe.com.subacomcompras.service.seguridad.RolService;

@RestController
@RequestMapping("/rol_rest")

public class RolRestController {
    
    @Autowired
    private RolService servicio;
    
     
    @GetMapping
    public List<RolEntity> findAll() {
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
        public List<RolEntity> findAllCustom() {
        return servicio.findAllCustom();
    }
    
        
    @GetMapping("/{id}")
    public Optional<RolEntity> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }
    
    @PostMapping
    public RolEntity add(@RequestBody RolEntity c) {
        return servicio.add(c);
    }
    
    
    @PutMapping("{id}")
    public RolEntity update(@PathVariable Long id, @RequestBody RolEntity c) {
        c.setId_role(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("{id}")
    public RolEntity delete(@PathVariable Long id) {
        RolEntity objrol = new RolEntity();
        objrol.setEstado(false);
        return servicio.delete(RolEntity.builder().id_role(id).build());
    }
}
