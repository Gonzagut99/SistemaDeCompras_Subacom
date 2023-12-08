/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.subacomcompras.service.gestion.PedidoService;

@Controller
public class PedidoController {
    @Autowired
    private PedidoService servicio;
    
    @GetMapping("/pedidos")
    public String MostrarRol(Model modelo){
        modelo.addAttribute("pedidos",servicio.findAllCustom());
        return "Pedidos/pedidos";
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
