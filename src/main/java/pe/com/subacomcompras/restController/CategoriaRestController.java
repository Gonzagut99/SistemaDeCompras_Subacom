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
import pe.com.subacomcompras.entity.CategoriaEntity;
import pe.com.subacomcompras.entity.UsuarioEntity;
import pe.com.subacomcompras.service.gestion.CategoriaService;
import pe.com.subacomcompras.service.seguridad.UsuarioService;



@RestController
@RequestMapping("/categoria_rest")
public class CategoriaRestController {
    
    @Autowired
    private CategoriaService servicio;
    
     @GetMapping
    public List<CategoriaEntity> findAll() {
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
        public List<CategoriaEntity> findAllCustom() {
        return servicio.findAllCustom();
    }
    
        
    @GetMapping("/{id}")
    public Optional<CategoriaEntity> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }
    
    @PostMapping
    public CategoriaEntity add(@RequestBody CategoriaEntity c) {
        return servicio.add(c);
    }
    
    
    @PutMapping("{id}")
    public CategoriaEntity update(@PathVariable Long id, @RequestBody CategoriaEntity c) {
        c.setId_category(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("{id}")
    public CategoriaEntity delete(@PathVariable Long id) {
        CategoriaEntity objcategoria = new CategoriaEntity();
        objcategoria.setEstado(false);
        return servicio.delete(CategoriaEntity.builder().id_category(id).build());
    }
    
}
