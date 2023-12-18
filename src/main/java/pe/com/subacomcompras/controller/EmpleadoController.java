/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.com.subacomcompras.entity.EmpleadoEntity;
import pe.com.subacomcompras.entity.UsuarioEntity;
import pe.com.subacomcompras.service.seguridad.EmpleadoService;
import pe.com.subacomcompras.service.seguridad.RolService;
import pe.com.subacomcompras.service.seguridad.UsuarioService;

@Controller
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoServicio;
    
    @Autowired
    private UsuarioService usuarioServicio;
    
    @Autowired
    private RolService rolServicio;
    
    @GetMapping("/empleado")
    public String MostrarRol(Model modelo){
        modelo.addAttribute("empleados",empleadoServicio.findAll());
        modelo.addAttribute("usuarios",usuarioServicio.findAll());
        modelo.addAttribute("empleado",new EmpleadoEntity());
        modelo.addAttribute("usuario",new UsuarioEntity());
        modelo.addAttribute("roles",rolServicio.findAllCustom());
        return "Empleado/empleado";
    }
    
    @GetMapping("/actualizarusuariopage/{id}")
    public String MostrarActualizarUsuarioPage(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("usuario",
                usuarioServicio.findById(id).get());
        modelo.addAttribute("roles",rolServicio.findAllCustom());
        
        return "Empleado/actualizarUsuario";
    }
    
    @GetMapping("/eliminarusuario/{id}")
    public String EliminarUsuario(@PathVariable Long id) {
        UsuarioEntity objrol = usuarioServicio.findById(id).get();
        if (objrol.isEstado()) {
            usuarioServicio.delete(objrol);
        }else{
            usuarioServicio.enable(objrol);
        }
   
        return "redirect:/empleado";
    }
    
    @GetMapping("/actualizarempleadopage/{id}")
    public String MostrarActualizarEmpleadoPage(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("empleado",
                empleadoServicio.findById(id).get());
        modelo.addAttribute("usuarios",usuarioServicio.findAllCustom());
        
        return "Empleado/actualizarEmpleado";
    }
    
    @GetMapping("/eliminarempleado/{id}")
    public String EliminarEmpleado(@PathVariable Long id) {
        EmpleadoEntity objrol = empleadoServicio.findById(id).get();
        if (objrol.isEstado()) {
            empleadoServicio.delete(objrol);
        }else{
            empleadoServicio.enable(objrol);
        }
   
        return "redirect:/empleado";
    }
    
    /*@GetMapping("/registrarrol")
    public String MostrarRegistrarRol(){
        return "rol/registrarrol";
    }
    
    @ModelAttribute("rol")
    public RolEntity ModeloRol(){
        return new RolEntity();
    }
    
    @PostMapping("/registrarrol")
    public String RegistrarRol(
            @ModelAttribute("rol")
            RolEntity r
    
    ){
        servicio.add(r);
        return "redirect:/rol";
    }
    
    @GetMapping("/actualizarrol/{id}")
    public String MostrarAtualizarRol(@PathVariable Long id, Model modelo){
        modelo.addAttribute("roles",servicio.findById(id).get());
        return "rol/actualizarrol";
    }
    
    @PostMapping("/actualizarrol/{id}")
    public String AtualizarRol(@PathVariable Long id, @ModelAttribute("rol")
            RolEntity r){
        servicio.update(r);
        return "redirect:/rol";
    }
    
    @GetMapping("/eliminarrol/{id}")
    public String EliminararRol(@PathVariable Long id){
        RolEntity objrol = servicio.findById(id).get();
        servicio.delete(objrol);
        return "redirect:/rol";
    }
    
    @GetMapping("/habilitacionrol")
    public String MostrarHabilitarRol(Model modelo) {
        modelo.addAttribute("roles",
                servicio.findAll());
        return "rol/habilitarrol";
    }

    @GetMapping("/habilitarrol/{id}")
    public String HabilitarRol(@PathVariable Long id) {
        RolEntity objrol = servicio.findById(id).get();
        servicio.enable(objrol);
        return "redirect:/rol";
    }

    @GetMapping("/deshabilitarrol/{id}")
    public String DeshabilitarRol(@PathVariable Long id) {
        RolEntity objrol = servicio.findById(id).get();
        servicio.delete(objrol);
        return "redirect:/rol";
    }*/
}
