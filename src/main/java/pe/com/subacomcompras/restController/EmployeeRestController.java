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
import pe.com.subacomcompras.entity.EmpleadoEntity;
import pe.com.subacomcompras.entity.UsuarioEntity;
import pe.com.subacomcompras.service.seguridad.EmpleadoService;

@RestController
@RequestMapping("/employeeRest")
public class EmployeeRestController {
    @Autowired
    private EmpleadoService servicio;
    
    @GetMapping("/{id}")
    public Optional<EmpleadoEntity> findById(@PathVariable Long id){
        return servicio.findById(id);
    }
    
    @GetMapping
    public List<EmpleadoEntity> findAll() {
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
        public List<EmpleadoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }
    
        
    
    @PostMapping
    public EmpleadoEntity add(@RequestBody EmpleadoEntity c) {
        return servicio.add(c);
    }
    
    
    @PutMapping("{id}")
    public EmpleadoEntity update(@PathVariable Long id, @RequestBody EmpleadoEntity c) {
        c.setId_employee(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("{id}")
    public EmpleadoEntity delete(@PathVariable Long id) {
        EmpleadoEntity objempleado = new EmpleadoEntity();
        objempleado.setEstado(false);
        return servicio.delete(EmpleadoEntity.builder().id_employee(id).build());
    }
    
    
}
