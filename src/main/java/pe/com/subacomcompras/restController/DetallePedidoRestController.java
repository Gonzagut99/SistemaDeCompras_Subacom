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
import pe.com.subacomcompras.entity.DetallePedidoEntity;
import pe.com.subacomcompras.entity.EmpleadoEntity;
import pe.com.subacomcompras.entity.UsuarioEntity;
import pe.com.subacomcompras.service.gestion.DetallePedidoService;


@RestController
@RequestMapping("/detallepedido_rest")
public class DetallePedidoRestController {
    
    @Autowired
    private DetallePedidoService servicio;
    
     @GetMapping
    public List<DetallePedidoEntity> findAll() {
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
        public List<DetallePedidoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }
    
        
    @GetMapping("/{id}")
    public Optional<DetallePedidoEntity> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }
    
    @PostMapping
    public DetallePedidoEntity add(@RequestBody DetallePedidoEntity c) {
        return servicio.add(c);
    }
    
    
    @PutMapping("{id}")
    public DetallePedidoEntity update(@PathVariable Long id, @RequestBody DetallePedidoEntity c) {
        c.setId_orderdetail(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("{id}")
    public DetallePedidoEntity delete(@PathVariable Long id) {
        DetallePedidoEntity objdetalleproducto = new DetallePedidoEntity();
        objdetalleproducto.setEstado(false);
        return servicio.delete(DetallePedidoEntity.builder().id_orderdetail(id).build());
    }
    
}
